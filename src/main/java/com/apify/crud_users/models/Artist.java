package com.apify.crud_users.models;
import jakarta.persistence.*;

@Entity
@Table (name= "artists")
public class Artist {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id_artist;

    @Column(name= "id_api_artist")
    private String id_api_artist;

    @Column(name= "artist_name")
    private String artist_name;

    @Column(name= "artist_url_photo")
    private String artist_url_photo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private User user;

    public String getArtist_url_photo() {
        return artist_url_photo;
    }

    public void setArtist_url_photo(String artist_url_photo) {
        this.artist_url_photo = artist_url_photo;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public Integer getId_artist() {
        return id_artist;
    }

    public void setId_artist(Integer id_artist) {
        this.id_artist = id_artist;
    }

    public String getId_api_artist() {
        return id_api_artist;
    }

    public void setId_api_artist(String id_api_artist) {
        this.id_api_artist = id_api_artist;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
