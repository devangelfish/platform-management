package com.naviworks.starxr.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
	
	@Autowired
	private CommonUserHandler commonUserHandler;
	
	private static final int EXP_PERIOD = 604800;
	
	private boolean isChecked(String checked) {
		return (checked != null ? true : false);
	}
	
	private void rememberId(HttpServletResponse response, Cookie[] cookies, String id) {
		commonUserHandler.addCookie(response, new Cookie("remember", id), EXP_PERIOD);
	}
	
	private void doNotRememberId(HttpServletResponse response, Cookie[] cookies) {	
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("remember")) {
				commonUserHandler.addCookie(response, cookie, 0);
			}
		}
	}
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {	
		commonUserHandler.saveUserInfo(request, authentication.getName());
		
		if(isChecked(request.getParameter("remember"))) {
			rememberId(response, request.getCookies(), authentication.getName());
		} else {
			doNotRememberId(response, request.getCookies());
		}
		
		response.sendRedirect("/starxr-admin/dashboard");
	}
}
