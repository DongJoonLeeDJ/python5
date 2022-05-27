package com.mh.org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("freeboard")
public class BoardController {

    @GetMapping("select")
    public String select(){
        return "freeboard/select";
    }

    @GetMapping("insert")
    public String insert(){
        return "freeboard/insert";
    }
}
