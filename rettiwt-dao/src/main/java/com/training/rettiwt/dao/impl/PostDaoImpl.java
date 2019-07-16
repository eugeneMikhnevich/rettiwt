package com.training.rettiwt.dao.impl;

import com.training.rettiwt.dao.api.PostDao;
import com.training.rettiwt.model.Post;
import org.springframework.stereotype.Repository;

@Repository
public class PostDaoImpl extends BaseDaoImpl<Post, Long> implements PostDao {

    public PostDaoImpl() {
        super(Post.class);
    }
}
