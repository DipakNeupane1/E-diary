package com.dipak.myediary.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dipak.myediary.model.Notes;
import com.dipak.myediary.util.HibernateUtil;

@Repository
public class NotesRepositoryImpl implements NotesRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveNotes(Notes notes) {
		HibernateUtil.getSession(sessionFactory).save(notes);

	}

	@Override
	public void updateNotes(Notes notes) {

		HibernateUtil.getSession(sessionFactory).update(notes);
	}

	@Override
	public void deleteNotesByNid(int nid) {
		Notes notes = getNotesByNid(nid);
		if (notes != null) {
			HibernateUtil.getSession(sessionFactory).delete(notes);
		}
	}

	@Override
	public List<Notes> getNotesById(int id) {
		Criteria criteria = HibernateUtil.getSession(sessionFactory).createCriteria(Notes.class);
		return criteria.add(Restrictions.eq("id", id)).add(Restrictions.isNull("nStatus")).list();
	}

	@Override
	public Notes getNotesByNid(int nid) {
		return (Notes) HibernateUtil.getSession(sessionFactory).get(Notes.class, nid);
	}

	@Override
	public List<Notes> getallTrashNotes(int id) {
		Criteria criteria = HibernateUtil.getSession(sessionFactory).createCriteria(Notes.class);
		return criteria.add(Restrictions.eq("id", id)).add(Restrictions.isNotNull("nStatus")).list();
	}

}
