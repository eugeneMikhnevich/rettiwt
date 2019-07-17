package com.training.rettiwt.dao.impl;

import com.training.rettiwt.dao.api.CommentDao;
import com.training.rettiwt.model.Comment;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDaoImpl extends BaseDaoImpl<Comment, Long> implements CommentDao {

    public CommentDaoImpl() {
        super(Comment.class);
    }
}
