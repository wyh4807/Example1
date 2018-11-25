package com.Example1.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Example1.mapper.BoardMapper;
import com.Example1.model.BoardModel;

@Controller
public class WebController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	BoardMapper boardMapper;
	
	
	@RequestMapping("/")
	public String index(Model model){
		List<BoardModel> boardModel = boardMapper.boardList();
		
		model.addAttribute("boardModel", boardModel);
		
		return "index";
	}
	
	@GetMapping("/Board/{board_IDX}")
	public String postRead(Model model,
			@PathVariable(required = true, value = "board_IDX") Integer board_IDX) {
		BoardModel boardModel = boardMapper.postRead(board_IDX);
		model.addAttribute("boardModel", boardModel);
		return "post";
	}
	
	@PostMapping("/Board/{board_IDX}")
	public String postWrite(Model model) {
		return "index";
	}
	
	@DeleteMapping("/Board/{board_IDX}")
	public String postDelete(Model model,
			@PathVariable(required = true, value = "board_IDX") Integer boardIndex) {
		return "index";
	}

}
