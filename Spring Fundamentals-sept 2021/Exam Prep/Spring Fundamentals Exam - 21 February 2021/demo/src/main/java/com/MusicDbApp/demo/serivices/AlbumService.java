package com.MusicDbApp.demo.serivices;

import com.MusicDbApp.demo.repositories.AlbumRepository;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {
    private AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }
}
