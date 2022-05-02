package com.example.member.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class MemberFormDto {

    private Long id;

    @NotEmpty(message = "빈공백 할수 없다...")
    private String email;

    private String name;
    private String gender;
    private String password;

}
