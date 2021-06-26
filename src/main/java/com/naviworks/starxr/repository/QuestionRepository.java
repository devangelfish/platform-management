package com.naviworks.starxr.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naviworks.starxr.vo.AnswerVo;
import com.naviworks.starxr.vo.KeywordVo;
import com.naviworks.starxr.vo.QuestionStatusVo;
import com.naviworks.starxr.vo.QuestionVo;

@Repository
public class QuestionRepository {
	
	@Autowired
	SqlSession sqlSession;
	
	public int writeAnswerVo(AnswerVo answerVo) {
		return sqlSession.insert("question.writeReply", answerVo);
	}
	
	public List<AnswerVo> getQuestionVoListByKeyword(KeywordVo keywordVo) {
		return sqlSession.selectList("question.getInquiryListByKeyword", keywordVo);
	}
	
	public List<QuestionVo> getQuestionVoList(Long no) {
		return sqlSession.selectList("question.getInquiryList", no);
	}
	
	public List<AnswerVo> getAnswerVoListByNo(Long no) {
		return sqlSession.selectList("question.getAnswerListByNo", no);
	}

	public QuestionVo getQuestionVoByNo(Long no) {
		return sqlSession.selectOne("question.getQuestionByNo", no);
	}

	public List<QuestionStatusVo> getQuestionStatusVo() {
		return sqlSession.selectList("question.getQuestionStatus");
	}

	public int setQuestionStatusVo(QuestionVo questionVo) {
		return sqlSession.update("question.setQuestionStatus", questionVo);
	}
}
