package exam.music.model.binding;

import exam.music.model.entity.Category;
import exam.music.model.entity.CategoryNameEnum;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderAddBindingModel {

    private String name;
    private BigDecimal price;
    private LocalDateTime orderTime;
    private CategoryNameEnum category;
    private String description;

    public OrderAddBindingModel() {
    }

    @NotNull
    @Length(min = 3, max = 20, message = "Name must be between 3 and 20 symbols")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
 //   @PastOrPresent(message = "Order Time can not be in the future")
    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    public CategoryNameEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryNameEnum category) {
        this.category = category;
    }

    @NotNull
    @Length(min = 5, message = "Description  should be longer than 5 symbols")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
