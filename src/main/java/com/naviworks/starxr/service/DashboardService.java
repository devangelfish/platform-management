package com.naviworks.starxr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naviworks.starxr.repository.DashboardRepository;
import com.naviworks.starxr.vo.ChartVo;
import com.naviworks.starxr.vo.KeywordVo;
import com.naviworks.starxr.vo.QuestionVo;

@Service
public class DashboardService {
	
	@Autowired
	DashboardRepository dashboardRepository;

	public ChartVo count() {
		return dashboardRepository.count();
	}

	public List<QuestionVo> getList(Long no) {
		return dashboardRepository.getList(no);
	}

	public List<QuestionVo> getListByKeyword(KeywordVo keywordVo,Long no) {
		return dashboardRepository.getQuestionVoListByKeyword(keywordVo, no);
	}
	
	
}
