package casino.manager.attendent.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "attendants")
public class Attendant extends BaseEntity {


    @Column(name = "time")
    private LocalDateTime time = LocalDateTime.now();

    @Column(name = "credit")
    private Integer credit;


    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


    @ManyToOne
    @JoinColumn(name = "ia_id")
    private GamblingMachine gamblingMachine;

}
