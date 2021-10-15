package exam.music.model.binding;

import exam.music.model.entity.ClassEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class HeroAddBindingModel {
    private String name;
    private ClassEnum classEnum;
    private int level;

    public HeroAddBindingModel() {
    }

    @NotNull(message = "Name required")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = "Class required")
    public ClassEnum getClassEnum() {
        return classEnum;
    }

    public void setClassEnum(ClassEnum classEnum) {
        this.classEnum = classEnum;
    }

    @Positive(message = "Level must be Positive")
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
