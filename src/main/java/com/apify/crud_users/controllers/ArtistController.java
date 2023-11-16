package com.apify.crud_users.controllers;

import com.apify.crud_users.DTOS.ArtistDTO;
import com.apify.crud_users.DTOS.SongDTO;
import com.apify.crud_users.models.Artist;

import com.apify.crud_users.models.User;

import com.apify.crud_users.repositories.UserRepository;
import com.apify.crud_users.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ArtistService artistService;

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/get-all-artists")
    public ArrayList<Artist> getArtists() {
        return this.artistService.getArtists();
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/get-artists-by-user/{id}")
    public ArrayList<Artist> getArtistsByUser(@PathVariable("id") String id) {
        return artistService.getArtistByUserId(id);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/get-dto-artist-by-id/{id}")
    public List<ArtistDTO> getArtistsByUserId2(@PathVariable("id") String id){
        return artistService.getArtistsByUserId2(id);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add-artist")
    public ResponseEntity<Artist> setArtist(@RequestBody Artist artist) {
        Optional<User> userModelOptional = userRepository.findById(artist.getUser().getId());
        if(!userModelOptional.isPresent()){
            String errorMessage = "User not found. Cannot process the request.";
            return ResponseEntity.unprocessableEntity().build();
        }
        artist.setUser(userModelOptional.get());
        return ResponseEntity.ok(this.artistService.saveArtist(artist));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "/delete-artist/{id}")
    public ResponseEntity<String> deleteArtist(@PathVariable("id") Integer id) {
        if (artistService.deleteArtist(id)) {
            return ResponseEntity.ok("artist deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
