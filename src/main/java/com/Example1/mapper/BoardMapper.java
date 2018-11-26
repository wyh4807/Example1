package com.Example1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.Example1.model.BoardModel;

@Mapper
public interface BoardMapper {
	@Select("SELECT * FROM board WHERE board_DLT = false")
    List<BoardModel> boardList();
	
	@Select("SELECT * FROM board WHERE board_IDX = #{board_IDX} AND board_DLT = false")
	BoardModel postRead(@Param("board_IDX") Integer board_IDX);
	
	@Insert("INSERT INTO board(board_PWD, board_TITLE, board_CONTENT) VALUES(#{boardModel.board_PWD},"
			+ "#{boardModel.board_TITLE}, "
			+ "#{boardModel.board_CONTENT})")
	Boolean postWrite(@Param("boardModel") BoardModel boardModel);
	
	@Select("SELECT board_IDX FROM board ORDER BY board_IDX DESC LIMIT 1")
    String getWritePostIDX();
	
	
	@Update("UPDATE board SET board_PWD = #{boardModel.board_PWD},"
			+ "board_TITLE = #{boardModel.board_TITLE},"
			+ "board_CONTENT = #{boardModel.board_CONTENT}"
			+ "WHERE board_IDX = #{boardModel.board_IDX}")
	BoardModel postModify(@Param("boardModel") BoardModel boardModel);
	
	@Update("UPDATE board SET board_DLT = 1"
			+ "WHERE board_IDX = #{board_IDX}")
	Boolean postDelete (@Param("board_IDX") Integer board_IDX);
}
