package com.example.member.controller;

import com.example.member.entity.Board;
import com.example.member.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("board")
public class BoardController {

    @Autowired
    BoardRepository boardRepository;

    @GetMapping("findall")
    public String findall(Model model){
        boardRepository.save(
                new Board(1L,"aatitle","aacontent", LocalDate.now().toString()));
        boardRepository.save(
                new Board(2L,"bbtitle","bbcontent", LocalDate.now().toString()));
        boardRepository.save(
                new Board(3L,"cctitle","cccontent", LocalDate.now().toString()));
        List<Board> list = boardRepository.findAll();

        model.addAttribute("list",list);
        return "board/findall";
    }
}
