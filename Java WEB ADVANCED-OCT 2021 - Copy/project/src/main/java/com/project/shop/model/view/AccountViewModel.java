package com.project.shop.model.view;

import com.project.shop.model.entity.Feedback;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AccountViewModel {
    private String username;
    private int listingsCount ;
    private List<Feedback> feedbacks=new ArrayList<>();
    private boolean isOwner;
    private LocalDateTime createOn;
    private int stars;

    public AccountViewModel() {
    }

    public int getStars() {
        return stars;
    }

    public AccountViewModel setStars(int stars) {
        this.stars = stars;
        return this;
    }

    public LocalDateTime getCreateOn() {
        return createOn;
    }

    public AccountViewModel setCreateOn(LocalDateTime createOn) {
        this.createOn = createOn;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public AccountViewModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public int getListingsCount() {
        return listingsCount;
    }

    public AccountViewModel setListingsCount(int listingsCount) {
        this.listingsCount = listingsCount;
        return this;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public AccountViewModel setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
        return this;
    }

    public boolean isOwner() {
        return isOwner;
    }

    public AccountViewModel setOwner(boolean owner) {
        isOwner = owner;
        return this;
    }
}
