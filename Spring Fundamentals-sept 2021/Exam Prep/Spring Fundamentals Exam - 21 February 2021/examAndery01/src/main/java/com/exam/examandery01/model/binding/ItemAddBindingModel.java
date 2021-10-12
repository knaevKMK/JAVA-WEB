package com.exam.examandery01.model.binding;

import com.exam.examandery01.model.entity.CategoryName;
import com.exam.examandery01.model.entity.GenderName;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class ItemAddBindingModel {
    private String name;
    private String description;
    private CategoryName category;
    private GenderName gender;
    private BigDecimal price;

    public ItemAddBindingModel() {
    }
@NotNull(message = "Username is required")
@Length(min = 2, message = "Username min length is 2 characters")
    public String getName() {
        return name;
    }

    public ItemAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }
    @NotNull(message = "Description is required")
    @Length(min = 3, message = "Description min length is 2 characters")
    public String getDescription() {
        return description;
    }

    public ItemAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
@NotNull(message = "Enter valid category value")
    public CategoryName getCategory() {
        return category;
    }

    public ItemAddBindingModel setCategory(CategoryName category) {
        this.category = category;
        return this;
    }
@NotNull(message = "Enter valid Gender value")
    public GenderName getGender() {
        return gender;
    }

    public ItemAddBindingModel setGender(GenderName gender) {
        this.gender = gender;
        return this;
    }
@Positive
    public BigDecimal getPrice() {
        return price;
    }

    public ItemAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}