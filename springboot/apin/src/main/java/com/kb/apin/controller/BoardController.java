package com.kb.apin.controller;

import com.kb.apin.cont.StatusEnum;
import com.kb.apin.entitiy.Board;
import com.kb.apin.message.Message;
import com.kb.apin.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository boardRepository;

    @PostMapping("new")
    @CrossOrigin
    public ResponseEntity<Message> newboard(@RequestBody Board board){
        boardRepository.save(board);

        Message message = new Message();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application",
                "json",
                Charset.forName("UTF-8")));
        message.setStatus(StatusEnum.OK);
        message.setMessage("성공");
        message.setData("insert success");
        return new ResponseEntity<>(message,headers, HttpStatus.OK);
    }

    // url -> 1/10 2/10
    // localhost:8080/api/boards/1/10
    // localhost:8080/api/boards/{page}/{number}
    //public ResponseEntity<Message> boards(@PathVariable int page,@PathVariable int number){
    @GetMapping("boards")
    @CrossOrigin
    public ResponseEntity<Message> boards(){
        List<Board> list = boardRepository.findAll();

        Message message = new Message();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application",
                                "json",
                                Charset.forName("UTF-8")));

        message.setStatus(StatusEnum.OK);
        message.setMessage("성공");
        message.setData(list);
        return new ResponseEntity<>(message,headers, HttpStatus.OK);
    }


}
