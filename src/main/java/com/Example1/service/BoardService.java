package com.Example1.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Example1.model.BoardModel;

@Service
public interface BoardService {
	Page<BoardModel> getAllBoardModel(Pageable page);
}
