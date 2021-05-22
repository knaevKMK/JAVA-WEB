package softuni.judge_v2.model.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "exercises")
@NoArgsConstructor
@Getter
@Setter
public class ExerciseEntity extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "started_on")
    private LocalDateTime startedOn;
    @Column(name = "due_date")
    private LocalDateTime dueDate;

}
