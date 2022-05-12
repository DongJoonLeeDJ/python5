package com.example.member.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
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
            fetch = FetchType.LAZY)
    List<BoardTail> list = new ArrayList<>();
}
