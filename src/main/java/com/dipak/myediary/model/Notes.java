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
public class Notes {

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getnTitle() {
		return nTitle;
	}
	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}
	public Date getnDate() {
		return nDate;
	}
	public void setnDate(Date nDate) {
		this.nDate = nDate;
	}
	public String getnAbout() {
		return nAbout;
	}
	public void setnAbout(String nAbout) {
		this.nAbout = nAbout;
	}
	public String getnStatus() {
		return nStatus;
	}
	public void setnStatus(String nStatus) {
		this.nStatus = nStatus;
	}
	private int id;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int nid;
	private String nTitle;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="YYYY-MM-dd")
	private Date nDate;
	private String nAbout;
	private String nStatus;
}
