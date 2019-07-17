package com.training.rettiwt.web.converter;

import com.training.rettiwt.model.Comment;
import com.training.rettiwt.model.Post;
import com.training.rettiwt.web.dto.CommentDto;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.LazyInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CommentDtoConverter {

    private ProfileDtoConverter profileDtoConverter;
    private PostDtoConverter postDtoConverter;

    @Autowired
    public CommentDtoConverter(final ProfileDtoConverter profileDtoConverter) {
        this.profileDtoConverter = profileDtoConverter;
    }

    @Autowired
    public void setPostDtoConverter(final PostDtoConverter postDtoConverter) {
        this.postDtoConverter = postDtoConverter;
    }

    public CommentDto convertToDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setCreatedAt(comment.getCreatedAt());
        commentDto.setUpdatedAt(comment.getUpdatedAt());
        commentDto.setMessage(comment.getMessage());
        commentDto.setLikes(comment.getLikes());
        commentDto.setDislikes(comment.getDislikes());
        commentDto.setProfile(profileDtoConverter.convertToDto(comment.getProfile()));
        try {
            Post post = comment.getPost();
            commentDto.setPost(postDtoConverter.convertToDto(post));
        } catch (LazyInitializationException e) {
            log.info("ignore post converting");
        }
        return commentDto;
    }

    public Comment convertFromDto(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setCreatedAt(commentDto.getCreatedAt());
        comment.setUpdatedAt(commentDto.getUpdatedAt());
        comment.setMessage(commentDto.getMessage());
        comment.setLikes(commentDto.getLikes());
        comment.setDislikes(commentDto.getDislikes());
        comment.setProfile(profileDtoConverter.convertFromDto(commentDto.getProfile()));
        comment.setPost(postDtoConverter.convertFromDto(commentDto.getPost()));
        return comment;
    }
}
