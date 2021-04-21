package casino.manager.attendent.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clients")
public class Client {

    @Id
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private UUID id= UUID.randomUUID();

    @Column(name = "first_name", columnDefinition ="varchar(25)")
    private String fistName;

    @Column(name = "last_name", columnDefinition ="varchar(25)")
    private String lastName;

    @Column(name = "middle_name", columnDefinition ="varchar(25)")
    private String middleName;

     @Column(name = "egn", length = 10, unique = true)
    private String egn;

    @Column(name = "id_card_number", length = 10, unique = true)
    private String idCardNumber;


    @Column(name= "total_balance", columnDefinition = "INT")
    private Integer totalBalance;

    @Column(name= "total_bonus", columnDefinition = "INT")
    private Integer totalBonus;
}
