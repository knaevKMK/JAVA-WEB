package exam.music.model.view;

import exam.music.model.entity.CategoryNameEnum;

public class CategoryViewModel {

    private CategoryNameEnum name;
    private int neededTime;

    public CategoryViewModel() {


    }

    public CategoryNameEnum getName() {
        return name;
    }

    public void setName(CategoryNameEnum name) {
        this.name = name;
    }

    public int getNeededTime() {
        return neededTime;
    }

    public void setNeededTime(int neededTime) {
        this.neededTime = neededTime;
    }
}
