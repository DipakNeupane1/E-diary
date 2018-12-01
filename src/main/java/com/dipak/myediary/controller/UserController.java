package com.dipak.myediary.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dipak.myediary.model.User;
import com.dipak.myediary.service.UserService;
import com.dipak.myediary.util.EmailUtil;
import com.dipak.myediary.util.ImageUtil;
import com.dipak.myediary.util.ProjectUtil;

@Controller
public class UserController {

	final String fromAddress = "dipakneupane805@gmail.com";
	@Autowired
	private MailSender mailSender;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(HttpSession session, Model model, HttpServletRequest request) {
		session.invalidate();
		model.addAttribute("message", "You Are Successfully Log Out!!!");
		return "login";

	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String getuserForm() {
		return "userForm";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getLandingPage() {
		return "LandingPage";
	}

	@RequestMapping(value = "landing_page", method = RequestMethod.GET)
	public String getHomepage() {
		return "LandingPage";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHomePage() {
		return "home";
	}

	@RequestMapping(value = "contactUs", method = RequestMethod.GET)
	public String getContactPage() {
		return "contactUs";
	}

	@RequestMapping(value = "AboutUs", method = RequestMethod.GET)
	public String getAboutUsPage() {
		return "AboutUs";
	}

	@RequestMapping(value = "/login_user", method = RequestMethod.POST)
	public String loginPost(@RequestParam Map<String, String> loginData, Model model, HttpSession session,
			HttpServletResponse response) {
		String userName = loginData.get("uname");
		String password = loginData.get("pass");
		String rememberMe = loginData.get("rememberMe");
		User id = userService.login(userName, password);
		// int id = userService.getUserProfileByName(userName, password);

		if (id != null) {
			int idd = id.getId();
			session.setAttribute("username", userName);
			session.setAttribute("id", idd);
			String imageUrl = id.getImageUrl();
			session.setAttribute("image", imageUrl);
			if (rememberMe != null) {
				Cookie cookie1 = new Cookie("uname", userName);
				Cookie cookie2 = new Cookie("pass", password);
				cookie1.setMaxAge(24 * 60 * 60);
				cookie2.setMaxAge(24 * 60 * 60);

				response.addCookie(cookie1);
				response.addCookie(cookie2);
				return "redirect:/home";
			} else {
				return "redirect:/home";
			}

		} else {
			model.addAttribute("message", "Sorry,UserName or Password Incorrect!!!");
			return "login";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getUserLoginForm() {
		return "login";
	}

	@RequestMapping(value = "/change_pic", method = RequestMethod.GET)
	public String updatepicture(@RequestParam int id, Model model) {
		model.addAttribute("update", userService.getUserById(id));
		return "userUpdateForm";
	}

	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
	public String updatePassword(@RequestParam String toAddress) {
		User user = userService.getUserByEmail(toAddress);
		if (user.getEmail() != null) {
			String newPassword = ProjectUtil.newPassword();
			String msgBody = "New password is" + newPassword;
			user.setPassword(newPassword);
			userService.saveUserInfo(user);
			EmailUtil.sendEmail(mailSender, toAddress, fromAddress, "ForgetPassword", msgBody);
		}
		return "redirect:/login";

	}

	@RequestMapping(value = "/save_user", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute User user, @RequestParam CommonsMultipartFile file, Model model) {
		String imageUrl = "";
		String userName = user.getUserName();
		String email = user.getEmail();
		User name = userService.login(user.getUserName(), user.getPassword());
		if (name != null) {
			if (name.getUserName().equalsIgnoreCase(userName) && name.getEmail().equalsIgnoreCase(email)) {
				model.addAttribute("error", "same username or email is already entered");
				return "userForm";
			}
		} else {
			if (file.getOriginalFilename().isEmpty()) {
				imageUrl = "";
			} else {
				imageUrl = ImageUtil.writeImageToFile(file);
			}
			user.setImageUrl(imageUrl);
			userService.saveUserInfo(user);

		}
		return "redirect:/login";

	}

	@RequestMapping(value = "/update_user", method = RequestMethod.POST)
	public String upateUser(@RequestParam CommonsMultipartFile file, @RequestParam int id, @ModelAttribute User user) {
		String imageUrl = "";
		String firstName = userService.getUserById(id).getFirstName();
		String lastName = userService.getUserById(id).getLastName();
		String address = userService.getUserById(id).getAddress();
		String email = userService.getUserById(id).getEmail();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setAddress(address);
		user.setEmail(email);
		if (file.getOriginalFilename().isEmpty()) {
			imageUrl = userService.getUserById(id).getImageUrl();
		} else {
			imageUrl = ImageUtil.writeImageToFile(file);
		}
		user.setImageUrl(imageUrl);
		userService.saveUserInfo(user);

		return "redirect:/login";

	}
}
