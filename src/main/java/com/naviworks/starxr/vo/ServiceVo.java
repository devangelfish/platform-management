package com.naviworks.starxr.vo;

public class ServiceVo {
	private Long no;
	private String name;
	private Long userNo;
	private Long adminNo;
	private String userName;
	private String date;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public Long getAdminNo() {
		return adminNo;
	}
	public void setAdminNo(Long adminNo) {
		this.adminNo = adminNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "ServiceVo [no=" + no + ", name=" + name + ", userNo=" + userNo + ", adminNo=" + adminNo + ", userName="
				+ userName + ", date=" + date + "]";
	}
}
