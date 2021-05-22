package softuni.judge_v2.model.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="homework")
@NoArgsConstructor
@Getter
@Setter
public class HomeworkEntity extends BaseEntity{

    @Column(name="added_on")
    private LocalDateTime addedOn;
    @Column(name = "git_address", nullable = false)
    private String gitAddress;
    @ManyToOne
    private UserEntity author;

    @ManyToOne
    private ExerciseEntity exercise;

}
