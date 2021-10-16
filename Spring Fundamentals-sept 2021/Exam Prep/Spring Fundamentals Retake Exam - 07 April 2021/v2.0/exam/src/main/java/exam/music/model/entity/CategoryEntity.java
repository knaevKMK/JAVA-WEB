package exam.music.model.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {
    private CategoryNameEnum name;
    private int neededTime;

    public CategoryEntity() {
    }

    public CategoryEntity(CategoryNameEnum name, int neededTime) {
        this.name = name;
        this.neededTime = neededTime;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    public CategoryNameEnum getName() {
        return name;
    }

    public void setName(CategoryNameEnum name) {
        this.name = name;
    }

    @Positive
    @NotNull
    public int getNeededTime() {
        return neededTime;
    }

    public void setNeededTime(int neededTime) {
        this.neededTime = neededTime;
    }
}
