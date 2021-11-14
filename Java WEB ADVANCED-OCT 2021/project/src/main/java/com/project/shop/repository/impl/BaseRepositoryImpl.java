package com.project.shop.repository.impl;

import com.project.shop.model.entity.BaseEntity;
import com.project.shop.repository.BaseRepository;

import java.time.LocalDateTime;

public class BaseRepositoryImpl<T> implements BaseRepository<T> {

    @Override
    public <T extends BaseEntity> T onCreate(T entity) {
        entity
                .setActive(true)
                .setCreateOn(LocalDateTime.now())
                .setCreateFrom("system");

        return onModify(entity);
    }

    @Override
    public <T extends BaseEntity> T onModify(T entity) {
        entity
                .setModifiedOn(LocalDateTime.now())
                .setModifiedFrom("system");
        return entity;
    }
}
