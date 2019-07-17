package com.training.rettiwt.service.impl;

import com.training.rettiwt.dao.api.CommentDao;
import com.training.rettiwt.model.Comment;
import com.training.rettiwt.service.api.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static java.time.LocalDateTime.now;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentDao commentDao;

    @Autowired
    public CommentServiceImpl(final CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public void save(final Comment comment) {
        LocalDateTime now = now();
        comment.setCreatedAt(now);
        comment.setUpdatedAt(now);
        commentDao.save(comment);
    }

    @Override
    public Comment findById(final Long id) {
        return commentDao.findById(id);
    }

    @Override
    public List<Comment> findAll() {
        return commentDao.findAll();
    }

    @Override
    public void update(final Long id, final Comment comment) {
        comment.setId(id);
        comment.setUpdatedAt(now());
        commentDao.update(comment);
    }

    @Override
    public void delete(final Long id) {
        commentDao.delete(id);
    }
}
