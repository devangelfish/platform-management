package com.naviworks.starxr.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.naviworks.starxr.dto.JsonResult;
import com.naviworks.starxr.service.MemberService;
import com.naviworks.starxr.vo.KeywordVo;

@RestController("memberApiController")
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public JsonResult memberFind(@RequestParam Long no) {
		return JsonResult.success(memberService.memberByNo(no));
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public JsonResult memberSearch(@ModelAttribute KeywordVo keywordVo) {
		return JsonResult.success(memberService.memberListByKeyword(keywordVo));
	}
	
	@RequestMapping(value = "/mail", method = RequestMethod.GET)
	public JsonResult mail(@RequestParam Long no, @RequestParam String email, @RequestParam String name) {
		return JsonResult.success(memberService.rePassword(no, email, name));
	}
	
	@RequestMapping(value = "/modify/{no}", method = RequestMethod.POST)
	public JsonResult modify(@PathVariable("no") Long no,
							 @RequestParam String identifier,
							 @RequestParam String email,
							 @RequestParam boolean emailReceive,
							 @RequestParam String mobiNo,
							 @RequestParam String telNo,
							 @RequestParam boolean smsReceive) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("identifier", identifier);
		map.put("email", email);
		map.put("emailReceive", emailReceive);
		map.put("mobiNo", mobiNo);
		map.put("telNo", telNo);
		map.put("smsReceive", smsReceive);
	
		return JsonResult.success(memberService.memberModify(map));
	}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public JsonResult memberDelete(@ModelAttribute KeywordVo keywordVo) {
		return JsonResult.success(memberService.memberDeleteByNo(keywordVo));
	}
	
	@RequestMapping(value = "/deleteNext", method = RequestMethod.GET)
	public JsonResult deleteNext(@ModelAttribute KeywordVo keywordVo) {
		return JsonResult.success(memberService.memberdeleteNextByNo(keywordVo));
	}
	
	@RequestMapping(value = "/maxCount", method = RequestMethod.POST)
	public JsonResult maxCount(@ModelAttribute KeywordVo keywordVo) {
		return JsonResult.success(memberService.memberMaxCount(keywordVo));
	}
}
