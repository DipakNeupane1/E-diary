package com.dipak.myediary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dipak.myediary.model.User;
import com.dipak.myediary.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void saveUserInfo(User user) {
		userRepository.saveUserInfo(user);
		
	}

	@Override
	public void updatePhoto(User user) {
		userRepository.updatePhoto(user);
		
	}

	@Override
	public User getUserById(int id) {
		return userRepository.getUserById(id);
	}

	@Override
	public User login(String userName, String password) {
		 User user=userRepository.login(userName, password);
		return user;
	}

	@Override
	public User getUserByEmail(String email) {
		return userRepository.getUserByEmail(email);
	}

}
