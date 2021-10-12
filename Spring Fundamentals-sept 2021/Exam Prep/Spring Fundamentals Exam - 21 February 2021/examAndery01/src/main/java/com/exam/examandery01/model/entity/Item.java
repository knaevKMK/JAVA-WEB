package com.exam.examandery01.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
@Table(name = "items")
public class Item extends BaseEntity {


    private String name;
    private String description;
    private BigDecimal price;
    private GenderName gender;
    private Category category;
    private  String imageUrl;

    public Item() {
    }
@Column(nullable = false)
    public String getImageUrl() {
        return imageUrl;
    }

    public Item setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }
@Column(nullable = false)
    public String getDescription() {
        return description;
    }

    public Item setDescription(String description) {
        this.description = description;
        return this;
    }
@Positive
    public BigDecimal getPrice() {
        return price;
    }

    public Item setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
@Enumerated
    public GenderName getGender() {
        return gender;
    }

    public Item setGender(GenderName gender) {
        this.gender = gender;
        return this;
    }

    @ManyToOne
    public Category getCategory() {
        return category;
    }

    public Item setCategory(Category category) {
        this.category = category;
        return this;
    }
}
