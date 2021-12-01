package com.project.shop.service.impl;

import com.project.shop.model.entity.BaseEntity;
import com.project.shop.service.BaseService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;

public class BaseServiceImpl<T> implements BaseService<T> {
    @Override
    public <T extends BaseEntity> T onCreate(T entity) {
        entity
                .setActive(true)
                .setCreateOn(LocalDateTime.now())
                .setCreateFrom("system");

        return onModify(entity,"system");
    }


    @Override
    public <T extends BaseEntity> T onCreate(T entity, String creator) {
        entity
                .setActive(true)
                .setCreateOn(LocalDateTime.now())
                .setCreateFrom(creator);

        return onModify(entity,creator);
    }

    @Override
    public <T extends BaseEntity> T onModify(T entity,String modifier) {
        entity
                .setModifiedOn(LocalDateTime.now())
                .setModifiedFrom(modifier);
        return entity;
    }

    protected Pageable getPageable(int page, int limit, String sort, String sortBy) {

        if (sortBy != null) {
            if ("desc".equals(sort)) {
                return PageRequest.of(page, limit, Sort.by(sortBy).descending());
            }
            return (PageRequest.of(page, limit, Sort.by(sortBy)));
        }
        return (PageRequest.of(page, limit));

    }
}
