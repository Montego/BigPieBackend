package com.bigpie.big_pie_project.dto;

import lombok.Data;

@Data
public class AuthenticationRequestDto {
    private String username;
    private String password;
}
