package com.kb.apin.entitiy;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Board {
    @Id
    @Column(name = "boardid", nullable = false)
    @GeneratedValue(generator = "board_seq", strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String wdate;
    private String content;
    private int count;

}
