package com.dipak.myediary.service;

import java.util.List;

import com.dipak.myediary.model.Notes;

public interface NotesService {

	public void saveNotes(Notes notes);

	public void updateNotes(Notes notes);

	public void deleteNotesByNid(int nid);

	public List<Notes> getNotesById(int id);

	public Notes getNotesByNid(int nid);

	public List<Notes> getallTrashNotes(int id);
}
