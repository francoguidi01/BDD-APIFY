package com.apify.crud_users.models;

import jakarta.persistence.*;

@Entity
@Table (name = "songs")
public class SongModel {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id_song;
    @Column
    private String id_api_song;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "id_user")
    private UserModel user;


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

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}