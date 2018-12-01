package com.dipak.myediary.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Meetings {

	private int id;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int mid;
	private String mTitle;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getmTitle() {
		return mTitle;
	}
	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}
	public String getmFocusArea() {
		return mFocusArea;
	}
	public void setmFocusArea(String mFocusArea) {
		this.mFocusArea = mFocusArea;
	}
	public Date getmDate() {
		return mDate;
	}
	public void setmDate(Date mDate) {
		this.mDate = mDate;
	}
	public String getmTime() {
		return mTime;
	}
	public void setmTime(String mTime) {
		this.mTime = mTime;
	}
	public String getmVenue() {
		return mVenue;
	} 
	public void setmVenue(String mVenue) {
		this.mVenue = mVenue;
	}
	public String getmStatus() {
		return mStatus;
	}
	public void setmStatus(String mStatus) {
		this.mStatus = mStatus;
	}
	private String mFocusArea;
	@DateTimeFormat(pattern="YYYY-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date mDate;
	private String mTime;
	private String mVenue;
	private String mStatus;
}
