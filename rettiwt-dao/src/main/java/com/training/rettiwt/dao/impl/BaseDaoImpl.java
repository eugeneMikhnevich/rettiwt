package com.training.rettiwt.dao.impl;

import com.training.rettiwt.dao.api.BaseDao;
import com.training.rettiwt.model.BaseEntity;
import org.springframework.stereotype.Repository;

@Repository
public abstract class BaseDaoImpl<Entity extends BaseEntity> implements BaseDao<Entity, Long> {
}
