package com.board.interceptor;

import org.slf4j.helpers.Reporter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j 
@Component
public class AuthInterceptor implements HandlerInterceptor {
	
	// 전처리
    @Override
    public boolean preHandle(HttpServletRequest request, 
    						 HttpServletResponse response, 
    						 Object handler)
    						 throws Exception {
    	
    	String requestURI = request.getRequestURI();
    	System.out.println("요청주소:" + requestURI );
    	
    	if( requestURI.contains("/Users/LoginForm") ) {
    		return true;
    	}
    	if( requestURI.contains("/Users/Login") ) {
    		return true;
    	}
    	
    	HttpSession session = request.getSession();
    	// 사용자가 로그인정보를 세션 메모리에  user를 저장
    	Object 		login 	= session.getAttribute( "login" );
    	System.out.println( login );
    	if( login == null ) {
    		// 로그인 되어 있지 않다면 로그인 페이지로 이동
    		response.sendRedirect("/Users/LoginForm");
    		return false;
    	}
    	
    	// preHandle 의 return 문의 의미는
    	// 컨트롤러의 요청 - url로 가도되나 안되나를 결정
    	// return : 컨트롤러 url로 가게된다
    	
    	
        return true;
    }
    
	/*
	 * // 후처리
	 * 
	 * @Override public void postHandle(HttpServletRequest request,
	 * HttpServletResponse response, Object handler, ModelAndView modelAndView)
	 * throws Exception { System.out.println("========= postHandle() ===========");
	 * //log.debug("=================================");
	 * HandlerInterceptor.super.postHandle(request, response, handler,
	 * modelAndView); }
	 */
}
