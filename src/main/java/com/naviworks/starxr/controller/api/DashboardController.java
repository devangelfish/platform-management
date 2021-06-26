package com.naviworks.starxr.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.naviworks.starxr.dto.JsonResult;
import com.naviworks.starxr.service.DashboardService;
import com.naviworks.starxr.vo.KeywordVo;
import com.naviworks.starxr.vo.UserVo;

@RestController("DashboardApiController")
@RequestMapping("/dashboard")
public class DashboardController {
	
	@Autowired
	DashboardService dashboardService;
	
	@RequestMapping(value="/count", method=RequestMethod.GET)
	public JsonResult count() {
		return JsonResult.success(dashboardService.count());
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public JsonResult questionSearch(@ModelAttribute KeywordVo keywordVo, HttpSession session) {
		return JsonResult.success(dashboardService.getListByKeyword(keywordVo, ((UserVo)session.getAttribute("user")).getNo()));
	}
}
