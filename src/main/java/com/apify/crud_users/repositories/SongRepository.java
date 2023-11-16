package com.apify.crud_users.repositories;

import com.apify.crud_users.DTOS.SongDTO;
import com.apify.crud_users.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {
    ArrayList<Song> findByUserId(String userId);

    @Query("SELECT new com.apify.crud_users.DTOS.SongDTO(s.id_api_song) FROM Song s JOIN User u ON s.user.id = u.id WHERE u.id = :userId")
    List<SongDTO> getSongsByUserId2(@Param("userId") String userId);



//select s.id_api_song from songs s
//inner join users u on s.id_user=u.id;

}
