package com.training.rettiwt.web.controller;

import com.training.rettiwt.model.Post;
import com.training.rettiwt.service.api.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(final PostService postService) {
        this.postService = postService;
    }

    @GetMapping("id")
    public Post findById(@PathVariable(name = "id") Long id) {
        return postService.findById(id);
    }

    @GetMapping
    public List<Post> findAll() {
        return postService.findAll();
    }

    @PostMapping
    public void save(@RequestBody Post post) {
        postService.save(post);
    }

    @PutMapping("{id}")
    public void update(@PathVariable(name = "id") Long id,
                       @RequestBody Post post) {
        postService.update(id, post);
    }

    @DeleteMapping("id")
    public void delete(@PathVariable(name = "id") Long id) {
        postService.delete(id);
    }
}
