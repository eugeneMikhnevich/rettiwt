package com.training.rettiwt.dao.api;

import java.util.List;

public interface BaseDao<Entity, Id> {

    void save(Entity entity);

    Entity findById(Id id);

    List<Entity> findAll();

    void update(Entity entity);

    void delete(Id id);

}
