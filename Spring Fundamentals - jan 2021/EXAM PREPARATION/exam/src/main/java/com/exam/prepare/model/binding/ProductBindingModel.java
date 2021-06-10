package com.exam.prepare.model.binding;

import com.exam.prepare.model.entities.CategoryEntity;
import com.exam.prepare.model.entities.enums.CategoryNameEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductBindingModel {
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDateTime neededBefore;
    private CategoryNameEnum category;

    public ProductBindingModel() {
    }

    @NotBlank(message = "Name can not be empty")
    @Size(min = 3, max = 20, message = "Name length must be between 3 and 20 characters ")
    public String getName() {
        return name;
    }

    public ProductBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @NotBlank(message = "Description can not be empty")
    @Size(min = 5, message = "Description min length must be minimum 5(inclusive)")
    public String getDescription() {
        return description;
    }

    public ProductBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

//    @NotNull(message = "Price must be a positive number")
//    @NotEmpty(message = "Price must be a positive number")
    @DecimalMin(value = "0", message = "Price must be a positive number")
    public BigDecimal getPrice() {
        return price;
    }

    public ProductBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @NotNull(message = "Please select date")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent(message = "The date can not be in the past")
    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public ProductBindingModel setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
        return this;
    }

    @NotNull(message = "Category cannot be null")
    public CategoryNameEnum getCategory() {
        return category;
    }

    public ProductBindingModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }

    @Override
    public String toString() {
        return "ProductBindingModel{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", neededBefore=" + neededBefore +
                ", category=" + category +
                '}';
    }
}
