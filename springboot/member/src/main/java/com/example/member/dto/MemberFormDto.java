package com.example.member.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class MemberFormDto {

    private Long id;

    @NotEmpty(message = "이메일을 입력하세요.")
    @Email
    private String email;

    @NotEmpty(message = "이름을 입력하세요")
    private String name;
    
    @NotEmpty(message = "성별을 입력하세요")
    private String gender;
    
    @NotEmpty(message = "패스워드를 입력하세요")
    private String password;

}
