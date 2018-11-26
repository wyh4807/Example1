package com.Example1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "board")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardModel {
    @Id
    @Column(length = 10, nullable = false)
    private Integer board_IDX;
    
    @Column(length = 1, nullable = false)
    private Boolean board_DLT;
    
    @Column(length = 30, nullable = false)
    private String board_PWD;
    
    @Column(length = 30, nullable = false)
    private String board_TITLE;
    
    @Column(nullable = false)
    private String board_CONTENT;
}
