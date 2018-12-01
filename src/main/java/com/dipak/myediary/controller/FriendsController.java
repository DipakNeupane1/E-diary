package com.dipak.myediary.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dipak.myediary.model.Friends;
import com.dipak.myediary.service.FriendsService;
import com.dipak.myediary.util.ImageUtil;

@Controller
public class FriendsController {

	@Autowired
	private FriendsService friendsService;

	@RequestMapping(value = "/friends", method = RequestMethod.GET)
	public String getFriendsForm(Model model,HttpSession session) {
		int id=(int) session.getAttribute("id");
		model.addAttribute("friends", friendsService.getFriendsByFid(id));
		// model.addAttribute("friends",friends);
		return "friendList";
	}

	@RequestMapping(value = "/birthdays", method = RequestMethod.GET)
	public String getFriendsBirthday(Model model,HttpSession session) {
		int id=(int) session.getAttribute("id");
		model.addAttribute("birthdays", friendsService.getFriendsByFid(id));
		return "birthdayList";

	}

	@RequestMapping(value = "/addfriend", method = RequestMethod.GET)
	public String getAddFriendsForm() {
		return "friendForm";
	}

	@RequestMapping(value = "/friend_delete", method = RequestMethod.GET)
	public String getDeleteFriends(@RequestParam int fid) {
		friendsService.deleteFriendsInfo(fid);
		return "redirect:/friends";

	}

	@RequestMapping(value = "/friend_save", method = RequestMethod.POST)
	public String AddFriend(@ModelAttribute Friends friends, @RequestParam CommonsMultipartFile file,HttpSession session) {
		int id=(int) session.getAttribute("id");
		friends.setId(id);
		String imageUrl = ImageUtil.writeImageToFile(file);
		friends.setImageUrl(imageUrl);
		friendsService.saveFriends(friends);
		return "redirect:/friends";
	}

	@RequestMapping(value = "/friend_edit", method = RequestMethod.GET)
	public String getEditFriend(@RequestParam int fid, Model model) {
		model.addAttribute("friend", friendsService.getFriendByFid(fid));
		return "friendEditForm";

	}

	@RequestMapping(value = "/friend_update", method = RequestMethod.POST)
	public String updateFriend(@ModelAttribute Friends friends, @RequestParam CommonsMultipartFile file,
			@RequestParam int fid) {
		String imageUrl = "";
		if (file.getOriginalFilename().isEmpty()) {
			imageUrl = friendsService.getFriendByFid(fid).getImageUrl();
		} else {
			imageUrl = ImageUtil.writeImageToFile(file);
		}
		friends.setImageUrl(imageUrl);
		friendsService.updateFriends(friends);
		return "redirect:/friends";

	}
}
