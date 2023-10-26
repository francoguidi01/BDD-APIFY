package com.apify.crud_users.models;

import jakarta.persistence.*;

@Entity
@Table (name = "songs")
public class SongModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

//id_song_users INT AUTO_INCREMENT PRIMARY KEY,
//    id_song VARCHAR(100) NOT NULL,
//    id_user INT NOT NULL,
//    FOREIGN KEY (id_user) REFERENCES users (id)