package com.training.rettiwt.dao.impl;

import com.training.rettiwt.dao.api.BaseDao;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public abstract class BaseDaoImpl<Entity, Id> implements BaseDao<Entity, Id> {

    @PersistenceContext
    private EntityManager entityManager;

    @Getter
    private Class<Entity> entityClass;


    BaseDaoImpl(final Class<Entity> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public void save(final Entity entity) {
        entityManager.persist(entity);
    }

    @Override
    public Entity get(final Id id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public void update(final Entity entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(final Id id) {
        entityManager.createNamedQuery(String.format("delete from %s where id=:id", getEntityClass()))
                .setParameter("id", id)
                .executeUpdate();
    }
}
