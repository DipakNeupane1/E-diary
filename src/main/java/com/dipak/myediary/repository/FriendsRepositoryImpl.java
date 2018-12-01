package com.dipak.myediary.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dipak.myediary.model.Friends;
import com.dipak.myediary.util.HibernateUtil;

@Repository
public class FriendsRepositoryImpl implements FriendsRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveFriends(Friends friends) {
		HibernateUtil.getSession(sessionFactory).merge(friends);

	}

	@Override
	public void updateFriends(Friends friends) {
		HibernateUtil.getSession(sessionFactory).update(friends);

	}

	@Override
	public void deleteFriendsInfo(int fid) {
		Friends friends =getFriendByFid(fid);
		if (friends != null) {
			HibernateUtil.getSession(sessionFactory).delete(friends);
		}
	}

	@Override
	public List<Friends> getFriendsByFid(int id) {
		Criteria criteria=HibernateUtil.getSession(sessionFactory).createCriteria(Friends.class);
		return  criteria.add(Restrictions.eq("id",id)).list();
	
	
	}
	@Override
	public List<Friends> getAllFriends() {
		return HibernateUtil.getSession(sessionFactory).createCriteria(Friends.class).list();
	}

	@Override
	public Friends getFriendByFid(int fid) {
		return (Friends) HibernateUtil.getSession(sessionFactory).get(Friends.class, fid);
	}

}
