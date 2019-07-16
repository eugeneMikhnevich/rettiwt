package com.training.rettiwt.dao.api;

public interface BaseDao<Entity, Id> {

    void save(Entity entity);

    Entity get(Id id);

    void update(Entity entity);

    void delete(Id id);

}
