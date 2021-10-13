package exam.music.repository;

import exam.music.model.entity.Artist;
import exam.music.model.entity.SingerEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist,String> {

    Optional<Artist> findBySinger(SingerEnum singer);
}
