package com.project.shop.model;


import org.hibernate.annotations.GenericGenerator;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity {


    private UUID id;
    private LocalDateTime createOn;
    private boolean isActive;
    private LocalDateTime modifiedOn;
    private String  modifiedFrom;

    public BaseEntity() {
    }

    @Id
    @GeneratedValue(generator = "uuid-string")
    @GenericGenerator(name="uuid-string", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    public UUID getId() {
        return id;
    }

    public BaseEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getCreateOn() {
        return createOn;
    }

    public BaseEntity setCreateOn(LocalDateTime createOn) {
        this.createOn = createOn;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public BaseEntity setActive(boolean active) {
        isActive = active;
        return this;
    }

    public LocalDateTime getModifiedOn() {
        return modifiedOn;
    }

    public BaseEntity setModifiedOn(LocalDateTime modifiedOn) {
        this.modifiedOn = modifiedOn;
        return this;
    }

    public String getModifiedFrom() {
        return modifiedFrom;
    }

    public BaseEntity setModifiedFrom(String modifiedFrom) {
        this.modifiedFrom = modifiedFrom;
        return this;
    }
}
