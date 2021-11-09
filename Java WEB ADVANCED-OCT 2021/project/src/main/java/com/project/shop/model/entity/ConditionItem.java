package com.project.shop.model.entity;

import com.project.shop.model.enums.ConditionEnum;

import javax.persistence.*;

@Entity
@Table(name = "conditions")
public class ConditionItem extends BaseEntity{
    private ConditionEnum  conditionTitle;
    private String conditionDescription;

    public ConditionItem() {
    }
    @Enumerated(EnumType.STRING)
@Column( nullable = false, unique = true)
    public ConditionEnum getConditionTitle() {
        return conditionTitle;
    }

    public ConditionItem setConditionTitle(ConditionEnum conditionTitle) {
        this.conditionTitle = conditionTitle;
        return this;
    }
@Column(columnDefinition = "TEXT")
    public String getConditionDescription() {
        return conditionDescription;
    }

    public ConditionItem setConditionDescription(String conditionDescription) {
        this.conditionDescription = conditionDescription;
        return this;
    }
}
