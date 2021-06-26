package com.naviworks.starxr.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.naviworks.starxr.security.CommonUserHandler;
import com.naviworks.starxr.vo.UserVo;

public class AccountInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	private CommonUserHandler commonUserHandler;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
			return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		commonUserHandler.saveUserInfo(request, ((UserVo)request.getSession().getAttribute("user")).getId());
	}
}