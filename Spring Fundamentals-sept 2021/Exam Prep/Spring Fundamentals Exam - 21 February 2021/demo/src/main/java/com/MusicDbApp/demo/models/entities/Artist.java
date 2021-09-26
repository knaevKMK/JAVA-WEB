package com.MusicDbApp.demo.models.entities;

import com.MusicDbApp.demo.models.entities.enums.SingerName;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "artists")
public class Artist extends BaseEntity {
    private String careerInformation;
    private SingerName name;
  //  private Collection<Album> albums;

    public Artist() {
    }
//@OneToMany
//    public Collection<Album> getAlbums() {
//        return albums;
//    }
//
//    public void setAlbums(Collection<Album> albums) {
//        this.albums = albums;
//    }

    @Column(name = "career_information", columnDefinition = "TEXT")
    public String getCareerInformation() {
        return careerInformation;
    }

    public void setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
    }
@Enumerated(EnumType.STRING)
    public SingerName getName() {
        return name;
    }

    public void setName(SingerName name) {
        this.name = name;
    }
}

