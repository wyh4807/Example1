package com.Example1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "board")
@Data
public class BoardModel {
    @Id
    @Column(length = 10, nullable = false)
    Integer board_IDX;
    
    @Column(length = 1, nullable = false)
    String board_DLT;
    
    @Column(length = 30, nullable = false)
    String board_PWD;
    
    @Column(length = 30, nullable = false)
    String board_TITLE;
    
    @Column(nullable = false)
    String board_CONTENT;
}
