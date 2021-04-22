package casino.manager.attendent.entity;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private UUID id= UUID.randomUUID();

    public  UUID getId(){
        return this.id;
    }
}
