package exam.music.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryEntity {

    private int id;
    private String name;

    public CategoryEntity() {
    }

    public CategoryEntity( String categoryEnum) {
        this.name = categoryEnum;
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
    public String getName() {
        return name;
    }

    public void setName(String categoryEnum) {
        this.name = categoryEnum;
    }
}
