package com.training.rettiwt.dao.api;

public interface BaseDao<Entity, Id> {

    void create(Entity entity);

    Entity read(Id id);

    void update(Entity entity);

    void delete(Id id);

}
