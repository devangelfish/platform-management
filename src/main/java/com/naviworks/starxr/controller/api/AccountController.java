package com.naviworks.starxr.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.naviworks.starxr.dto.JsonResult;
import com.naviworks.starxr.service.AccountService;
import com.naviworks.starxr.vo.UserVo;

@RestController("accountApiController")
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public JsonResult modify(@ModelAttribute UserVo userVo) {
		return JsonResult.success(accountService.modify(userVo));
	}
}
