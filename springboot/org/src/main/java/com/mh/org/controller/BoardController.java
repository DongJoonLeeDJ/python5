package com.mh.org.controller;

import com.mh.org.entity.FreeBoard;
import com.mh.org.repository.FreeBoardRepository;
import com.mh.org.validator.FreeBoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("freeboard")
@RequiredArgsConstructor
public class BoardController {

    private final  FreeBoardRepository freeBoardRepository;

    @GetMapping("select")
    public String select(){
        return "freeboard/select";
    }

    @GetMapping("insert")
    public String insert(){
        return "freeboard/insert";
    }

    @PostMapping("insert")
    public String insert(FreeBoardDto dto){
        FreeBoard freeBoard = FreeBoard.builder()
                .name(dto.getName())
                .title(dto.getTitle())
                .content(dto.getContent()).build();

        freeBoardRepository.save(freeBoard);
        return "redirect:/freeboard/select";
    }
}
