package com.apify.crud_users.services;

import com.apify.crud_users.models.SongModel;
import com.apify.crud_users.repositories.IUSongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SongService {
    @Autowired
    IUSongRepository songXusersRepository;

    public ArrayList<SongModel>getSongs(){return (ArrayList<SongModel>) songXusersRepository.findAll();}

    public SongModel saveSong(SongModel songs) {
        return songXusersRepository.save(songs);
    }
    public ArrayList<SongModel> getSongsByUserId(Integer userId) {
        return songXusersRepository.findByUserId(userId);
    }

    public Boolean deleteSong (Integer id){
        try {
            songXusersRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }



}
