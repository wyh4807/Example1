package com.Example1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/")
	public String index(Model model){
		return "index";
	}
	
	@GetMapping("/Board/{boardIndex}")
	public String postRead(Model model,
			@PathVariable(required = true, value = "boardIndex") Integer boardIndex) {
		return "post";
	}
	
	@PostMapping("/Board/{boardIndex}")
	public String postWrite(Model model) {
		return "index";
	}
	
	@DeleteMapping("/Board/{boardIndex}")
	public String postDelete(Model model,
			@PathVariable(required = true, value = "boardIndex") Integer boardIndex) {
		return "index";
	}

}
