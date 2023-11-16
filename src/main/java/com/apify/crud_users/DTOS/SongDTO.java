package com.apify.crud_users.DTOS;

public class SongDTO {
    private String id_api_songs;

    public SongDTO(String id_api_songs) {
        this.id_api_songs = id_api_songs;
    }

    public String getId_api_songs() {
        return id_api_songs;
    }

    public void setId_api_songs(String id_api_songs) {
        this.id_api_songs = id_api_songs;
    }
}
