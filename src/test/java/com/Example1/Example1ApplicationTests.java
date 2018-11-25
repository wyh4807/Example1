package com.Example1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.Example1.mapper.BoardMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Example1ApplicationTests {
	
	@Autowired
	BoardMapper boardMapper;

	private Logger logger = LoggerFactory.getLogger(this.getClass());
/*
	@Test
	public void BoardList() {
		logger.info("------ 리스트 출력 ------");
		logger.info(boardMapper.boardList().toString());
	}
	
	@Test
	public void postRead() {
		logger.info("------ 게시글 출력 ------");
		logger.info(boardMapper.postRead(1).toString());
	}
	
	public void postWrite() {
		logger.info("------ 삭제 여부 ------");
		logger.info(boardMapper.postDelete(1).toString());
		logger.info("------ 리스트 출력 ------");
		logger.info(boardMapper.boardList().toString());
	}
	
	@Test
	public void postModify() {}
	*/
	
	@Test
	public void postDelete() {
		logger.info("------ 삭제 여부 ------");
		logger.info(boardMapper.postDelete(1).toString());
		logger.info("------ 리스트 출력 ------");
		logger.info(boardMapper.boardList().toString());
	}

}
