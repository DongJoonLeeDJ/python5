package com.rest.api.controller;

import com.rest.api.cont.StatusEnum;
import com.rest.api.entity.Board;
import com.rest.api.message.Message;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api")
public class BoardController {

    // url -> 1/10 2/10
    // localhost:8080/api/boards/1/10
    // localhost:8080/api/boards/{page}/{number}
    //public ResponseEntity<Message> boards(@PathVariable int page,@PathVariable int number){
    @GetMapping("boards")
    @CrossOrigin
    public ResponseEntity<Message> boards(){
        List<Board> list = Arrays.asList(
                new Board(1L,"제11","20220519","냉무11",0),
                new Board(2L,"제22","20220519","냉무22",0),
                new Board(3L,"제목3123123","20220519","냉무33",0),
                new Board(4L,"111122","20220519","냉무33",0)
        );

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
