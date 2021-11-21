package com.project.shop.infrastructure.identity.DAO;

public interface EmailSender {
    void send(String to, String email);
}
