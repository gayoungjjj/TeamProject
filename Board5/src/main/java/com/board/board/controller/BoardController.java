package com.board.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.board.mapper.BoardMapper;
import com.board.board.vo.BoardVo;
import com.board.menus.mapper.MenuMapper;
import com.board.menus.vo.MenuVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/Board")
public class BoardController {
	
	@Autowired
	private  MenuMapper    menuMapper;
	
	@Autowired
	private  BoardMapper   boardMapper;
	
	// http://localhost:9090/Board/List?menu_id=MENU01
	// /Board/List?menu_id=MENU02
	@RequestMapping("/List")
	public  ModelAndView  list(  MenuVo  menuVo ) {
		
		log.info("------" + menuVo );	
		// INFO c.b.b.c.BoardController - ------MenuVo [menu_id=MENU01, menu_name=null, menu_seq=0] 
		
		// 메뉴목록 전체를 조회 -> menus.jsp 에 사용
		List<MenuVo> menuList  = menuMapper.getMenuList(); 
		
		/*
		MenuVo       mVo       = menuMapper.getMenu(menu_id);
		String       menu_name = mVo.getMenu_name();
		*/
		String       menu_id   = menuVo.getMenu_id();
		String       menu_name = menuMapper.getMenuName( menuVo );
		
		//  게시글 목록 조회 -> model
		List<BoardVo>  boardList = boardMapper.getBoardList( menuVo );  
		
		// ModelAndView
		ModelAndView  mv  =  new ModelAndView();
		mv.setViewName("board/list");
		mv.addObject("menuList",  menuList);    // menuList
		mv.addObject("menu_id",   menu_id);
		mv.addObject("menu_name", menu_name);   // menuList
		mv.addObject("boardList", boardList );  // boardList 
		return        mv;
	}
	
	// http://localhost:9090/Board/WriteForm?menu_id=MENU01
	// /Board/WriteForm
	@RequestMapping("/WriteForm")
	public  ModelAndView  writeForm( MenuVo menuVo ) {
		ModelAndView  mv  = new ModelAndView();
		mv.setViewName("board/write");	
		mv.addObject("menu_id", menuVo.getMenu_id());
		return        mv;
	}
	
	// /Board/Write
	// menu_id, title, writer, content
	@RequestMapping("/Write")
	public  ModelAndView   write( BoardVo boardVo ) {
		// 굴쓰기
		boardMapper.insertBoard(  boardVo  );
		
		String  menu_id   =  boardVo.getMenu_id();		
		// 목록 조회
		ModelAndView  mv  =  new ModelAndView();
		mv.setViewName("redirect:/Board/List?menu_id=" + menu_id);
		return        mv;
	}
	
	
}
















