package com.example.member.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Board {

    @Id
    @Column(name = "boardid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private String wdate;

    @OneToMany(mappedBy = "board",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.EAGER)
    List<BoardTail> list = new ArrayList<>();
}
