package com.naviworks.starxr.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.naviworks.starxr.config.AppConfig;
import com.naviworks.starxr.config.WebConfig;
import com.naviworks.starxr.vo.AnswerVo;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, AppConfig.class})
public class QuestionControllerTest {
	@Autowired
	QuestionController questionController;
	
	@Qualifier("questionApiController")
	QuestionController questionApiController;
	
	@Test
	public void getReplyTest() {
		assertNotNull(questionController.questionService.getReply(1L));
	}
	
	@Test
	public void getQuestionTest() {
		assertNotNull(questionController.questionService.getQuestion(1L));
	}
	
	@Test
	public void getListbyKewordTest() {
		
		//assertNotNull(questionController.questionService.getListByKeyword("문재범"));
	}
	
	@Test
	public void writeReplyTest() {
		assertNotNull(questionController.questionService.writeReply(new AnswerVo()));
	}
}
