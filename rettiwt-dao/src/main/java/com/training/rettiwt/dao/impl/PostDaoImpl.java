package com.training.rettiwt.dao.impl;

import com.training.rettiwt.dao.api.PostDao;
import com.training.rettiwt.model.Post;
import com.training.rettiwt.model.Post_;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

@Repository
public class PostDaoImpl extends BaseDaoImpl<Post, Long> implements PostDao {

    public PostDaoImpl() {
        super(Post.class);
    }

    @Override
    public Post findByIdWithComments(final Long id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> query = criteriaBuilder.createQuery(getEntityClass());
        Root<Post> from = query.from(getEntityClass());
        query.select(from)
                .where(criteriaBuilder.equal(from.get("id"), id));
        from.fetch("comments", JoinType.LEFT);
        TypedQuery<Post> typedQuery = entityManager.createQuery(query);
        return typedQuery.getSingleResult();
    }
}
