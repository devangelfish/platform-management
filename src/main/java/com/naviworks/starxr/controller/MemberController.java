package com.naviworks.starxr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.naviworks.starxr.service.MemberService;
import com.naviworks.starxr.vo.MemberVo;

@Controller
@RequestMapping("/member")
public class MemberController {
   
   @Autowired
   MemberService memberService;
   
   @RequestMapping("")
   public String member(Model model) {
      List<MemberVo> list = memberService.getMemberList();
      model.addAttribute("list", list);
      return "admin/management/member";
   }
}