package com.training.rettiwt.dao.impl;

import org.springframework.stereotype.Repository;

@Repository
public class PostDaoImpl extends BaseDaoImpl<PostDaoImpl, Long> {

    public PostDaoImpl(final Class<PostDaoImpl> postClass) {
        super(PostDaoImpl.class);
    }
}
