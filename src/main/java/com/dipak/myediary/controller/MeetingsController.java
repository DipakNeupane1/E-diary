package com.dipak.myediary.controller;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dipak.myediary.model.Meetings;
import com.dipak.myediary.service.MeetingService;

@Controller
public class MeetingsController {

	@Autowired
	private MeetingService meetingService;
	
	@RequestMapping(value="/meetings",method=RequestMethod.GET)
	public String getMeetingList(Model model,HttpSession session) {
		int id=(int) session.getAttribute("id");
		model.addAttribute("meeting", meetingService.getMeetingByid(id));
		return "meetingList";
	}
	
	
	
	@RequestMapping(value="/completedMeetings",method=RequestMethod.GET)
	public String getCompletedMeetings(Model model,HttpSession session) {
		int id=(int) session.getAttribute("id");
		model.addAttribute("meet",meetingService.getCompletedMeetings(id));
		return "completedMeetingList";
		
	}
	@RequestMapping(value="/addMeeting",method=RequestMethod.GET)
	public String getMeetingForm() {
		return "addMeetingForm";
	}
	@RequestMapping(value="/meeting_save",method=RequestMethod.POST)
	public String addMeeting(@ModelAttribute Meetings meetings,HttpSession session) {
		int id=(int) session.getAttribute("id");
		meetings.setId(id);
		meetingService.saveMeeting(meetings);
		return "redirect:/meetings";
	}
	@RequestMapping(value="/meeting_delete",method=RequestMethod.GET)
	public String deleteMeeting(@RequestParam int mid) {
		meetingService.deleteMeetingInfo(mid);
		return "redirect:/meetings";
	}
	@RequestMapping(value="/completed_meeting_delete",method=RequestMethod.GET)
	public String deleteCompletedMeetings(@RequestParam int mid) {
		meetingService.deleteMeetingInfo(mid);
		return "redirect:/completedMeetings";
		
	}
	@RequestMapping(value="/meeting_edits",method=RequestMethod.POST)
	public String updateMeeting(@RequestParam int mid,@ModelAttribute Meetings meetings,HttpSession session) {
		int id=(int) session.getAttribute("id");
		meetings.setId(id);
		meetingService.updateMeeting(meetings);
		return "redirect:/meetings";
		
	}
	@RequestMapping(value="/meeting_edit",method=RequestMethod.GET)
	public String editMeeting(@RequestParam int mid,Model model) {
		model.addAttribute("meet",meetingService.getMeetingBymid(mid));
		return "meetingEditForm";
		
	}
	@RequestMapping(value="/send_status",method=RequestMethod.GET)
	public String updateMeetingStatus(@RequestParam int mid) {
		Meetings meetings=meetingService.getMeetingBymid(mid);
	String mStatus="completed";
	meetings.setmStatus(mStatus);
		meetingService.updateMeeting(meetings);
		return "redirect:/meetings";
		
	}
}
