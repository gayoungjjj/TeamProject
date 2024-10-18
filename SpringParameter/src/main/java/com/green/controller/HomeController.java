package com.green.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.domain.DataVo;

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
	
	// 주소에 대한 요청 
	// /temp?a=hello&b=123
	//@RequestMapping("/temp") // GET,POST
	//@RequestMapping(value = "/temp" , method=RequestMethod.GET)
	//@RequestMapping(value = "/temp" , method=RequestMethod.GET)
	@GetMapping("/temp")
	public String temp(String a, int b) {
		System.out.println( "a = " + a );
		System.out.println( "b = " + (b+3) );
		return "none";
	}
	//-----------------------------------------------------------------------
	@RequestMapping("/temp")
	public String temp1(
			HttpServletRequest request,
            HttpServletResponse response		
			) {
		String in_a = request.getParameter("a");
		String in_b = request.getParameter("b");
		
		String a = in_a;
		int b = Integer.parseInt(in_b)+4;
		System.out.println("a = " + a);
        System.out.println("b = " + b);
		
		return "none";
	}
	//-----------------------------------------------------------------------
	// /temp2?a=hello&b=123
	@RequestMapping("/temp2")
	public String temp2(
		@RequestParam Map<String,String>map	) {
		
		System.out.println("map:" + map);
		String a = map.get("a");
		int b = Integer.parseInt(map.get("b"));
		System.out.println("a = " + a);
        System.out.println("b = " + b);
		
		return "none";
	}
	//-----------------------------------------------------------------------
	// /temp3?a=hello&b=123
	@RequestMapping("/temp3")
	public String temp3(
		@RequestParam("a") String v1,
		@RequestParam("b")  int v2		
		) {
		System.out.println("a = " + v1);
        System.out.println("b = " + v2);
		return "none";
	}
	//-----------------------------------------------------------------------
	// /temp4?a=hello&b=123
	@RequestMapping("/temp4")
	public String temp4(DataVo vo) {
		System.out.println("a = " + vo.getA());
		System.out.println("a = " + vo.getB() +10);
		return "none";
	}
	
	//-----------------------------------------------------------------------
	// /temp5?a=hello&b=123
	//jsp로 값을 넘겨주는 방식
	//Model 객체를 사용
	@RequestMapping("/temp5")
	public String temp5(
		String a, int b, Model model
			) {
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		model.addAttribute("a",a);
		model.addAttribute("b",b);
		model.addAttribute("c","이것도 넘어가나?");
		return "reqdata";
	}
	//-----------------------------------------------------------------------
	// /temp6?a=hello&b=123
	@RequestMapping("/temp6")
	public String temp6(
		DataVo vo, //  DataVo vo 데이터 넘겨받음
		Model model // redata.jsp 에 넘겨줄 data를 담고있는 객체
			) {
		System.out.println("a = " + vo.getA());
		System.out.println("b = " + (vo.getB() + 100));
		
		model.addAttribute("a",vo.getA() );
		model.addAttribute("b",vo.getB() );
		model.addAttribute("c","이값도 넘어감" );
		
		return "noneModel";
	}
	//-----------------------------------------------------------------------
	// /temp7?a=hello&b=123
	@RequestMapping("/temp7")
	public String temp7(
			@ModelAttribute("attrName") DataVo vo,
			Model model
			) {
		System.out.println("a = " + vo.getA());
		System.out.println("b = " + (vo.getB() + 100));
		
		model.addAttribute("a",vo.getA() );
		model.addAttribute("b",vo.getB() );
		
		return "noneModel";
	}
	//-----------------------------------------------------------------------
	// Path Variable : 데이터를 경로처럼 사용하기
	// /temp8/hello/123
	@RequestMapping("/temp8/{a}/{b}")
	public String temp8(
		@PathVariable("a") String a,	
		@PathVariable("b") int	  b	
			) {
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		return "none";
	}
	//-----------------------------------------------------------------------
	// Path Variable : 데이터를 경로처럼 사용하기
	// /temp9/hello/123
	@RequestMapping("/temp9/{a}/{b}")
	public String temp9(
			//@PathVariable("a")  생략가능
			DataVo vo	
			) {
		System.out.println("a = " + vo.getA() );
		System.out.println("b = " + vo.getB() );
		
		return "none";
	}
	//-----------------------------------------------------------------------
	// Path Variable : 데이터를 경로처럼 사용하기
	// /temp10/hello/123
	@RequestMapping("/temp10/{a}/{b}")
	public String temp10(
			@ModelAttribute("vo") DataVo vo,
			Model model
			) {
		System.out.println("a = " + vo.getA() );
		System.out.println("b = " + vo.getB() );
		
		return "noneModel";
	}
	
}










