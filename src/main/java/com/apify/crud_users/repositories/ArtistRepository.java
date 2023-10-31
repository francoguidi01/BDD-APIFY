package com.apify.crud_users.repositories;

import com.apify.crud_users.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.ArrayList;
public interface ArtistRepository extends JpaRepository <Artist, Integer> {
    ArrayList<Artist> findByUserId(String userId);

}
