package com.Example1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.Example1.model.BoardModel;

@Mapper
public interface BoardMapper {
	@Select("SELECT * FROM board")
    List<BoardModel> boardList();
	
	@Select("SELECT * FROM board WHERE board_idx = #{board_idx}")
	BoardModel postRead(@Param("board_idx") Integer board_idx);
	
	@Insert("INSERT INTO board(board_PWD, board_TITLE, board_CONTENT) VALUES(#{board_PWD}, #{board_TITLE}, #{board_CONTENT})")
	BoardModel postWrite(@Param("board_PWD") String board_PWD,
						@Param("board_TITLE") String board_TITLE,
						@Param("board_CONTENT") String board_CONTENT);
	
	@Update("UPDATE board SET board_PWD = #{board_PWD},"
			+ "board_TITLE = #{board_TITLE},"
			+ "board_CONTENT = #{board_CONTENT}"
			+ "WHERE board_idx = #{board_idx}")
	BoardModel postModify(@Param("board_PWD") String board_PWD,
			@Param("board_TITLE") String board_TITLE,
			@Param("board_CONTENT") String board_CONTENT);
	
	@Delete("DELETE FROM board WHERE board_idx = #{board_idx}")
	Boolean postDelete (@Param("board_idx") Integer board_idx);
}
