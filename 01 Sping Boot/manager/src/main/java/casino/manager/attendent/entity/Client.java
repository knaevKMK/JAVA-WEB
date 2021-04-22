package casino.manager.attendent.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clients")
public class Client extends BaseEntity{




    @Column(name = "first_name", columnDefinition ="varchar(25)")
    private String fistName;

    @Column(name = "last_name", columnDefinition ="varchar(25)")
    private String lastName;

    @Column(name = "middle_name", columnDefinition ="varchar(25)")
    private String middleName;

     @Column(name = "egn", length = 10, unique = true)
    private String egn;

    @Column(name = "idcard_number", length = 10, unique = true)
    private String idCardNumber;

    @OneToMany(mappedBy = "client", targetEntity = Attendant.class)
    private List<Attendant> attendants;
}
