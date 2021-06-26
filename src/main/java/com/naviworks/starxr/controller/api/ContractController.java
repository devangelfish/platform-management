package com.naviworks.starxr.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.naviworks.starxr.dto.JsonResult;
import com.naviworks.starxr.service.ContractService;
import com.naviworks.starxr.vo.KeywordVo;
import com.naviworks.starxr.vo.StatusVo;

@RestController("contractApiController")
public class ContractController {
	@Autowired
	ContractService contractService;
	
	@RequestMapping(value = "/contract/search", method = RequestMethod.GET)
	public JsonResult questionSearch(@ModelAttribute KeywordVo keywordVo) {
		return JsonResult.success(contractService.getListByKeyword(keywordVo));
	}
	
	@RequestMapping(value = "/contract/{no}/status", method = RequestMethod.GET)
	public JsonResult questionSearch(@PathVariable Long no) {
		return JsonResult.success(contractService.getContractStatus(no));
	}
	
	@PutMapping(value = "/contract/{no}/status")
	public JsonResult updateStatus(@PathVariable(value = "no") Long contractNo, @RequestBody StatusVo statusVo) {
		statusVo.setContractNo(contractNo);
		return JsonResult.success(contractService.updateContractStatus(statusVo));
	}
	
	@PostMapping(value = "/contract/{no}/status")
	public JsonResult insertStatus(@PathVariable(value = "no") Long contractNo, @RequestBody StatusVo statusVo) {
		statusVo.setContractNo(contractNo);
		return JsonResult.success(contractService.setContractStatus(statusVo));
	} 
}
