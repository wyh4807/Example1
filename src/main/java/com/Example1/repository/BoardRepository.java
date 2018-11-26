package com.Example1.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Example1.model.BoardModel;

public interface BoardRepository extends JpaRepository<BoardModel, Integer> {
	@Query(value = "SELECT * FROM board WHERE board_DLT = false", nativeQuery = true)
	Page<BoardModel> findAll(Pageable page);
}
