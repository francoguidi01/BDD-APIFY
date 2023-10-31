package com.apify.crud_users.models;

import jakarta.persistence.*;

@Entity
@Table(name = "leaderboard")
public class Leaderboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_leaderboard;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "id_user")
    private User user;
    @Column
    private Integer points;

    public Integer getId_leaderboard() {
        return id_leaderboard;
    }

    public void setId_leaderboard(Integer id_leaderboard) {
        this.id_leaderboard = id_leaderboard;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
