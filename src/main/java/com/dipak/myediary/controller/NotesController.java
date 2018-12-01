package com.dipak.myediary.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dipak.myediary.model.Notes;
import com.dipak.myediary.service.NotesService;

@Controller
public class NotesController {

	@Autowired
	private NotesService notesService;

	@RequestMapping(value = "/notes", method = RequestMethod.GET)
	public String getAllNotes(HttpSession session, Model model) {
		int id=(int) session.getAttribute("id");
		model.addAttribute("notes", notesService.getNotesById(id));
		return "notesList";

	}
	@RequestMapping(value = "/note_status", method = RequestMethod.GET)
	public String updateNoteStatus(@RequestParam int nid) {
		String nStatus="Completed";
		Notes notes=notesService.getNotesByNid(nid);
		notes.setnStatus(nStatus);
		notesService.updateNotes(notes);
		return "redirect:/notes";

	}
	@RequestMapping(value = "/addNoteForm", method = RequestMethod.GET)
	public String addNotesForm() {
		return "notesForm";

	}

	@RequestMapping(value = "/note_save", method = RequestMethod.POST)
	public String addNotes(@ModelAttribute Notes notes,HttpSession session) {
		int id=(int) session.getAttribute("id");
		notes.setId(id);
		notesService.saveNotes(notes);
		return "redirect:/notes";

	}
	@RequestMapping(value="/note_edit",method=RequestMethod.GET)
	public String getNotesByNid(@RequestParam int nid,Model model) {
		model.addAttribute("note",notesService.getNotesByNid(nid));
		return "notesEditForm";
		
	}
	@RequestMapping(value = "/note_update", method = RequestMethod.POST)
	public String updateNotes(@ModelAttribute Notes notes,@RequestParam int nid) {
		notesService.updateNotes(notes);
		return "redirect:/notes";
	}
	@RequestMapping(value = "/note_delete", method = RequestMethod.GET)
	public String deleteNotes(@RequestParam int nid) {
		notesService.deleteNotesByNid(nid);
		return "redirect:/notes";
	}
	@RequestMapping(value="/completed_note_delete",method=RequestMethod.GET)
	public String completedNotesDelete(@RequestParam int nid) {
		notesService.deleteNotesByNid(nid);
		return "redirect:/completed_notes";
		
	}
	@RequestMapping(value = "/completed_notes", method = RequestMethod.GET)
	public String getCompletedNoteList(HttpSession session,Model model) {
		int id=(int) session.getAttribute("id");
		model.addAttribute("complete",notesService.getallTrashNotes(id));
		return "completedNoteList";

	}
}
