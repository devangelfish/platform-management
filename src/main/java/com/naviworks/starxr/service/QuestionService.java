package com.naviworks.starxr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naviworks.starxr.repository.QuestionRepository;
import com.naviworks.starxr.vo.AnswerVo;
import com.naviworks.starxr.vo.KeywordVo;
import com.naviworks.starxr.vo.QuestionStatusVo;
import com.naviworks.starxr.vo.QuestionVo;

@Service
public class QuestionService {
	
	@Autowired
	QuestionRepository questionRepository;
	
	public boolean writeReply(AnswerVo answerVo) {
		return questionRepository.writeAnswerVo(answerVo) != 0 ? true : false;
	}
	
	public List<AnswerVo> getListByKeyword(KeywordVo keywordVo) {
		return questionRepository.getQuestionVoListByKeyword(keywordVo);
	}
	
	public List<QuestionVo> getList(Long no) {
		return questionRepository.getQuestionVoList(no);
	}

	public List<AnswerVo> getReply(Long no) {
		return questionRepository.getAnswerVoListByNo(no);
	}

	public QuestionVo getQuestion(Long no) {
		return questionRepository.getQuestionVoByNo(no);
	}
	
	public List<QuestionStatusVo> getQuestionStatus() {
		return questionRepository.getQuestionStatusVo();
	}

	public boolean setStatus(QuestionVo questionVo) {
		return questionRepository.setQuestionStatusVo(questionVo) != 0 ? true : false;
	}
}
