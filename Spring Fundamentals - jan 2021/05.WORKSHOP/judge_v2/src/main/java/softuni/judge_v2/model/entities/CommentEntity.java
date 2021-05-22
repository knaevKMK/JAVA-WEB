package softuni.judge_v2.model.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "comments")
@NoArgsConstructor
@Getter
@Setter
public class CommentEntity extends BaseEntity {

    @Column(name = "score")
    private Integer score;
    @Column(name = "text_content", columnDefinition = "TEXT")
    private String textContent;

    @ManyToOne
    private UserEntity author;
    @ManyToOne
    private HomeworkEntity homework;
}
