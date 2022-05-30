package com.mh.org.controller;

import com.mh.org.entity.FreeBoard;
import com.mh.org.repository.FreeBoardRepository;
import com.mh.org.validator.FreeBoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.DateUtils;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("freeboard")
@RequiredArgsConstructor
public class BoardController {

    private final  FreeBoardRepository freeBoardRepository;

    @GetMapping("select")
    public String select(Model model){
//        List<FreeBoard> list=freeBoardRepository.stateendselect("2022-05-30","2022-06-01");
//        System.out.println(list);

        Pageable pa = PageRequest.of(1,5, Sort.by(Sort.Direction.DESC,"id"));
//        Page<FreeBoard> list = freeBoardRepository.findByTitleContainingIgnoreCase("ㅈ",pa);
//        System.out.println(list);

        Page<FreeBoard> list = freeBoardRepository.mycustomQuery("ㅈㅈ",pa);
        System.out.println(list);

        model.addAttribute("list",list);
//        model.addAttribute("mydate", new Date());

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
                .wdate(LocalDateTime.now())
                .content(dto.getContent()).build();

        freeBoardRepository.save(freeBoard);
        return "redirect:/freeboard/select";
    }
}
