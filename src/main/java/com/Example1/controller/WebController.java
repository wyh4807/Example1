package com.Example1.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.Example1.mapper.BoardMapper;
import com.Example1.model.BoardModel;
import com.Example1.service.impl.BoardServiceImpl;

@Controller
public class WebController implements ErrorController{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	BoardMapper boardMapper;
	
	@Autowired
	BoardServiceImpl boardServiceImpl;
	
	@RequestMapping("/")
	public String index(Pageable pageable, Model model){
		Page<BoardModel> page = boardServiceImpl.getAllBoardModel(pageable);
		List<BoardModel> boardModel = boardMapper.boardList();
		
		int current = page.getNumber();
	    int begin = Math.max(1, current - 5);
	    int end = Math.min(begin + 10, page.getTotalPages());
		
		
		model.addAttribute("boardModel", boardModel);
		model.addAttribute("current", current);
		model.addAttribute("begin", begin);
		model.addAttribute("end", end);
		model.addAttribute("page", page);
		return "index";
	}
	
	@GetMapping("/Write")
	public String write(@ModelAttribute BoardModel boardModel, Model model){
		
		model.addAttribute("boardModel", boardModel);
		return "write";
	}
	
	@GetMapping("/Board/{board_IDX}")
	public String postRead(Model model,
			@PathVariable(required = true, value = "board_IDX") Integer board_IDX) {
		
		BoardModel boardModel = Optional.ofNullable(boardMapper.postRead(board_IDX))
										.orElseThrow(IllegalStateException::new);
		model.addAttribute("boardModel", boardModel);
		return "post";
	}
	
	@Transactional	
	@PostMapping("/Write")
	public RedirectView postWrite(@ModelAttribute BoardModel boardModel, Model model) {
		Boolean board_Write = boardMapper.postWrite(boardModel);
		String idx = boardMapper.getWritePostIDX();
		return board_Write ? 
				new RedirectView("/Board/" + idx) :
				new RedirectView("/error/505Error");

	}
	
	@Transactional	
	@PutMapping("/Write")
	public RedirectView postModify(@ModelAttribute BoardModel boardModel, Model model) {
		Boolean board_Write = boardMapper.postWrite(boardModel);
		String idx = boardMapper.getWritePostIDX();
		return board_Write ? 
				new RedirectView("/Board/" + idx) :
				new RedirectView("/error/505Error");

	}
	
	
	@DeleteMapping("/Board/{board_IDX}")
	public @ResponseBody Boolean postDelete(Model model,
			@PathVariable(required = true, value = "board_IDX") Integer board_IDX) {
		Boolean board_DLT = boardMapper.postDelete(board_IDX);
		return board_DLT;
	}
	
	@RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		
		if (status != null) {
	        Integer statusCode = Integer.valueOf(status.toString());
	        
	        if(statusCode == HttpStatus.BAD_REQUEST.value()) return "/error/400Error";
	        else if(statusCode == HttpStatus.FORBIDDEN.value()) return "/error/403Error";
	        else if(statusCode == HttpStatus.NOT_FOUND.value()) return "/error/404Error";
	        else if(statusCode == HttpStatus.METHOD_NOT_ALLOWED.value()) return "/error/405Error";
	        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) return "/error/500Error";
	        else if(statusCode == HttpStatus.SERVICE_UNAVAILABLE.value()) return "/error/503Error";
	        else if(statusCode == HttpStatus.HTTP_VERSION_NOT_SUPPORTED.value()) return "/error/505Error";
	    }
        return "/error/500Error";
    }

	@Override
	public String getErrorPath() { return "/error"; }
}
