package com.dipak.myediary.repository;

import java.util.List;


import com.dipak.myediary.model.Meetings;

public interface MeetingRepository {

	public void saveMeeting(Meetings meetings);
	public void updateMeeting(Meetings meetings);
	public void deleteMeetingInfo(int mid);
	public List<Meetings> getMeetingByid(int id);
	public Meetings getMeetingBymid(int mid);
	public List<Meetings> getCompletedMeetings(int id);
}
