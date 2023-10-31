package com.apify.crud_users.DTOS;

public class LeaderboardDTO {
    private String displayName;
    private int points;

    public LeaderboardDTO(String displayName, int points) {
        this.displayName = displayName;
        this.points = points;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
