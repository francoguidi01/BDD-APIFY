package com.apify.crud_users.services;

import com.apify.crud_users.DTOS.SongDTO;
import com.apify.crud_users.models.Song;
import com.apify.crud_users.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongService {
    @Autowired
    SongRepository songRepository;

    public ArrayList<Song>getSongs(){return (ArrayList<Song>) songRepository.findAll();}

    public Song saveSong(Song songs) {
        return songRepository.save(songs);
    }
    public ArrayList<Song> getSongsByUserId(String userId) {
        return songRepository.findByUserId(userId);
    }
public List<SongDTO>getSongsByUserId2(String id){return  songRepository.getSongsByUserId2(id);}
    public Boolean deleteSong (Integer id){
        try {
            songRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }


}
