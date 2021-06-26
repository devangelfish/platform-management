package com.naviworks.starxr.security;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.naviworks.starxr.repository.UserRepository;

public class CommonUserHandler {
	
	@Autowired
	private UserRepository userRepository;
	
	public void addCookie(HttpServletResponse response, Cookie cookie, int expiryTime) {
		cookie.setMaxAge(expiryTime);
		response.addCookie(cookie);
	}
	
	public void saveUserInfo(HttpServletRequest request, String userId) {
		request.getSession(false).setAttribute("user", userRepository.find(userId));
	}
}
