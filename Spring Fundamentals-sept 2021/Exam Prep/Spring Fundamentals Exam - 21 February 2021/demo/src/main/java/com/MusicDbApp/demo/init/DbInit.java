package com.MusicDbApp.demo.init;

import com.MusicDbApp.demo.serivices.ArtistService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbInit implements CommandLineRunner {
    private final ArtistService artistService;

    public DbInit(ArtistService artistService) {
        this.artistService = artistService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.artistService.seedArtist();
    }
}
