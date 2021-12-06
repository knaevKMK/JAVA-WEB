package com.project.shop.service.impl;

import com.project.shop.model.entity.Payment;
import com.project.shop.model.enums.PaymentEnum;
import com.project.shop.model.view.PaymentViewModel;
import com.project.shop.repository.PaymentRepository;
import com.project.shop.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl extends BaseServiceImpl<Payment> implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final ModelMapper modelMapper;

    public PaymentServiceImpl(PaymentRepository paymentRepository, ModelMapper modelMapper) {
        this.paymentRepository = paymentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<Payment> getPaymentById(UUID id) {
        return this.paymentRepository.findById(id);
    }

    @Override
    public void save(Payment payment) {
        this.paymentRepository.saveAndFlush(payment);
    }

    @Override
    public void seedData() {
        if (paymentRepository.count()>0){
            return;
        }
        Arrays.stream(PaymentEnum.values())
                .forEach(paymentEnum -> {
                    Payment payment =onCreate( new Payment());
                    payment.setTitle(paymentEnum.getTitle());
                    paymentRepository.saveAndFlush(payment);
                });
    }

    @Override
    public Collection<PaymentViewModel> getAll() {
                return  paymentRepository.findAll()
                .stream().map(e->modelMapper.map(e,PaymentViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public Payment findByTitle(String title) {

        Collection<Payment> list = paymentRepository.findByTitle(title);
        return               list.stream().findFirst()
                            .orElseThrow(()-> new NullPointerException("payment does not exist"));
    }
}
