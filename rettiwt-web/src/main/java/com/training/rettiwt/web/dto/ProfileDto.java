package com.training.rettiwt.web.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProfileDto {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String firstName;
    private String lastName;
    private String nickname;
    private String description;
    private String location;
    private AccountDto account;
}
