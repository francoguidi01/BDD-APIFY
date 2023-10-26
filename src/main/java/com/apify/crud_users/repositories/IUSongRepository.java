package com.apify.crud_users.repositories;

import com.apify.crud_users.models.SongModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IUSongRepository extends JpaRepository<SongModel, Integer> {
    ArrayList<SongModel> findByUserId(Integer userId);
}
