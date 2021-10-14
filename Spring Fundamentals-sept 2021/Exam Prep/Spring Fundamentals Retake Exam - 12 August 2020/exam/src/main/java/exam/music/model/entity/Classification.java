package exam.music.model.entity;


import javax.persistence.*;

@Entity
@Table(name = "classifications")
public class Classification  extends  BaseEntity{

    private ClassificationEnum classificationName;
    private String description;

    public Classification() {
    }

    public Classification(ClassificationEnum classificationName, String description) {
        this.classificationName = classificationName;
        this.description = description;
    }

    @Column(nullable = false, unique = true)
@Enumerated(EnumType.STRING)
    public ClassificationEnum getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(ClassificationEnum classificationName) {
        this.classificationName = classificationName;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
