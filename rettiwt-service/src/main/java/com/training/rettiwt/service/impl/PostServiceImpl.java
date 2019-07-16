package com.training.rettiwt.service.impl;

import com.training.rettiwt.dao.api.PostDao;
import com.training.rettiwt.model.Post;
import com.training.rettiwt.service.api.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.time.LocalDateTime.now;

@Service
public class PostServiceImpl implements PostService {

    private PostDao postDao;

    @Autowired
    public PostServiceImpl(final PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public void save(final Post post) {
        post.setCreatedAt(now());
        postDao.save(post);
    }

    @Override
    public Post findById(final Long id) {
        return postDao.findById(id);
    }

    @Override
    public List<Post> findAll() {
        return postDao.findAll();
    }

    @Override
    public void update(final Long id, final Post post) {
        post.setCreatedAt(now());
        post.setUpdatedAt(now());
        postDao.update(post);
    }

    @Override
    public void delete(final Long id) {
        postDao.delete(id);
    }
}
