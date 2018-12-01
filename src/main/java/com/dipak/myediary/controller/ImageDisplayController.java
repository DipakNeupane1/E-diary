package com.dipak.myediary.controller;





import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dipak.myediary.service.FriendsService;

@Controller
public class ImageDisplayController {

	@Autowired
	private com.dipak.myediary.service.UserService userService;
	@Autowired
	private FriendsService friendsService;

	@RequestMapping(value = "/user_display_image", method = RequestMethod.GET)
	public void userdisplayImage(@RequestParam int id, HttpServletRequest request, HttpServletResponse response) {
		String imageUrl = userService.getUserById(id).getImageUrl();
		com.dipak.myediary.util.ImageUtil.displayImage(id, imageUrl, request, response);
	}

	@RequestMapping(value = "/friend_display_image", method = RequestMethod.GET)
	public void studentdisplayImage(@RequestParam int fid, HttpServletRequest request, HttpServletResponse response) {
		String imageUrl=friendsService.getFriendByFid(fid).getImageUrl();
			com.dipak.myediary.util.ImageUtil.displayFriendImage(fid, imageUrl, request, response);
		}
}
