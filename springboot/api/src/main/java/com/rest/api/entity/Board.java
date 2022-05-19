package com.rest.api.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Board {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;
    private String wdate;
    private String content;
    private int count;
}
