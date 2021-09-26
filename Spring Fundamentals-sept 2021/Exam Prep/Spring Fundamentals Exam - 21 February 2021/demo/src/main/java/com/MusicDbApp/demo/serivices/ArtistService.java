package com.MusicDbApp.demo.serivices;

import com.MusicDbApp.demo.repositories.ArtistRepository;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {
    private ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }
}
