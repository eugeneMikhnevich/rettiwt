package com.training.rettiwt.dao.impl;

import com.training.rettiwt.dao.api.BaseDao;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

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
    public Entity findById(final Id id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public List<Entity> findAll() {
        final CriteriaQuery<Entity> query = entityManager.getCriteriaBuilder().createQuery(getEntityClass());
        Root<Entity> from = query.from(getEntityClass());
        query.select(from);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void update(final Entity entity) {
        entityManager.merge(entity);
        entityManager.flush();
    }

    @Override
    public void delete(final Id id) {
        entityManager.createQuery(String.format("delete from %s where id=:id", getEntityClass().getSimpleName()))
                .setParameter("id", id)
                .executeUpdate();
    }
}
