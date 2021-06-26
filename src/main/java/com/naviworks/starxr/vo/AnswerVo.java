package com.naviworks.starxr.vo;

public class AnswerVo {
	private Long no;
	private String contents;
	private String date;
	private Long inquiryNo;
	private Long adminNo;
	private String adminName;
	private String userName;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
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
	public Long getInquiryNo() {
		return inquiryNo;
	}
	public void setInquiryNo(Long inquiryNo) {
		this.inquiryNo = inquiryNo;
	}
	public Long getAdminNo() {
		return adminNo;
	}
	public void setAdminNo(Long adminNo) {
		this.adminNo = adminNo;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		return "AnswerVo [no=" + no + ", contents=" + contents + ", date=" + date + ", inquiryNo=" + inquiryNo
				+ ", adminNo=" + adminNo + ", adminName=" + adminName + ", userName=" + userName + "]";
	}
}
