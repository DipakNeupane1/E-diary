package com.dipak.myediary.service;

import java.util.List;

import com.dipak.myediary.model.Friends;

public interface FriendsService {

	public void saveFriends(Friends friends);
	public void updateFriends(Friends friends);
	public void deleteFriendsInfo(int fid);
	public List<Friends> getFriendsByFid(int id);
	public List<Friends> getAllFriends();
	public Friends getFriendByFid(int fid);
	
}
