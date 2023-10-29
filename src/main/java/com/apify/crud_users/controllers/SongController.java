package com.apify.crud_users.controllers;

import com.apify.crud_users.models.SongModel;
import com.apify.crud_users.models.User;
import com.apify.crud_users.repositories.IUserRepository;
import com.apify.crud_users.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private IUserRepository iUserRepository;
    @Autowired
    private SongService songService;

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/get-all-songs")
    public ArrayList<SongModel> getSongs() {
        return this.songService.getSongs();
    }


    @CrossOrigin(origins = "*")
    @GetMapping(path = "/get-songs-by-user/{id}")
    public ArrayList<SongModel> getSongsByUser(@PathVariable("id") String id) {
        return songService.getSongsByUserId(id);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add-song")
    public ResponseEntity<SongModel> setSong(@RequestBody SongModel song) {
        Optional<User> userModelOptional = iUserRepository.findById(song.getUser().getId());
        if(!userModelOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        song.setUser(userModelOptional.get());
        return ResponseEntity.ok(this.songService.saveSong(song));
        //return this.songService.saveSong(song);
    }


}
