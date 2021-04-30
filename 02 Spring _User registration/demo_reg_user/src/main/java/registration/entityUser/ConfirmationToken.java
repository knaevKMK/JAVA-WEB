package registration.entityUser;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@Entity

public class ConfirmationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime createAt;

    @Column(nullable = false)
    private LocalDateTime expiredAt;

    private LocalDateTime confirmAt;

    @ManyToOne()
    @JoinColumn(nullable = false, name = "user_id")
    private AppUser appUser;

    public ConfirmationToken(String token,
                             LocalDateTime createAt,
                             LocalDateTime expiredAt,
                             AppUser appUser) {
        this.token = token;
        this.createAt = createAt;
        this.expiredAt = expiredAt;
        this.appUser = appUser;
    }
}
