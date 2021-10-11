package com.exam.examandery01.model.entity;


import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    private CategoryName categoryName;
    private String description;

    public Category() {
    }

    @Enumerated(EnumType.STRING)
    public CategoryName getCategoryName() {
        return categoryName;
    }

    public Category setCategoryName(CategoryName categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }
}
