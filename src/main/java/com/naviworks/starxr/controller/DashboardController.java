package com.naviworks.starxr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.naviworks.starxr.service.DashboardService;
import com.naviworks.starxr.vo.UserVo;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

	@Autowired
	DashboardService dashboardService;
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public String dashboard(Model model, HttpSession session) {
		Long no = ((UserVo)session.getAttribute("user")).getNo();
		model.addAttribute("list", dashboardService.getList(no));
		return "admin/main/dashboard";
	}
	
	@RequestMapping(value = "/{no}", method = RequestMethod.GET)
	public String answer(@PathVariable("no") Long no) {
		return "redirect:/question/"+no;
	}
}
