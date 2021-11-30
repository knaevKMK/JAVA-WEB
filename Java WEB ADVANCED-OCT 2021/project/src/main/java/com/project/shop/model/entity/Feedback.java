package com.project.shop.model.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "feedbacks")
public class Feedback extends BaseEntity{
    private String request;
    private String response;
    private Order order;
    private boolean isPositive;
    public Feedback() {
    }

    public boolean isPositive() {
        return isPositive;
    }

    public Feedback setPositive(boolean positive) {
        isPositive = positive;
        return this;
    }

    public String getRequest() {
        return request;
    }

    public Feedback setRequest(String request) {
        this.request = request;
        return this;
    }

    public String getResponse() {
        return response;
    }

    public Feedback setResponse(String response) {
        this.response = response;
        return this;
    }
@OneToOne
    public Order getOrder() {
        return order;
    }

    public Feedback setOrder(Order order) {
        this.order = order;
        return this;
    }
}
