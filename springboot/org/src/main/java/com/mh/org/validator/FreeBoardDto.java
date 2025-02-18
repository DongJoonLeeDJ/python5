package com.mh.org.validator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class FreeBoardDto {

    private Long id;

    @NotEmpty(message = "제목을 입력하세요")
    private String title;

    @NotEmpty(message = "작성자를 입력하세요")
    private String name;
    
    @NotEmpty(message = "내용을 입력하세요")
    private String content;
    
    private int count;
    private LocalDateTime wdate;

    // 파일이름 중복 안나게 문자열 잘 만들어주는 역활
    private String fileName1;
    private String fileName2;
    private String ori_filename1;
    private String ori_filename2;


    public FreeBoardDto() {}

}
