package com.example.member.controller;

import com.example.member.entity.Board;
import com.example.member.entity.BoardTail;
import com.example.member.repository.BoardRepository;
import com.example.member.repository.BoardTailRepository;
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

    @Autowired
    BoardTailRepository boardTailRepository;

    @GetMapping("findall")
    public String findall(Model model){
        boardRepository.save(
                new Board(1L,"aatitle","aacontent", LocalDate.now().toString(),null));
        boardRepository.save(
                new Board(2L,"bbtitle","bbcontent", LocalDate.now().toString(),null));
        boardRepository.save(
                new Board(3L,"cctitle","cccontent", LocalDate.now().toString(),null));
        List<Board> list = boardRepository.findAll();

        model.addAttribute("list",list);
        return "board/findall";
    }

    @GetMapping("view")
    public String view(Model model, Long boardid){
        Board board = boardRepository
                .findById(boardid).orElse(new Board());

//        boardTailRepository.save(new BoardTail(1L,"댓글1","내용1",board));
//        boardTailRepository.save(new BoardTail(2L,"댓글2","내용2",board));
//        System.out.println(board);

        model.addAttribute("board",board);
        return "board/view";
    }
}
