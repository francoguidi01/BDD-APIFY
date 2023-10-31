package com.apify.crud_users.controllers;

import com.apify.crud_users.DTOS.LeaderboardDTO;
import com.apify.crud_users.models.Leaderboard;
import com.apify.crud_users.models.User;
import com.apify.crud_users.repositories.UserRepository;
import com.apify.crud_users.services.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/leaderboard")
public class LeaderboardController {
    @Autowired
    private LeaderboardService leaderboardService;
    @Autowired
    private UserRepository userRepository;
    @CrossOrigin(origins = "*")
    @GetMapping("/get-leaderboard")
    public List<LeaderboardDTO>findLeaderboardOrderByPointsDesc(){
        return leaderboardService.findLeaderboardOrderByPointsDesc();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add-leaderboard")
    public ResponseEntity<Leaderboard> setLeaderboard(@RequestBody Leaderboard leaderboard)
    {
        Optional<User> userModelOptional = userRepository.findById(leaderboard.getUser().getId());
        if(!userModelOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        leaderboard.setUser(userModelOptional.get());
        return ResponseEntity.ok(this.leaderboardService.savePoints(leaderboard));
    }
}
