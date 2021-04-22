package casino.manager.attendent.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accountants")
public class Accountant extends BaseEntity {

    @ManyToOne
    @JoinTable(name = "ia_accountant",
            joinColumns = @JoinColumn(name = "ia_id"),
            inverseJoinColumns = @JoinColumn(name = "accountant_id"))
    private GamblingMachine gamblingMachine;

    private LocalDateTime time = LocalDateTime.now();
    private Long creditIn;
    private Long creditOut;
    private Long bet;
    private Long win;
    private Long mechanicalIn;
    private Long mechanicalOut;

}
