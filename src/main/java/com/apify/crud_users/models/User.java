package com.apify.crud_users.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
    //@GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    private String id;
    @Column
    private String display_name;
    @Column
    private String url_photo;
    @OneToMany(mappedBy ="user", cascade = CascadeType.ALL)
    private List<Song> songs;

    @OneToMany(mappedBy ="user", cascade = CascadeType.ALL)
    private List<Artist> artist;

    @OneToMany(mappedBy ="user", cascade = CascadeType.ALL)
    private List<Leaderboard> leaderboards;

    @OneToMany(mappedBy = "user1", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Friend> friendRequestsSent;

    @OneToMany(mappedBy = "user2", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Friend> friendRequestsReceived;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getUrl_photo() {
        return url_photo;
    }

    public void setUrl_photo(String url_photo) {
        this.url_photo = url_photo;
    }
}
