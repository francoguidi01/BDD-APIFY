package com.apify.crud_users.services;

import com.apify.crud_users.DTOS.ArtistDTO;
import com.apify.crud_users.DTOS.SongDTO;
import com.apify.crud_users.models.Artist;
import com.apify.crud_users.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistService {

    @Autowired
    ArtistRepository artistRepository;

    public ArrayList<Artist> getArtists() {
        return (ArrayList<Artist>) artistRepository.findAll();
    }

    public Artist saveArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    public ArrayList<Artist> getArtistByUserId(String userId) {
        return artistRepository.findByUserId(userId);
    }

    public List<ArtistDTO> getArtistsByUserId2(String id){return artistRepository.getArtistsByUserId2(id);}

    public Boolean deleteArtist(Integer id) {
        try {
            artistRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
