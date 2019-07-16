package com.training.rettiwt.service.api;

import javax.transaction.Transactional;
import java.util.List;

public interface Service<Entity, Id> {

    @Transactional
    void save(Entity entity);

    Entity findById(Id id);

    List<Entity> findAll();

    @Transactional
    void update(Id id, Entity entity);

    @Transactional
    void delete(Id id);
}
