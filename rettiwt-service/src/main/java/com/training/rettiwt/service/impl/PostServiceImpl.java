package com.training.rettiwt.service.impl;

import com.training.rettiwt.dao.api.PostDao;
import com.training.rettiwt.model.Post;
import com.training.rettiwt.service.api.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostDao postDao;

    @Autowired
    public PostServiceImpl(final PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public void save(final Post post) {
        postDao.save(post);
    }

    @Override
    public Post get(final Long id) {
        return postDao.get(id);
    }

    @Override
    public void update(final Post post) {
        postDao.update(post);
    }

    @Override
    public void delete(final Long id) {
        postDao.delete(id);
    }
}
