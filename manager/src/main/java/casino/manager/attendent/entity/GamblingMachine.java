package casino.manager.attendent.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="gambling_machines")
public class GamblingMachine extends BaseEntity{

    private Integer numPlace;
    private String number;
    private String version;


    @OneToMany(mappedBy = "gamblingMachine", targetEntity = Accountant.class)
    private List<Accountant> accountant;
}
