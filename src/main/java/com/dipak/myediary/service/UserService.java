package com.dipak.myediary.service;

import com.dipak.myediary.model.User;

public interface UserService {

	public void saveUserInfo(User user);
	public User getUserById(int id);
	public void updatePhoto(User user);
	public User login(String userName,String password);
	public User getUserByEmail(String email);
}
