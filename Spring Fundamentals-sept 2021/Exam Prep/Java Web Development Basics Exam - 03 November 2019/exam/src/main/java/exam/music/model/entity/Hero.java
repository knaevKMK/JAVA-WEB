package exam.music.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "heros")
public class Hero extends BaseEntity {
    private String name;
    private ClassEnum classEnum;
    private int level;
    private String imageUrl;

    public Hero() {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Column(nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(EnumType.STRING)
    public ClassEnum getClassEnum() {
        return classEnum;
    }

    public void setClassEnum(ClassEnum classEnum) {
        this.classEnum = classEnum;
    }

    @Positive
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
