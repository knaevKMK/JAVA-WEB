package com.project.shop.repository;

import com.project.shop.model.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<T> {
    <T extends BaseEntity> T onCreate(T entity);
    <T extends BaseEntity> T onModify(T entity);
}
