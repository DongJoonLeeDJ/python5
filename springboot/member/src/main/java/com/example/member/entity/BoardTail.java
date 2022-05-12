package com.example.member.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
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
