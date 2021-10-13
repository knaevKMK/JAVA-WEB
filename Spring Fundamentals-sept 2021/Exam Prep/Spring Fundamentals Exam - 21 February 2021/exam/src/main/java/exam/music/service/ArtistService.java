package exam.music.service;

import exam.music.model.entity.Artist;

public interface ArtistService {

    void seedData();

    Artist findByName(String artist);
}
