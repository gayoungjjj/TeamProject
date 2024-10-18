package com.board;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.board.mapper.BoardMapper;
import com.board.vo.BoardVo;

// JUnit Test - 단위 테스트 : 함수를 테스트하기 위해 부분적으로 실행하는 기술
/* 실행방법
 * 프로젝트 src/test/java
 * 		-> 	com.board
 * 		->	BoardApplicationTests.java 선택 오른쪽 마우스
 * 		->	Run as , JUnit Test  
 * 		->	JUnit Test 클릭하여 실행하면 왼쪽에 junit tap에
 * 			실행결과가  녹색/적색 그래프로 표시됨
*/
@SpringBootTest
class BoardApplicationTests {
	
	/* Autowired : 미리 application.properties 의 설정에 따라
	 * 			   new 된 bean 객체를 자동으로 연결한다.
	*/
	@Autowired
	private DataSource ds;
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void test1() {
		double n1 = 10;
		double n2 =  3;
		double n  = n1/n2;
		System.out.println( n );
		//assertEquals(n, 3.5); 
		// n==3.5 확인 테스트 : Errors = 0 , Failures = 1
		// 테스트 실패
		assertEquals(n, 3.5, 0.5);
		// n==3.5 에 오차 범위를 0.5 까지 줬음
		// 테스트 성공
		
	}
	
	// db 연결 확인하기
	/*
	 * @Test void testConnection() throws SQLException { Connection conn =
	 * ds.getConnection(); System.out.println(conn); conn.close(); }
	 */
	
	@Test
	void testInsert() {
		// 먼저 mapper/boardMapper.xml 에 insert 문을 만들기
		BoardVo vo = new BoardVo();
		vo.setTitle("SpringBoot 글쓰기");
		vo.setContent("글 내용");
		vo.setWriter("동기");
		boardMapper.boardInsert(vo);
	}
	

}
