package com.naviworks.starxr.vo;

public class QuestionVo {
	private Long no;
	private String title;
	private String contents;
	private String date;
	private Long userNo;
	private String userName;
	private Long answerCount; 
	private Long statusNo;
	private String statusName;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getAnswerCount() {
		return answerCount;
	}
	public void setAnswerCount(Long answerCount) {
		this.answerCount = answerCount;
	}
	public Long getStatusNo() {
		return statusNo;
	}
	public void setStatusNo(Long statusNo) {
		this.statusNo = statusNo;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	@Override
	public String toString() {
		return "QuestionVo [no=" + no + ", title=" + title + ", contents=" + contents + ", date=" + date + ", userNo="
				+ userNo + ", userName=" + userName + ", answerCount=" + answerCount + ", statusNo=" + statusNo
				+ ", statusName=" + statusName + "]";
	}
}
