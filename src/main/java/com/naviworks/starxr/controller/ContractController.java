package com.naviworks.starxr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.naviworks.starxr.service.ContractService;

@Controller
@RequestMapping("/contract")
public class ContractController {
	@Autowired
	ContractService contractService;
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public String service(Model model) {
		model.addAttribute("list", contractService.getList());		
		return "admin/management/service";
	}
	
	@RequestMapping(value="/{no}", method = RequestMethod.GET)
	public String contract(@PathVariable Long no, Model model) {
		model.addAttribute("list", contractService.getContractList(no));
		model.addAttribute("status", contractService.getStatus());
		return "admin/management/contract";
	}
}