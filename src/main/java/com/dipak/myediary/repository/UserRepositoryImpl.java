package com.dipak.myediary.repository;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dipak.myediary.model.User;
import com.dipak.myediary.util.HibernateUtil;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveUserInfo(User user) {
		HibernateUtil.getSession(sessionFactory).merge(user);
		
	}

	@Override
	public void updatePhoto(User user) {
	HibernateUtil.getSession(sessionFactory).merge(user);		
}

	@Override
	public User getUserById(int id) {
		return (User) HibernateUtil.getSession(sessionFactory).get(User.class, id);
		
	}

	@Override
	public User login(String userName, String password) {
		Criteria criteria=HibernateUtil.getSession(sessionFactory).createCriteria(User.class);
		User user=(User) criteria.add(Restrictions.eq("userName", userName)).add(Restrictions.eq("password",password)).uniqueResult();
		if(user!=null) {
		return user;
			
		}
		return user;
	}

	@Override
	public User getUserByEmail(String email) {
		Criteria criteria=HibernateUtil.getSession(sessionFactory).createCriteria(User.class);
		User user=(User) criteria.add(Restrictions.eq("email",email)).uniqueResult();
		return user;
	}

}
