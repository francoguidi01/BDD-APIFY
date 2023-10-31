package com.apify.crud_users.repositories;

import com.apify.crud_users.DTOS.LeaderboardDTO;
import com.apify.crud_users.models.Leaderboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LeaderboardRepository extends JpaRepository<Leaderboard, Integer> {

    @Query("SELECT l FROM Leaderboard l ORDER BY l.points DESC")
    List<Leaderboard> findAllOrderByPointsDesc();

    @Query("SELECT new com.apify.crud_users.DTOS.LeaderboardDTO(u.display_name, u.url_photo, l.points) FROM Leaderboard l JOIN l.user u ORDER BY l.points DESC")
    List<LeaderboardDTO> findLeaderboardOrderByPointsDesc();



}
