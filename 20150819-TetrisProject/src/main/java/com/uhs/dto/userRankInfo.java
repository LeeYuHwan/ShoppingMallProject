package com.uhs.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class userRankInfo {
	private int Id;	
	private String username;
	private int score;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss")
	private Date createDate;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss")
	private Date modifyDate;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}	
}
