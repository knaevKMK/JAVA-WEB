package exam.music.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    private CategoryNameEnum name;
    private Integer neededTime;

    public Category() {
    }

    public Category(CategoryNameEnum name, Integer neededTime) {
        this.name = name;
        this.neededTime = neededTime;
    }

    @Enumerated(EnumType.STRING)
    public CategoryNameEnum getName() {
        return name;
    }

    public void setName(CategoryNameEnum name) {
        this.name = name;
    }

    @Column(nullable = false)
    @Positive
    public Integer getNeededTime() {
        return neededTime;
    }

    public void setNeededTime(Integer neededTime) {
        this.neededTime = neededTime;
    }
}
