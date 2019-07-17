package com.training.rettiwt.web.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDto {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String message;
    private Integer likes;
    private Integer dislikes;
    private ProfileDto profile;
    private PostDto post;
}
