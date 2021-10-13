package exam.music.model.entity;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "albums")
public class Album extends BaseEntity {

    private String name;
    private String imageUrl;
    private String description;
    private int copies;
    private BigDecimal price;
    private LocalDate releasedDate;
    private String Producer;
    private GenreEnum genre;
    private Artist artist;
    private User addFrom;

    public Album() {
    }
    @Length(min = 3, max = 20)
    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public Album setName(String name) {
        this.name = name;
        return this;
    }
@Length(min = 5)
@Column(nullable = false)
    public String getImageUrl() {
        return imageUrl;
    }

    public Album setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
@Column(columnDefinition = "TEXT", nullable = false)
@Length(min = 5)
    public String getDescription() {
        return description;
    }

    public Album setDescription(String description) {
        this.description = description;
        return this;
    }
@Min(10)
    public int getCopies() {
        return copies;
    }

    public Album setCopies(int copies) {
        this.copies = copies;
        return this;
    }
@Positive
    public BigDecimal getPrice() {
        return price;
    }

    public Album setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
//date cannot be in the future
    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public Album setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
        return this;
    }
@Column(nullable = false)
    public String getProducer() {
        return Producer;
    }

    public Album setProducer(String producer) {
        Producer = producer;
        return this;
    }
@Enumerated(EnumType.STRING)
    public GenreEnum getGenre() {
        return genre;
    }

    public Album setGenre(GenreEnum genre) {
        this.genre = genre;
        return this;
    }
@ManyToOne
    public Artist getArtist() {
        return artist;
    }

    public Album setArtist(Artist artist) {
        this.artist = artist;
        return this;
    }
@ManyToOne
    public User getAddFrom() {
        return addFrom;
    }

    public Album setAddFrom(User addFrom) {
        this.addFrom = addFrom;
        return this;
    }
}
