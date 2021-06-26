package com.naviworks.starxr.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.naviworks.starxr.dto.JsonResult;
import com.naviworks.starxr.service.QuestionService;
import com.naviworks.starxr.vo.KeywordVo;
import com.naviworks.starxr.vo.QuestionVo;

@RestController("questionApiController")
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	QuestionService questionService;
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public JsonResult questionSearch(@ModelAttribute KeywordVo keywordVo) {
		System.out.println(keywordVo.toString());
		System.out.println(questionService.getListByKeyword(keywordVo));
		return JsonResult.success(questionService.getListByKeyword(keywordVo));
	}
	
	@RequestMapping(value = "/{no}", method = RequestMethod.POST)
	public JsonResult updateStatus(@PathVariable("no") Long no, @ModelAttribute QuestionVo questionVo) {
		questionVo.setNo(no);
		return JsonResult.success(questionService.setStatus(questionVo));
	}
}
