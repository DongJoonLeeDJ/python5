package com.example.member.controller;

import com.example.member.dto.MemberFormDto;
import com.example.member.entity.Member;
import com.example.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
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
    public String insert(Model model){
        model.addAttribute("memberformdto",new MemberFormDto());
        return "member/insert";
    }

    @PostMapping("insert")
    public String insert(Model model, @Valid MemberFormDto memberFormDto, BindingResult bindingResult){
        model.addAttribute("memberformdto",new MemberFormDto());
        // 에러가 있으면... insert 화면 다시 가라..
        if(bindingResult.hasErrors()){
            return "member/insert";
        }
        // 에러 없으면 select 화면 가라...
        return "redirect:findall";
    }
}
