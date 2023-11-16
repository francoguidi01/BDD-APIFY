package com.apify.crud_users.DTOS;

public class ArtistDTO {

    private String id_api_artists;

    public ArtistDTO(String id_api_artists) {
        this.id_api_artists = id_api_artists;
    }

    public String getId_api_artists() {
        return id_api_artists;
    }

    public void setId_api_artists(String id_api_artists) {
        this.id_api_artists = id_api_artists;
    }
}
