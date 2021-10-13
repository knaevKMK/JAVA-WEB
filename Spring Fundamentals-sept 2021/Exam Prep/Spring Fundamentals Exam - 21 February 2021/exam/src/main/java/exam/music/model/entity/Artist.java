package exam.music.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "artists")
public class Artist extends BaseEntity{
    private SingerEnum singer;
    private String carrerInformation;

    public Artist() {
    }
@Enumerated(EnumType.STRING)
    public SingerEnum getSinger() {
        return singer;
    }

    public Artist setSinger(SingerEnum singer) {
        this.singer = singer;
        return this;
    }
@Column(columnDefinition = "TEXT")
    public String getCarrerInformation() {
        return carrerInformation;
    }

    public Artist setCarrerInformation(String carrerInformation) {
        this.carrerInformation = carrerInformation;
        return this;
    }
}
