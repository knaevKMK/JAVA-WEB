package com.project.shop.service.impl;

import com.project.shop.model.entity.BaseEntity;
import com.project.shop.service.BaseService;

import java.time.LocalDateTime;

public class BaseServiceImpl<T> implements BaseService<T> {

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
