package com.naviworks.starxr.vo;

public class ChartVo {
	private Long personCount;
	private Long CompanyCount;
	private Long startContractCount;
	private Long endContractCount;
	public Long getPersonCount() {
		return personCount;
	}
	public void setPersonCount(Long personCount) {
		this.personCount = personCount;
	}
	public Long getCompanyCount() {
		return CompanyCount;
	}
	public void setCompanyCount(Long companyCount) {
		CompanyCount = companyCount;
	}
	public Long getStartContractCount() {
		return startContractCount;
	}
	public void setStartContractCount(Long startContractCount) {
		this.startContractCount = startContractCount;
	}
	public Long getEndContractCount() {
		return endContractCount;
	}
	public void setEndContractCount(Long endContractCount) {
		this.endContractCount = endContractCount;
	}
	@Override
	public String toString() {
		return "ChartVo [personCount=" + personCount + ", CompanyCount=" + CompanyCount + ", startContractCount="
				+ startContractCount + ", endContractCount=" + endContractCount + "]";
	}
	
	
}
