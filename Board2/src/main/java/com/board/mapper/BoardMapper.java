package com.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.board.vo.BoardVo;

@Mapper
public interface BoardMapper {
	public void boardInsert(BoardVo vo);
	
}
