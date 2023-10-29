package com.apify.crud_users.models;
import jakarta.persistence.*;

@Entity
@Table (name= "artists")
public class Artist {
    @Id
    private Integer id_artist;

    @Column
    private String id_api_artist;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "id_user")
    private User user;

    public Integer getId_artist() {
        return id_artist;
    }

    public void setId_artist(Integer id_artist) {
        this.id_artist = id_artist;
    }

    public String getId_api_artists() {
        return id_api_artist;
    }

    public void setId_api_artists(String id_api_artists) {
        this.id_api_artist = id_api_artists;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
