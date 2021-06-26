package com.naviworks.starxr.security;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class CustomLoginFailuerHandler implements AuthenticationFailureHandler {
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String check = "";
		
		if(id.equals("")) {
			check = "아이디를 입력하세요.";
		}
		else if(password.equals("")) {
			check = "비밀번호를 입력하세요.";
		}
		else {
			check = "아이디 또는 비밀번호를 확인하세요.";
		}
		
		request.setAttribute("check", check);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
		dispatcher.forward(request, response);
	}
	
}
