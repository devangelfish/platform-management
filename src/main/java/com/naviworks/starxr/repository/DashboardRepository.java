package com.naviworks.starxr.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naviworks.starxr.vo.ChartVo;
import com.naviworks.starxr.vo.KeywordVo;
import com.naviworks.starxr.vo.QuestionVo;

@Repository
public class DashboardRepository {

	@Autowired
	SqlSession sqlSession;
	
	public ChartVo count() {
		return sqlSession.selectOne("dashboard.count");
	}

	public List<QuestionVo> getList(Long no) {
		return sqlSession.selectList("dashboard.getList",no);
	}

	public List<QuestionVo> getQuestionVoListByKeyword(KeywordVo keywordVo, Long no) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keywordNo", keywordVo.getNo());
		map.put("keywordString", keywordVo.getKeyword());
		map.put("no", no);
		return sqlSession.selectList("dashboard.getListByKeyword",map);
	}

}
