package casino.manager.attendent.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @Column(name = "name")
    private String name;

    @Column(name = "egn", length = 10, unique = true)
    private String egn;
}
