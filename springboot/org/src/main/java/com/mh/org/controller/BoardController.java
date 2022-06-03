package com.mh.org.controller;

import com.mh.org.entity.FreeBoard;
import com.mh.org.repository.FreeBoardRepository;
import com.mh.org.validator.FreeBoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.DateUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("freeboard")
@RequiredArgsConstructor
public class BoardController {

    //application.propertis 안에 있는 값을 가져온다...
    @Value("a.b.c")
    String abc;

    private final  FreeBoardRepository freeBoardRepository;
    public static final Path path = Paths.get(System.getProperty("user.dir"),
            "src/main/resources/static/myfiles");

    @GetMapping("select")
    public String select(Model model){
//        List<FreeBoard> list=freeBoardRepository.stateendselect("2022-05-30","2022-06-01");
//        System.out.println(list);

        Pageable pa = PageRequest.of(0,5, Sort.by(Sort.Direction.DESC,"id"));
//        Page<FreeBoard> list = freeBoardRepository.findByTitleContainingIgnoreCase("ㅈ",pa);
//        System.out.println(list);

        Page<FreeBoard> list = freeBoardRepository.mycustomQuery("",pa);
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
    public String insert( MultipartFile multipartFile[], FreeBoardDto dto){

        for ( int i =0; i < multipartFile.length;i++){
            MultipartFile mf = multipartFile[i];
            if(!mf.isEmpty()){
                String filename = UUID.randomUUID() +mf.getOriginalFilename();
                if(i==0) {
                    dto.setFileName1(filename);
                    dto.setOri_filename1(mf.getOriginalFilename());
                }
                else {
                    dto.setFileName2(filename);
                    dto.setOri_filename2(mf.getOriginalFilename());
                }
                // UUID + Filename
                File file = new File(
                        path.toAbsolutePath().toString()+File.separator+ filename);
                try {
                    mf.transferTo(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        FreeBoard freeBoard = FreeBoard.builder()
                .filename1(dto.getFileName1())
                .ori_filename1(dto.getOri_filename1())
                .ori_filename2(dto.getOri_filename2())
                .filename2(dto.getFileName2())
                .name(dto.getName())
                .title(dto.getTitle())
                .wdate(LocalDateTime.now())
                .content(dto.getContent()).build();

        freeBoardRepository.save(freeBoard);


        return "redirect:/freeboard/select";
    }

    @GetMapping("view")
    public String view(Long id,Model model){

        FreeBoard freeboard= freeBoardRepository
                            .findById(id)
                            .orElse(new FreeBoard());
        model.addAttribute("freeboard",freeboard);

        return "freeboard/view";
    }


}
