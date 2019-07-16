package com.training.rettiwt.service.api;

public interface Service<Entity, Id> {

    void save(Entity entity);

    Entity get(Id id);

    void update(Entity entity);

    void delete(Id id);
}
