package com.Example1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Example1.model.BoardModel;

public interface BoardRepository extends JpaRepository<BoardModel, Integer> {}
