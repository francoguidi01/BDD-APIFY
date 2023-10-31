package com.apify.crud_users.services;

import com.apify.crud_users.DTOS.LeaderboardDTO;
import com.apify.crud_users.models.Artist;
import com.apify.crud_users.models.Leaderboard;
import com.apify.crud_users.repositories.LeaderboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeaderboardService {
    @Autowired
    private LeaderboardRepository leaderboardRepository;

    public List<Leaderboard> getLeaderboardOrderedByPointsDesc() {
        return leaderboardRepository.findAllOrderByPointsDesc();
    }
    public ArrayList<Leaderboard> getLeaderboard() {
        return (ArrayList<Leaderboard>) leaderboardRepository.findAll();
    }
    public Leaderboard savePoints(Leaderboard leaderboard) {
        return leaderboardRepository.save(leaderboard);
    }

    public List<LeaderboardDTO> findLeaderboardOrderByPointsDesc() {
        return leaderboardRepository.findLeaderboardOrderByPointsDesc();
    }




}
