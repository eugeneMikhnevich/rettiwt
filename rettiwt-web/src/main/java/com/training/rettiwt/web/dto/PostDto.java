package com.training.rettiwt.web.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PostDto {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String message;
    private Integer likes;
    private Integer dislikes;
    private ProfileDto profile;

    @JsonManagedReference
    private List<CommentDto> comments;
}
