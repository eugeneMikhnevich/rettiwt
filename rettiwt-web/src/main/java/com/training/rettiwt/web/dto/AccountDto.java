package com.training.rettiwt.web.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AccountDto {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String email;
    private String password;
    private String phone;
    private Boolean deleted;
}
