package com.project.shop.model.entity;

import com.project.shop.model.enums.ConditionEnum;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "conditions")
public class ConditionItem extends Item {
    private ConditionEnum conditionTitle;


    private List<Listing> listings;

    public ConditionItem() {
    }

    @OneToMany(mappedBy = "condition", targetEntity = Listing.class, orphanRemoval = true, cascade = CascadeType.ALL)
    @NotFound(action = NotFoundAction.IGNORE)
    public List<Listing> getListings() {
        return listings;
    }

    public ConditionItem setListings(List<Listing> listings) {
        this.listings = listings;
        return this;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    public ConditionEnum getConditionTitle() {
        return conditionTitle;
    }

    public ConditionItem setConditionTitle(ConditionEnum conditionTitle) {
        this.conditionTitle = conditionTitle;
        return this;
    }

}
