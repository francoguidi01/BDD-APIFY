package com.apify.crud_users.services;

import com.apify.crud_users.models.SongModel;
import com.apify.crud_users.repositories.IUSongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SongService {
    @Autowired
    IUSongRepository songRepository;

    public ArrayList<SongModel>getSongs(){return (ArrayList<SongModel>) songRepository.findAll();}

    public SongModel saveSong(SongModel songs) {
        return songRepository.save(songs);
    }
    public ArrayList<SongModel> getSongsByUserId(String userId) {
        return songRepository.findByUserId(userId);
    }

    public Boolean deleteSong (Integer id){
        try {
            songRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }



}
