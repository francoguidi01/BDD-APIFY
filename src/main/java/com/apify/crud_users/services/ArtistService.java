package com.apify.crud_users.services;

import com.apify.crud_users.models.Artist;
import com.apify.crud_users.models.SongModel;
import com.apify.crud_users.repositories.IUArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ArtistService {

    @Autowired
    IUArtistRepository artistRepository;

    public ArrayList<Artist> getArtists() {
        return (ArrayList<Artist>) artistRepository.findAll();
    }

    public Artist saveArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    public ArrayList<Artist> getArtistByUserId(String userId) {
        return artistRepository.findByUserId(userId);
    }

    public Boolean deleteArtist(Integer id) {
        try {
            artistRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
