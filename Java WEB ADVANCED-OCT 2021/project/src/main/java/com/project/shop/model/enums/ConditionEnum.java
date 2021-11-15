package com.project.shop.model.enums;

public enum ConditionEnum {
    NEW("New"),
    NEW_OTHER("New Other"),
    USED("Used"),
    REFURBISHED("Refurbished"),
    DEFECT("Defect"),
    FOR_PARTS("For Parts");
    private String title;

    ConditionEnum(String name) {
        this.title = name;
    }

    public String getTitle() {
        return title;
    }
}
