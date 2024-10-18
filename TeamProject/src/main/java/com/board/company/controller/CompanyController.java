package com.board.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Company")
public class CompanyController {
	// Company/Login
	@RequestMapping("/Login")
	public String login() {
		return "company/login";
    }
	
	// Company/Main
	@RequestMapping("/Main")
	public String main() {
		return "company/main" ;
	}
}