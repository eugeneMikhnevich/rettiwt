package com.training.rettiwt.web.controller;

import com.training.rettiwt.model.Post;
import com.training.rettiwt.service.api.PostService;
import com.training.rettiwt.web.converter.PostDtoConverter;
import com.training.rettiwt.web.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("posts")
public class PostController {

    private PostService postService;
    private PostDtoConverter postDtoConverter;

    @Autowired
    public PostController(final PostService postService,
                          final PostDtoConverter postDtoConverter) {
        this.postService = postService;
        this.postDtoConverter = postDtoConverter;
    }

    @GetMapping("id")
    public PostDto findById(@PathVariable(name = "id") Long id) {
        Post post = postService.findById(id);
        return postDtoConverter.convertToDto(post);
    }

    @GetMapping
    public List<PostDto> findAll() {
        return postService.findAll().stream()
                .map(postDtoConverter::convertToDto)
                .collect(toList());
    }

    @PostMapping
    public void save(@RequestBody PostDto postDto) {
        Post post = postDtoConverter.convertFromDto(postDto);
        postService.save(post);
    }

    @PutMapping("{id}")
    public void update(@PathVariable(name = "id") Long id,
                       @RequestBody PostDto postDto) {
        Post post = postDtoConverter.convertFromDto(postDto);
        postService.update(id, post);
    }

    @DeleteMapping("id")
    public void delete(@PathVariable(name = "id") Long id) {
        postService.delete(id);
    }
}
