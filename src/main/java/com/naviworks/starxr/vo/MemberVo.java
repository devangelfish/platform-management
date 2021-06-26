package com.naviworks.starxr.vo;

public class MemberVo {
	private Long no;
	private String id;
	private String password;
	private String companyName;
	private Long companyNumber;
	private String name;
	private String identifier;
	private String email;
	private boolean emailReceive;
	private String mobiNo;
	private String telNo;
	private boolean smsReceive;
	private String imageURL;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Long getCompanyNumber() {
		return companyNumber;
	}
	public void setCompanyNumber(Long companyNumber) {
		this.companyNumber = companyNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isEmailReceive() {
		return emailReceive;
	}
	public void setEmailReceive(boolean emailReceive) {
		this.emailReceive = emailReceive;
	}
	public String getMobiNo() {
		return mobiNo;
	}
	public void setMobiNo(String mobiNo) {
		this.mobiNo = mobiNo;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	public boolean isSmsReceive() {
		return smsReceive;
	}
	public void setSmsReceive(boolean smsReceive) {
		this.smsReceive = smsReceive;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", id=" + id + ", password=" + password + ", companyName=" + companyName
				+ ", companyNumber=" + companyNumber + ", name=" + name + ", identifier=" + identifier + ", email="
				+ email + ", emailReceive=" + emailReceive + ", mobiNo=" + mobiNo + ", telNo=" + telNo + ", smsReceive="
				+ smsReceive + ", imageURL=" + imageURL + "]";
	}
	
	
}
