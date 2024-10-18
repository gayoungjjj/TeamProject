package com.parametertest.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.parametertest.domain.DataVo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

	// http://localhost:80
	@RequestMapping("/")
	public String home() {
		return "home";
		// return "/WEB-INF/views/home.jsp";
	}

	// http://localhost/temp?a=hello&b=123
	// @RequestMapping("/temp") // GET, POST
	// @RequestMapping(value="/temp", method=RequestMethod.GET) //GET
	@GetMapping("/temp") // GET
	public String temp(String a, int b) {
		System.out.println("a=" + a);
		System.out.println("b=" + (b + 3));
		return "none"; // none.jsp 없음 404
	}

	// http://localhost/temp1?a=hello&b=123
	@RequestMapping("temp1")
	public String temp1(HttpServletRequest request, HttpServletResponse response) {

		String in_a = request.getParameter("a");
		String in_b = request.getParameter("b");

		String a = in_a;
		int b = Integer.parseInt(in_b) + 4;
		System.out.println("a=" + a);
		System.out.println("b=" + b);

		return "none";
	}

	// http://localhost/temp2?a=hello&b=123
	@RequestMapping("/temp2")
	public String temp2(@RequestParam Map<String, String> map) {

		System.out.println("map:" + map);
		String a = map.get("a");
		int b = Integer.parseInt(map.get("b"));
		System.out.println("a=" + a);
		System.out.println("b=" + (b + 5));

		return "none";
	}

	// http://localhost/temp3?a=hello&b=123
	@RequestMapping("/temp3")
	public String temp3(@RequestParam("a") String v1, @RequestParam("b") int v2) {
		System.out.println("v1=" + v1);
		System.out.println("v2=" + (v2 + 7));

		return "none";
	}

	// http://localhost/temp4?a=hello&b=123
	@RequestMapping("/temp4")
	public String temp4(DataVo vo) {
		System.out.println("a =" + vo.getA());
		System.out.println("b =" + (vo.getB() + 100));

		return "none";
	}

	// ---------------------------------
	// Model 사용
	// /temp5?a=hello&b=123
	@RequestMapping("/temp5")
	public String temp5(String a, int b, Model model) {
		// Model 은 reqdata.jsp 에게 넘겨줄 data 를 담는 객체

		System.out.println("a=" + a);
		System.out.println("b=" + (b + 32));

		// 넘겨줄 data 를 Model 에 담는다
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		model.addAttribute("c", "이것도 넘어가나?");

		return "reqdata"; // reqdata.jsp
	}

	// /temp6?a=hello&b=123
	@RequestMapping("/temp6")
	public String temp6(
			DataVo vo, Model model) {
		// DataVo : 넘겨받는 정보
		// Model  : reqdata.jsp 에게 넘겨줄 data 를 담는 객체

		System.out.println("a=" + vo.getA());
		System.out.println("b=" + (vo.getB() + 64));

		// 넘겨줄 data 를 Model 에 담는다
		model.addAttribute("a", vo.getA());
		model.addAttribute("b", vo.getB() );
		model.addAttribute("c", "이것도 넘어가나요?");

		return "reqdata"; // reqdata.jsp
	}
	
	// /temp7?a=hello&b=123
	@RequestMapping("/temp7")
	public String temp7(
		@ModelAttribute("attrName")	DataVo vo, 
		Model                              model) {
		
		System.out.println("a=" + vo.getA());
		System.out.println("b=" + vo.getB());

		// 넘겨줄 data 를 Model 에 담는다
		model.addAttribute("a", vo.getA());
		model.addAttribute("b", vo.getB() );
		
		return "noneModel"; // noneModel.jsp
	}

}
