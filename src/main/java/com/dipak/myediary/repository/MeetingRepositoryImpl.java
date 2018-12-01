package com.dipak.myediary.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dipak.myediary.model.Meetings;
import com.dipak.myediary.util.HibernateUtil;

@Repository
public class MeetingRepositoryImpl implements MeetingRepository {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void saveMeeting(Meetings meetings) {
HibernateUtil.getSession(sessionFactory).merge(meetings);
	}

	@Override
	public void updateMeeting(Meetings meetings) {
		HibernateUtil.getSession(sessionFactory).merge(meetings);
	}

	@Override
	public void deleteMeetingInfo(int mid) {
		Meetings meetings=getMeetingBymid(mid);
		if(meetings!=null) {
			HibernateUtil.getSession(sessionFactory).delete(meetings);
		}

	}

	@Override
	public List<Meetings> getMeetingByid(int id) {
		Criteria criteria=HibernateUtil.getSession(sessionFactory).createCriteria(Meetings.class);
		return criteria.add(Restrictions.eq("id",id)).add(Restrictions.isNull("mStatus")).list();
	}

	@Override
	public Meetings getMeetingBymid(int mid) {
		return (Meetings) HibernateUtil.getSession(sessionFactory).get(Meetings.class, mid);
	}

	@Override
	public List<Meetings> getCompletedMeetings(int id) {
		Criteria criteria=HibernateUtil.getSession(sessionFactory).createCriteria(Meetings.class);
		return criteria.add(Restrictions.eq("id",id)).add(Restrictions.isNotNull("mStatus")).list();
	}

}
