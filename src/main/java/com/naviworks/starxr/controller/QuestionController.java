package com.naviworks.starxr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.naviworks.starxr.service.QuestionService;
import com.naviworks.starxr.vo.AnswerVo;

@Controller
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	QuestionService questionService;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String question(@ModelAttribute AnswerVo answerVo) {
		questionService.writeReply(answerVo);
		return "redirect:/question/" + answerVo.getInquiryNo();
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String question(Model model, @RequestParam(required = false) Long no) {
		model.addAttribute("status", questionService.getQuestionStatus());
		model.addAttribute("list", questionService.getList(no));
		System.out.println(questionService.getList(no));
		model.addAttribute("no", no);
		return "admin/management/question";
	}
	
	@RequestMapping(value = "/{no}", method = RequestMethod.GET)
	public String answer(Model model, @PathVariable("no") Long no) {
		model.addAttribute("list", questionService.getReply(no));
		model.addAttribute("question", questionService.getQuestion(no));
		model.addAttribute("status", questionService.getQuestionStatus());
		return "admin/management/answer";
	}

}
