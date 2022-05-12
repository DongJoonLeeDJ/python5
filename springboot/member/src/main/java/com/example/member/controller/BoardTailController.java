package com.example.member.controller;

import com.example.member.entity.Board;
import com.example.member.entity.BoardTail;
import com.example.member.repository.BoardRepository;
import com.example.member.repository.BoardTailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("boardtail")
public class BoardTailController {

    @Autowired
    BoardTailRepository boardTailRepository;

    @Autowired
    BoardRepository boardRepository;

    @PostMapping("insert")
    public String insert(BoardTail boardTail,Long boardid){
        Board board = boardRepository.findById(boardid).orElse(null);
        boardTail.setBoard(board);
        boardTailRepository.save(boardTail);

        return "redirect:/board/view?boardid="+board.getId();
    }
}
