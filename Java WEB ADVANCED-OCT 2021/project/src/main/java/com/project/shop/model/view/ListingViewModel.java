package com.project.shop.model.view;

import java.time.LocalDateTime;
import java.util.UUID;

public class ListingViewModel {
    private UUID id;
    private String title;
    private String description;
    private String imageUrl;
    private LocalDateTime createOn;
    private LocalDateTime endOn;
    private CategoryViewModel category;
    private ConditionViewModel condition;

    private SellingVewModel sellingFormat;
    private DeliveryInListingVewModel deliveryDomestic;
    private DeliveryInListingVewModel deliveryInternational;
    private boolean isWatched;
    private String payment;
    private boolean isOwner;
    private String createFrom;
    private boolean isActive;
    private int watchCount;
    private int orderedCount;

    public ListingViewModel() {
    }

    public int getOrderedCount() {
        return orderedCount;
    }

    public ListingViewModel setOrderedCount(int orderedCount) {
        this.orderedCount = orderedCount;
        return this;
    }

    public LocalDateTime getEndOn() {
        return endOn;
    }

    public ListingViewModel setEndOn(LocalDateTime endOn) {
        this.endOn = endOn;
        return this;
    }

    public boolean isWatched() {
        return isWatched;
    }

    public ListingViewModel setWatched(boolean watched) {
        isWatched = watched;
        return this;
    }

    public int getWatchCount() {
        return watchCount;
    }

    public ListingViewModel setWatchCount(int watchCount) {
        this.watchCount = watchCount;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public ListingViewModel setActive(boolean active) {
        isActive = active;
        return this;
    }

    public String getCreateFrom() {
        return createFrom;
    }

    public ListingViewModel setCreateFrom(String createFrom) {
        this.createFrom = createFrom;
        return this;
    }

    public boolean isOwner() {
        return isOwner;
    }

    public void setOwner(boolean owner) {
        isOwner = owner;
    }

    public LocalDateTime getCreateOn() {
        return createOn;
    }

    public ListingViewModel setCreateOn(LocalDateTime createOn) {
        this.createOn = createOn;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public ListingViewModel setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ListingViewModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ListingViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ListingViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public CategoryViewModel getCategory() {
        return category;
    }

    public ListingViewModel setCategory(CategoryViewModel category) {
        this.category = category;
        return this;
    }

    public ConditionViewModel getCondition() {
        return condition;
    }

    public ListingViewModel setCondition(ConditionViewModel condition) {
        this.condition = condition;
        return this;
    }

    public SellingVewModel getSellingFormat() {
        return sellingFormat;
    }

    public ListingViewModel setSellingFormat(SellingVewModel sellingFormat) {
        this.sellingFormat = sellingFormat;
        return this;
    }

    public DeliveryInListingVewModel getDeliveryDomestic() {
        return deliveryDomestic;
    }

    public ListingViewModel setDeliveryDomestic(DeliveryInListingVewModel deliveryDomestic) {
        this.deliveryDomestic = deliveryDomestic;
        return this;
    }

    public String getPayment() {
        return payment;
    }

    public ListingViewModel setPayment(String payment) {
        this.payment = payment;
        return this;
    }

    public DeliveryInListingVewModel getDeliveryInternational() {
        return deliveryInternational;
    }

    public ListingViewModel setDeliveryInternational(DeliveryInListingVewModel deliveryInternational) {
        this.deliveryInternational = deliveryInternational;
        return this;
    }
}
