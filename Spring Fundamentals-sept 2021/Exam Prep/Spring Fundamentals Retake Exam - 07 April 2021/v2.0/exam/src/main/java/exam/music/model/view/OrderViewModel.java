package exam.music.model.view;

import exam.music.model.entity.CategoryNameEnum;

import java.math.BigDecimal;

public class OrderViewModel {
    private String id;
    private String name;
    private BigDecimal price;
    private CategoryViewModel category;
    private UserViewModel userViewModel;
    private String imageUrl;

    public OrderViewModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public CategoryViewModel getCategory() {
        return category;
    }

    public void setCategory(CategoryViewModel category) {
        this.category = category;
    }

    public UserViewModel getUserViewModel() {
        return userViewModel;
    }

    public void setUserViewModel(UserViewModel userViewModel) {
        this.userViewModel = userViewModel;
    }
}
