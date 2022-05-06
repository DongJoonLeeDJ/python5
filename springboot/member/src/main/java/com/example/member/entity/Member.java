package com.example.member.entity;

import com.example.member.dto.MemberFormDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data   // setter getter 안만들어도 됩니다...lombok/...
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Member {

    @Id //table 기본키입니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String gender;


    public static Member createMember(MemberFormDto memberFormDto) {
        Member member = new Member();
        member.id = memberFormDto.getId();
        member.name = memberFormDto.getName();
        member.email = memberFormDto.getEmail();
        member.password = memberFormDto.getPassword();
        member.gender = memberFormDto.getGender();
        return  member;
    }
}
