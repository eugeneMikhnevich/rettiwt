package com.training.rettiwt.dao.api;

import com.training.rettiwt.model.Post;

public interface PostDao extends BaseDao<Post, Long> {

    Post findByIdWithComments(Long id);
}
