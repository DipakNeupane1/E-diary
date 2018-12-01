package com.dipak.myediary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dipak.myediary.model.Notes;
import com.dipak.myediary.repository.NotesRepository;

@Transactional
@Service
public class NotesServiceImpl implements NotesService {

	@Autowired
	private NotesRepository notesRepository;

	@Override
	public void saveNotes(Notes notes) {
		notesRepository.saveNotes(notes);
	}

	@Override
	public void updateNotes(Notes notes) {
		notesRepository.updateNotes(notes);

	}

	@Override
	public void deleteNotesByNid(int nid) {
		notesRepository.deleteNotesByNid(nid);
	}

	@Override
	public List<Notes> getNotesById(int id) {

		return notesRepository.getNotesById(id);
	}

	@Override
	public Notes getNotesByNid(int nid) {

		return notesRepository.getNotesByNid(nid);
	}

	@Override
	public List<Notes> getallTrashNotes(int id) {
		return notesRepository.getallTrashNotes(id);
	}

}
