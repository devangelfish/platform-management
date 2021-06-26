package com.naviworks.starxr.vo;

public class KeywordVo {
	private String keyword;
	private Long no;
	private Long optionNo;
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getOptionNo() {
		return optionNo;
	}
	public void setOptionNo(Long optionNo) {
		this.optionNo = optionNo;
	}
	@Override
	public String toString() {
		return "KeywordVo [keyword=" + keyword + ", no=" + no + ", optionNo=" + optionNo + "]";
	}
}
