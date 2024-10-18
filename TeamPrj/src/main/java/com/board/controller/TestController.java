 package com.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
 	@RequestMapping("/")
	public  String   home() {
		return "home";      // src/main/webapp/WEB-INF/views/home.jsp 
							//localhost : 9090
	}
	
 	@RequestMapping("/join/join")
	public ModelAndView join() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/join/join");
		return mv;
	}

	@RequestMapping("/users/ujoin")
	public ModelAndView ujoin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("users/ujoin");
		return mv;
	}

	@RequestMapping("/users/cjoin")
	public ModelAndView cjoin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("users/cjoin");
		return mv;
	}
}