package com.example.member.controller;

import com.example.member.entity.Member;
import com.example.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("member")
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    @GetMapping("findall")
    public String findall(Model model){
        List<Member> list =  memberRepository.findAll();

        model.addAttribute("list",list);
        return "member/findall";
    }

    @GetMapping("insert")
    public String insert(){

        return "member/insert";
    }
}
