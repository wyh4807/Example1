package com.Example1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Example1.model.BoardModel;
import com.Example1.repository.BoardRepository;
import com.Example1.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardRepository boardRepository;
	
	@Override
	public Page<BoardModel> getAllBoardModel(Pageable page) {
		return boardRepository.findAll(page);
	}

}
