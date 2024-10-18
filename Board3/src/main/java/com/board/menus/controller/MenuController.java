package com.board.menus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.menus.mapper.MenuMapper;
import com.board.menus.vo.MenuVo;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/Menus")
public class MenuController {
	
	@Autowired
	private  MenuMapper  menuMapper;
	
	// 메뉴 목록 조회  /Menus/List
	@RequestMapping("/List")   
	public   String   list( Model model ) {
		// 조회한결과를 ArrayList 로 돌려준디
		List<MenuVo> menuList = menuMapper.getMenuList();
		System.out.println(menuList);
				
		// 조회 결과를 넘겨준다 ( Model 에 담아서 )
		model.addAttribute("msg", "List" );
		model.addAttribute("menuList", menuList );
		//System.out.println( "MenuController list() menuList:" + menuList );
		
		return "menus/list";
	}
	
	// /Menus/WriteForm
	@RequestMapping("/WriteForm")
	public  String   writeForm() {
		return  "menus/write";
	}
	
	@RequestMapping("/Write")
		// 넘어어오는 값을 받아서 //db에 저장하고
	public String write(MenuVo menuVo,Model model) {
		menuMapper.insertMenu(menuVo);
		
		return "redirect:/Menus/List";
		/* 밑에 코드를 한줄로 요약
		 * // list.jsp에 출력할 data를 조회하여 model에 담는다 
		 * List<MenuVo>menuList = menuMapper.getMenuList(); 
		 * model.addAttribute("menuList",menuList); 
		 * //목록보기 페이지(list.jsp)로 이동 
		 * return "menus/list";
		 */
		
	}
	//------------------------------------------------------
	// /Menus/WriteForm2
	@RequestMapping("/WriteForm2")
	public  String   writeForm2() {
		return  "menus/write2";
	}
	
	@RequestMapping("/Write2")
	public  String   write2(MenuVo menuVo, Model model) {
		// 메뉴 추가
		menuMapper.insertMenu2(menuVo);
		// 목록 조회
		return  "redirect:/Menus/List";
	}
	
	//http://http://localhost:9090/Menus/Delete?menu_id=MENU01
	@RequestMapping("/Delete")
	public String delete(MenuVo menuVo) {
		// 삭제 할 메뉴 아이디를 받아서 mapper를 이용해서 삭제하고
		menuMapper.deleteMenu(menuVo);
		// 다시 목록을 조회
		return "redirect:/Menus/List";
	}
	
	//http://localhost:9090/Menus/UpdateForm?menu_id=MENU01
	@RequestMapping("/UpdateForm")
	public String updateform(MenuVo menuVo,Model model) {
		//수정할 자료를 조회해서 수정 할 화면으로 이동
		MenuVo menu = menuMapper.getMenu(menuVo.getMenu_id());
		model.addAttribute("menu",menu);
		
		return "menus/update";
	}
	
	@RequestMapping("/Update")
	public String update(MenuVo menuVo) {
	    menuMapper.updateMenu(menuVo);
	    return "redirect:/Menus/List";
	}
	
}






