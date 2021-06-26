package com.naviworks.starxr.vo;

import java.util.List;

public class ContractVo {
	private Long no;
	private String name;
	private String contractEtc;
	private String type;
	private String contractDate;
	private String latestStatusDate;
	private Long price;
	private Long serviceNo;
	private List<StatusVo> status;
	
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
	public String getLatestStatusDate() {
		return latestStatusDate;
	}
	public void setLatestStatusDate(String latestStatusDate) {
		this.latestStatusDate = latestStatusDate;
	}
	public String getContractEtc() {
		return contractEtc;
	}
	public void setContractEtc(String contractEtc) {
		this.contractEtc = contractEtc;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getServiceNo() {
		return serviceNo;
	}
	public void setServiceNo(Long serviceNo) {
		this.serviceNo = serviceNo;
	}
	public List<StatusVo> getStatus() {
		return status;
	}
	public void setStatus(List<StatusVo> status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContractDate() {
		return contractDate;
	}
	public void setContractDate(String contractDate) {
		this.contractDate = contractDate;
	}
	@Override
	public String toString() {
		return "ContractVo [no=" + no + ", name=" + name + ", contractEtc=" + contractEtc + ", type=" + type
				+ ", contractDate=" + contractDate + ", latestStatusDate=" + latestStatusDate + ", price=" + price
				+ ", serviceNo=" + serviceNo + ", status=" + status + "]";
	}
}
