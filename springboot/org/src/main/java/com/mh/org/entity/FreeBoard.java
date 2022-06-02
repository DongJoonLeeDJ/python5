package com.mh.org.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class FreeBoard {
//    번호	제목	작성자	추천	조회	등록일
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "freeboard_seq",strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String name;

    @Column(columnDefinition = "int default 0")
    private int count;

    @Column(columnDefinition = "text")
//    @Lob
    private String content;

    @Column(columnDefinition = "datetime default CURRENT_TIMESTAMP")
    private LocalDateTime wdate;

    private String filename1;
    private String filename2;

    public FreeBoard() {}


}
