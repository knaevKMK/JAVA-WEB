package spring_fundametals.mobilele.model.entites;


import spring_fundametals.mobilele.model.entites.enums.CategoryEnum;

import javax.persistence.*;

@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntity {

    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    @Column(length = 512)
    private String imageUrl;

    private int startYear;
    @Column(nullable = true)
    private Integer ednYear;

    @ManyToOne
    private BrandEntity brand;

    public String getName() {
        return name;
    }

    public ModelEntity setName(String name) {
        this.name = name;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public ModelEntity setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ModelEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getStartYear() {
        return startYear;
    }

    public ModelEntity setStartYear(int startYear) {
        this.startYear = startYear;
        return this;
    }

    public Integer getEdnYear() {
        return ednYear;
    }

    public ModelEntity setEdnYear(Integer ednYear) {
        this.ednYear = ednYear;
        return this;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public ModelEntity setBrand(BrandEntity brand) {
        this.brand = brand;
        return this;
    }
}
