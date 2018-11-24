package com.Example1.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.Example1.dao.BoardDao;
import com.Example1.model.BoardModel;

public class BoardDaoImpl implements BoardDao {

	@Override
	public List<BoardModel> boardList() throws ClassNotFoundException, SQLException {
		Connection conn = getConn();
		return null;
	}

	@Override
	public BoardModel postRead(Integer boardIndex) throws ClassNotFoundException, SQLException {
		Connection conn = getConn();
		
		return null;
	}

	@Override
	public BoardModel postWrite() throws ClassNotFoundException, SQLException {
		Connection conn = getConn();
		return null;
	}

	@Override
	public BoardModel postModify() throws ClassNotFoundException, SQLException {
		Connection conn = getConn();
		return null;
	}

	@Override
	public Boolean postDelete(Integer boardIndex) throws ClassNotFoundException, SQLException {
		Connection conn = getConn();
		return null;
	}

}
