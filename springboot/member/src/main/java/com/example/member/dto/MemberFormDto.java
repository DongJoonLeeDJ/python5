package com.example.member.dto;

import lombok.*;

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
