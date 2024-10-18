package com.board.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.board.interceptor.AuthInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	
	@Autowired
	private AuthInterceptor authInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// authInterceptor 를 동작시킬 때 모든 페이지(/**)를 대상으로
		// http://localhost:9090 밑의 모든 파일
		// ("/css/**","/img/**","/js/**") 경로는 interceptor 의 대상이 아님
		// .addPathPatterns("/Board/**")
		// http://localhost:9090/Board 밑의 모든 파일
		registry.addInterceptor( authInterceptor )
//				.addPathPatterns("/**")
				.addPathPatterns("/Board/**")
				.excludePathPatterns("/css/**","/img/**","/js/**");
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
}
