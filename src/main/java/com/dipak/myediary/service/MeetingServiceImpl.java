package com.dipak.myediary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dipak.myediary.model.Meetings;
import com.dipak.myediary.repository.MeetingRepository;

@Service
@Transactional
public class MeetingServiceImpl implements MeetingService {

	@Autowired
	private MeetingRepository meetingRepository;
	@Override
	public void saveMeeting(Meetings meetings) {
		meetingRepository.saveMeeting(meetings);

	}

	@Override
	public void updateMeeting(Meetings meetings) {
		meetingRepository.updateMeeting(meetings);

	}

	@Override
	public void deleteMeetingInfo(int mid) {
		meetingRepository.deleteMeetingInfo(mid);

	}

	@Override
	public List<Meetings> getMeetingByid(int id) {
		return meetingRepository.getMeetingByid(id);
	}

	@Override
	public Meetings getMeetingBymid(int mid) {
		return meetingRepository.getMeetingBymid(mid);
	}

	@Override
	public List<Meetings> getCompletedMeetings(int id) {
		return meetingRepository.getCompletedMeetings(id);
	}

}
