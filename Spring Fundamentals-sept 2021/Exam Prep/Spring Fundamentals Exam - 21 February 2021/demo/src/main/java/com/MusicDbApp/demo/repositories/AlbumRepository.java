package com.MusicDbApp.demo.repositories;

import com.MusicDbApp.demo.models.entities.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album,String> {
}
