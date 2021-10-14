package exam.music.model.view;

import exam.music.model.entity.CategoryNameEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductViewModel {
    private String id;
    private String name;
    private BigDecimal price;
    private String category;

    public ProductViewModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
