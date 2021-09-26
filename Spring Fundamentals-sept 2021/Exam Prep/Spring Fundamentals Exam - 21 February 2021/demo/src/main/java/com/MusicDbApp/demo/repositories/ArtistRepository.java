package com.MusicDbApp.demo.repositories;

import com.MusicDbApp.demo.models.entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist,String> {
}
