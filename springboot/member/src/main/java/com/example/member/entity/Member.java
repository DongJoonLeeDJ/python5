package com.example.member.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data   // setter getter 안만들어도 됩니다...lombok/...
@AllArgsConstructor
@RequiredArgsConstructor
public class Member {

    @Id //table 기본키입니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String gender;


}
