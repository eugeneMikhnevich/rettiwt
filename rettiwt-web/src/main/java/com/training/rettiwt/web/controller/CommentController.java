package com.training.rettiwt.web.controller;

import com.training.rettiwt.model.Comment;
import com.training.rettiwt.service.api.CommentService;
import com.training.rettiwt.web.converter.CommentDtoConverter;
import com.training.rettiwt.web.dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("comments")
public class CommentController {

    private CommentService commentService;
    private CommentDtoConverter commentDtoConverter;

    @Autowired
    public CommentController(final CommentService commentService,
                             final CommentDtoConverter commentDtoConverter) {
        this.commentService = commentService;
        this.commentDtoConverter = commentDtoConverter;
    }

    @GetMapping("{id}")
    public CommentDto findById(@PathVariable(name = "id") Long id) {
        Comment comment = commentService.findById(id);
        return commentDtoConverter.convertToDto(comment);
    }

    @GetMapping
    public List<CommentDto> findAll() {
        return commentService.findAll().stream()
                .map(commentDtoConverter::convertToDto)
                .collect(toList());
    }

    @PostMapping
    public void save(@RequestBody CommentDto commentDto) {
        Comment comment = commentDtoConverter.convertFromDto(commentDto);
        commentService.save(comment);
    }

    @PutMapping("{id}")
    public void update(@PathVariable(name = "id") Long id,
                       @RequestBody CommentDto commentDto) {
        Comment comment = commentDtoConverter.convertFromDto(commentDto);
        commentService.update(id, comment);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable(name = "{id}") Long id) {
        commentService.delete(id);
    }
}
