package com.dipak.myediary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dipak.myediary.model.Friends;
import com.dipak.myediary.repository.FriendsRepository;

@Service
@Transactional
public class FriendsServiceImpl implements FriendsService {

	@Autowired
	private FriendsRepository friendsRepository;
	@Override
	public void saveFriends(Friends friends) {
		friendsRepository.saveFriends(friends);
	}

	@Override
	public void updateFriends(Friends friends) {
		
		friendsRepository.updateFriends(friends);
	}

	@Override
	public void deleteFriendsInfo(int fid) {
		friendsRepository.deleteFriendsInfo(fid);

	}

	@Override
	public List<Friends> getFriendsByFid(int id) {
		
		return friendsRepository.getFriendsByFid(id);
	}

	@Override
	public List<Friends> getAllFriends() {
		
		return friendsRepository.getAllFriends();
	}

	@Override
	public Friends getFriendByFid(int fid) {
		return friendsRepository.getFriendByFid(fid);
	}

}
