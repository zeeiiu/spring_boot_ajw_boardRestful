 package edu.global.ex.controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.global.ex.page.Criteria;
import edu.global.ex.page.PageVO;
import edu.global.ex.service.BoardService;
import edu.global.ex.vo.BoardVO;
import edu.global.ex.vo.GradeVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j //로그
@RequestMapping("/rboard/*")
@RequiredArgsConstructor
@RestController //기존의 컨트롤러 문법과는 완전히 달라짐
public class RestBoardController {
	
	@Autowired
	private BoardService boardService; // BoardService boardService = new BoardServiceImpl()
	
	@GetMapping("/")
	public String rboard() {
		return "<h1>이제는 restful 이당</h1>";
	}
	
	@GetMapping("/list")
	public List<BoardVO> list() {
		log.info("list().."); 
		
		return boardService.getList();
	}
	// /rboard/1054
	@DeleteMapping("/{bid}")
	public int rest_delete(BoardVO boardVO) {
		log.info("rest_delete().."); 
		
		return boardService.remove(boardVO);
	}
	
	
}
