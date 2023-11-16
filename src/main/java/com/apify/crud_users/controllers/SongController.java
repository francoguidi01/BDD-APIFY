package com.apify.crud_users.controllers;

import com.apify.crud_users.DTOS.SongDTO;
import com.apify.crud_users.models.Song;
import com.apify.crud_users.models.User;
import com.apify.crud_users.repositories.UserRepository;
import com.apify.crud_users.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SongService songService;

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/get-all-songs")
    public ArrayList<Song> getSongs() {
        return this.songService.getSongs();
    }


    @CrossOrigin(origins = "*")
    @GetMapping(path = "/get-songs-by-user/{id}")
    public ArrayList<Song> getSongsByUser(@PathVariable("id") String id) {
        return songService.getSongsByUserId(id);
    }


    @CrossOrigin(origins = "*")
    @GetMapping(path = "/get-dto-songs-by-id/{id}")
    public List<SongDTO> getSongsByUserId2(@PathVariable("id") String id){
        return songService.getSongsByUserId2(id);
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add-song")
    public ResponseEntity<Song> setSong(@RequestBody Song song) {
        Optional<User> userModelOptional = userRepository.findById(song.getUser().getId());
        if(!userModelOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        song.setUser(userModelOptional.get());
        return ResponseEntity.ok(this.songService.saveSong(song));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "/delete-song/{id}")
    public ResponseEntity<String> deleteSong(@PathVariable("id") Integer id) {
        if (songService.deleteSong(id)) {
            return ResponseEntity.ok("Song deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
