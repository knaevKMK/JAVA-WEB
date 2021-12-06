package com.project.shop.service;

import com.project.shop.model.entity.Payment;
import com.project.shop.model.view.PaymentViewModel;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface PaymentService {
    Optional<Payment> getPaymentById(UUID id);

    void save(Payment payment);

    void seedData();

    Collection<PaymentViewModel> getAll();

    Payment findByTitle(String title);
}
