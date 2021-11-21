package com.project.shop.infrastructure.identity.models;

import com.project.shop.model.entity.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class ConfirmationToken  {

private UUID id;
    private String token;
    private LocalDateTime createAt;
    private LocalDateTime expiredAt;
    private LocalDateTime confirmAt;
    private Account appUser;

    public ConfirmationToken(String token,
                             LocalDateTime createAt,
                             LocalDateTime expiredAt,
                             Account appUser) {
        super();
        this.token = token;
        this.createAt=createAt;
        this.expiredAt = expiredAt;
        this.appUser = appUser;

    }

    public ConfirmationToken() {
    }
    @Id
    @GeneratedValue(generator = "uuid-string")
    @GenericGenerator(name="uuid-string", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false,columnDefinition = "VARBINARY(16)")
    public UUID getId() {
        return id;
    }


    public ConfirmationToken setId(UUID id) {
        this.id = id;
        return this;
    }
    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public ConfirmationToken setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
        return this;
    }

    @Column(nullable = false)
    public String getToken() {
        return token;
    }
    @Column(nullable = false)
    public LocalDateTime getExpiredAt() {
        return expiredAt;
    }
    public LocalDateTime getConfirmAt() {
        return confirmAt;
    }

    @ManyToOne()
    @JoinColumn(nullable = false, name = "user_id")
    public Account getAppUser() {
        return appUser;
    }

    public ConfirmationToken setToken(String token) {
        this.token = token;
        return this;
    }

    public ConfirmationToken setExpiredAt(LocalDateTime expiredAt) {
        this.expiredAt = expiredAt;
        return this;
    }

    public ConfirmationToken setConfirmAt(LocalDateTime confirmAt) {
        this.confirmAt = confirmAt;
        return this;
    }

    public ConfirmationToken setAppUser(Account appUser) {
        this.appUser = appUser;
        return this;
    }
}
