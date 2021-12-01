package com.project.shop.service;

import com.project.shop.model.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseService<T> {
    <T extends BaseEntity> T onCreate(T entity);
    <T extends BaseEntity> T onCreate(T entity,String creator);
    <T extends BaseEntity> T onModify(T entity,String modifier);
}
