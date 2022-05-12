package com.example.member.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class BoardTail {

    @Id
    @Column(name = "boardtailid", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "boardid")
    Board board;

    public BoardTail() {

    }
}
