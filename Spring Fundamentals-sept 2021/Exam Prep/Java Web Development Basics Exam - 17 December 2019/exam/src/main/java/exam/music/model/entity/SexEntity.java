package exam.music.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "gender")
public class SexEntity {
    private int id;
    private String gender;

    public SexEntity() {
    }

    public SexEntity(String gender) {
        this.gender = gender;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
@Column(nullable = false)
    public String getGender() {
        return gender;
    }

    public void setGender(String sexEnum) {
        this.gender = sexEnum;
    }
}
