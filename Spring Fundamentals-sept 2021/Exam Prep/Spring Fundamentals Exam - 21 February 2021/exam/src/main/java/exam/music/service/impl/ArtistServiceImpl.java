package exam.music.service.impl;

import exam.music.model.entity.Artist;
import exam.music.model.entity.SingerEnum;
import exam.music.repository.ArtistRepository;
import exam.music.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public void seedData() {
        if (this.artistRepository.count()==0){
            Artist artist = new Artist();
            artist
                    .setSinger(SingerEnum.Madonna)
                    .setCarrerInformation("Madonna Louise Ciccone - born and raised in Michigan, Madonna moved to New York City in 1978 to pursue a career in modern dance. After performing as a drummer, guitarist, and vocalist in the rock bands Breakfast Club and Emmy, she rose to solo stardom with her debut studio album, Madonna (1983). She followed it with a series of successful albums, including all-time bestsellers Like a Virgin (1984) and True Blue (1986) as well as Grammy Award winners Ray of Light (1998) and Confessions on a Dance Floor (2005).");
            Artist artist1 = new Artist();
            artist1
                    .setSinger(SingerEnum.Metallica)
                    .setCarrerInformation("Metallica is an American heavy metal band. The band was formed in 1981 in Los Angeles by vocalist/guitarist James Hetfield and drummer Lars Ulrich, and has been based in San Francisco for most of its career. The band's fast tempos, instrumentals and aggressive musicianship made them one of the founding \"big four\" bands of thrash metal, alongside Megadeth, Anthrax and Slayer. Metallica's current lineup comprises founding members and primary songwriters Hetfield and Ulrich, longtime lead guitarist Kirk Hammett, and bassist Robert Trujillo. Guitarist Dave Mustaine and bassists Ron McGovney, Cliff Burton and Jason Newsted are former members of the band.");
            Artist artist2 = new Artist();
            artist2
                    .setSinger(SingerEnum.Queen)
                    .setCarrerInformation("Queen are a British rock band formed in London in 1970. Their classic line-up was Freddie Mercury (lead vocals, piano), Brian May (guitar, vocals), Roger Taylor (drums, vocals) and John Deacon (bass). Their earliest works were influenced by progressive rock, hard rock and heavy metal, but the band gradually ventured into more conventional and radio-friendly works by incorporating further styles, such as arena rock and pop rock.");

            this.artistRepository.saveAllAndFlush(List.of(artist, artist1,artist2));
        }
    }

    @Override
    public Artist findByName(String artist) {
        return this.artistRepository.findBySinger(SingerEnum.valueOf(artist)).orElse(null);
    }
}
