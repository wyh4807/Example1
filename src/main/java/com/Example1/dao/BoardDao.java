package com.Example1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.Example1.model.BoardModel;
public interface BoardDao {
	public List<BoardModel> boardList() throws ClassNotFoundException, SQLException; 
	public BoardModel postRead(Integer boardIndex)throws ClassNotFoundException, SQLException; 
	public BoardModel postWrite()throws ClassNotFoundException, SQLException; 
	public BoardModel postModify()throws ClassNotFoundException, SQLException; 
	public Boolean postDelete(Integer boardIndex)throws ClassNotFoundException, SQLException;
	
	default public Connection getConn() throws ClassNotFoundException, SQLException {
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "1234");
		return conn;
	}

}
