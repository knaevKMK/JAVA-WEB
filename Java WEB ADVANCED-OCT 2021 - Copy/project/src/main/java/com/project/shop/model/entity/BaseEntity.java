package com.project.shop.model.entity;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

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
    private String createFrom;
    private boolean isActive;
    private LocalDateTime modifiedOn;
    private String  modifiedFrom;

    public BaseEntity() {
    }

    @Id
    @GeneratedValue(generator = "uuid-string")
    @GenericGenerator(name="uuid-string", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false,columnDefinition = "VARBINARY(16)")
    public UUID getId() {
        return id;
    }

    public BaseEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getCreateFrom() {
        return createFrom;
    }

    public BaseEntity setCreateFrom(String createFrom) {
        this.createFrom = createFrom;
        return this;
    }
    @CreationTimestamp
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
    @UpdateTimestamp
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
