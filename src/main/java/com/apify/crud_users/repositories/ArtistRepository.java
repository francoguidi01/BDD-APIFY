package com.apify.crud_users.repositories;

import com.apify.crud_users.DTOS.ArtistDTO;
import com.apify.crud_users.DTOS.SongDTO;
import com.apify.crud_users.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface ArtistRepository extends JpaRepository <Artist, Integer> {
    ArrayList<Artist> findByUserId(String userId);

    @Query("SELECT new com.apify.crud_users.DTOS.ArtistDTO(a.id_api_artist) FROM Artist a JOIN User u ON a.user.id = u.id WHERE u.id = :userId")
    List<ArtistDTO> getArtistsByUserId2(@Param("userId") String userId);

}
