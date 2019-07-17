package com.training.rettiwt.service.api;

import com.training.rettiwt.model.Post;

public interface PostService extends Service<Post, Long> {

    Post findByIdWithComments(Long id);
}
