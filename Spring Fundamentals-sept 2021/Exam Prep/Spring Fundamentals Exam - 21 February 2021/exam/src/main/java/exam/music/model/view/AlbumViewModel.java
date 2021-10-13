package exam.music.model.view;

import exam.music.model.entity.Artist;
import exam.music.model.entity.GenreEnum;
import exam.music.model.entity.User;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumViewModel {
private String id;
    private String imageUrl;
    private String name;
    private String artist;
    private GenreEnum genre;
    private BigDecimal price;
    private String releasedDate;
    private int copies;

    public AlbumViewModel() {
    }

    public String getId() {
        return id;
    }

    public AlbumViewModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AlbumViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getName() {
        return name;
    }

    public AlbumViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getArtist() {
        return artist;
    }

    public AlbumViewModel setArtist(String artist) {
        this.artist = artist;
        return this;
    }

    public GenreEnum getGenre() {
        return genre;
    }

    public AlbumViewModel setGenre(GenreEnum genre) {
        this.genre = genre;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AlbumViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getReleasedDate() {
        return releasedDate;
    }

    public AlbumViewModel setReleasedDate(String releasedDate) {
        this.releasedDate = releasedDate;
        return this;
    }

    public int getCopies() {
        return copies;
    }

    public AlbumViewModel setCopies(int copies) {
        this.copies = copies;
        return this;
    }
}
