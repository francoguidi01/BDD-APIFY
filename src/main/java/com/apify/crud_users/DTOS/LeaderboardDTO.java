package com.apify.crud_users.DTOS;

public class LeaderboardDTO {
    private String displayName;

    private String url_photo;
    private int points;

    public LeaderboardDTO(String displayName, String url_photo, int points) {
        this.displayName = displayName;
        this.url_photo = url_photo;
        this.points = points;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUrl_photo() {
        return url_photo;
    }

    public void setUrl_photo(String url_photo) {
        this.url_photo = url_photo;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
