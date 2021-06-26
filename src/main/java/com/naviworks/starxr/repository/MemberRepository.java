package com.naviworks.starxr.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naviworks.starxr.vo.KeywordVo;
import com.naviworks.starxr.vo.MemberVo;

@Repository
public class MemberRepository {
	
	@Autowired
	SqlSession sqlSession;

	public List<MemberVo> getMemberList() {
		
		return sqlSession.selectList("member.memberList");
	}

	public List<MemberVo> getMemberListByKeyword(KeywordVo keywordVo) {
		return sqlSession.selectList("member.memberListByKeyword", keywordVo);
	}

	public MemberVo getMemberByNo(Long no) {
		return sqlSession.selectOne("member.memberByNo", no);
	}

	public void memberModify(Map<String, Object> map) {
		sqlSession.update("member.memberModify",map);
	}

	public MemberVo getModifyByNo(Long no) {
		return sqlSession.selectOne("member.memberModifyByNo", no);
	}

	public void memberDeleteByNo(Long no) {
		sqlSession.update("member.memberDeleteByNo", no);
	}
	
	public Long memberDeleteNextByNo(KeywordVo keywordVo) {
		return sqlSession.selectOne("member.deleteNextByNo", keywordVo);
	}

	public Long memberMaxCount(KeywordVo keywordVo) {
		return sqlSession.selectOne("member.maxCount", keywordVo);
	}

	public boolean reissuancePassword(Long no, String encodePw) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("encodePw", encodePw);
		sqlSession.update("member.reissuancePassword", map);
		return true;
	}
}
