package com.apify.crud_users.controllers;

import com.apify.crud_users.models.SongModel;
import com.apify.crud_users.models.UserModel;
import com.apify.crud_users.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private SongService songService;

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/get-all-songs")
    public ArrayList<SongModel> getSongs() {
        return this.songService.getSongs();
    }


    @CrossOrigin(origins = "*")
    @GetMapping(path = "/get-songs-by-user/{id}")
    public ArrayList<SongModel> getSongsByUser(@PathVariable("id") Integer id) {
        return songService.getSongsByUserId(id);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add-song")
    public SongModel setSong(@RequestBody SongModel song) {
        return this.songService.saveSong(song);
    }


}
