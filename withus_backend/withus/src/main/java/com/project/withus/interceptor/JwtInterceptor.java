package com.project.withus.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.project.withus.model.service.JwtService;
import com.project.withus.exception.UnAuthorizedException;


public class JwtInterceptor implements HandlerInterceptor{

	private static final String HEADER_AUTH = "auth-token";
	
	@Autowired
	private JwtService jwtService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		final String token = request.getHeader(HEADER_AUTH);
		
		if(token != null && jwtService.isUsable(token)) {
			System.out.println("토큰 사용가능 : " + token);
			return true;
		}else {
			System.out.println("토큰 사용 불가능 : " + token);
			throw new UnAuthorizedException();
		}
	}
	
	
	
	
}
