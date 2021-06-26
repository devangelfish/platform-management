package com.naviworks.starxr.vo;

public class StatusVo {
	private Long contractNo;
	private Long statusNo;
	private String name;
	private String processDate;
	private String contents;
	
	public Long getContractNo() {
		return contractNo;
	}
	public void setContractNo(Long contractNo) {
		this.contractNo = contractNo;
	}
	public Long getStatusNo() {
		return statusNo;
	}
	public void setStatusNo(Long statusNo) {
		this.statusNo = statusNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProcessDate() {
		return processDate;
	}
	public void setProcessDate(String processDate) {
		this.processDate = processDate;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	@Override
	public String toString() {
		return "StatusVo [contractNo=" + contractNo + ", statusNo=" + statusNo + ", name=" + name + ", processDate="
				+ processDate + ", contents=" + contents + "]";
	}
}
