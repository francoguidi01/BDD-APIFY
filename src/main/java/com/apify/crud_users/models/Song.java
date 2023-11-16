package com.apify.crud_users.models;

import jakarta.persistence.*;

@Entity
@Table (name = "songs")
public class Song {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id_song;
    @Column (name= "id_api_song")
    private String id_api_song;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private User user;

    public Integer getId_song() {
        return id_song;
    }

    public void setId_song(Integer id_song) {
        this.id_song = id_song;
    }

    public String getId_api_song() {
        return id_api_song;
    }

    public void setId_api_song(String id_api_song) {
        this.id_api_song = id_api_song;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}