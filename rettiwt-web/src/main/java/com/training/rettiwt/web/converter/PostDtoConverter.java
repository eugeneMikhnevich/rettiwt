package com.training.rettiwt.web.converter;

import com.training.rettiwt.model.Comment;
import com.training.rettiwt.model.Post;
import com.training.rettiwt.model.Profile;
import com.training.rettiwt.web.dto.CommentDto;
import com.training.rettiwt.web.dto.PostDto;
import com.training.rettiwt.web.dto.ProfileDto;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.LazyInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@Component
public class PostDtoConverter {

    private ProfileDtoConverter profileDtoConverter;
    private CommentDtoConverter commentDtoConverter;

    @Autowired
    public PostDtoConverter(final ProfileDtoConverter profileDtoConverter,
                            final CommentDtoConverter commentDtoConverter) {
        this.profileDtoConverter = profileDtoConverter;
        this.commentDtoConverter = commentDtoConverter;
    }

    public PostDto convertToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setCreatedAt(post.getCreatedAt());
        postDto.setUpdatedAt(post.getUpdatedAt());
        postDto.setMessage(post.getMessage());
        postDto.setLikes(post.getLikes());
        postDto.setDislikes(post.getDislikes());
        postDto.setProfile(profileDtoConverter.convertToDto(post.getProfile()));
        try {
            List<CommentDto> comments = post.getComments().stream()
                    .map(comment -> convertCommentToDto(comment, postDto))
                    .collect(toList());
            postDto.setComments(comments);
        } catch (LazyInitializationException e) {
            log.info("ignore converting comments");
        }
        return postDto;
    }

    public Post convertFromDto(PostDto postDto) {
        Post post = new Post();
        post.setId(postDto.getId());
        post.setCreatedAt(postDto.getCreatedAt());
        post.setUpdatedAt(postDto.getUpdatedAt());
        post.setMessage(postDto.getMessage());
        post.setLikes(postDto.getLikes());
        post.setDislikes(postDto.getDislikes());
        ProfileDto profileDto = postDto.getProfile();
        if (profileDto != null) {
            post.setProfile(profileDtoConverter.convertFromDto(profileDto));
        }
        return post;
    }

    private CommentDto convertCommentToDto(Comment comment, PostDto postDto) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setCreatedAt(comment.getCreatedAt());
        commentDto.setUpdatedAt(comment.getUpdatedAt());
        commentDto.setMessage(comment.getMessage());
        commentDto.setLikes(comment.getLikes());
        commentDto.setDislikes(comment.getDislikes());
        Profile profileDto = comment.getProfile();
        if (profileDto != null) {
            commentDto.setProfile(profileDtoConverter.convertToDto(profileDto));
        }
        commentDto.setPost(postDto);
        return commentDto;
    }
}
