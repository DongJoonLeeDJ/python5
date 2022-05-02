package com.example.member.controller;

import com.example.member.entity.Member;
import com.example.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("memberapi")
public class MemberApiController {

    @Autowired
    MemberRepository memberRepository;

    // insert
    @GetMapping("add")
    @CrossOrigin
    public @ResponseBody String add(String email,String name,String password){
        Member member = new Member();
        member.setEmail(email);
        member.setPassword(password);
        member.setName(name);

        memberRepository.save(member);
        return "add";
    }

    // select
    @GetMapping("all")
    @CrossOrigin
    public @ResponseBody List<Member> all(){
        List<Member> list = memberRepository.findAll();
        return list;
    }

}
