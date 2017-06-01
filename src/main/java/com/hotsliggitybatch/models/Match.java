package com.hotsliggitybatch.models;


import org.springframework.batch.item.ResourceAware;
import org.springframework.core.io.Resource;

public class Match implements ResourceAware {
    private String matchType;
    private String mapName;
    private String matchLength;
    private String heroName;
    private String heroLevel;
    private String matchmakingRating;
    private String ratingAdjustmentPoints;
    private String matchDateTime;

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public String getMatchLength() {
        return matchLength;
    }

    public void setMatchLength(String matchLength) {
        this.matchLength = matchLength;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroLevel() {
        return heroLevel;
    }

    public void setHeroLevel(String heroLevel) {
        this.heroLevel = heroLevel;
    }

    public String getMatchmakingRating() {
        return matchmakingRating;
    }

    public void setMatchmakingRating(String matchmakingRating) {
        this.matchmakingRating = matchmakingRating;
    }

    public String getRatingAdjustmentPoints() {
        return ratingAdjustmentPoints;
    }

    public void setRatingAdjustmentPoints(String ratingAdjustmentPoints) {
        this.ratingAdjustmentPoints = ratingAdjustmentPoints;
    }

    public String getMatchDateTime() {
        return matchDateTime;
    }

    public void setMatchDateTime(String matchDateTime) {
        this.matchDateTime = matchDateTime;
    }

    @Override
    public void setResource(Resource resource) {
        if (resource.getFilename().equals("hotsliggity_quickmatch.txt")) {
            this.matchType = "Quickmatch";
        } else if (resource.getFilename().equals("hotsliggity_unrankeddraft.txt")) {
            this.matchType = "Unranked Draft";
        } else if (resource.getFilename().equals("hotsliggity_heroleague.txt")) {
            this.matchType = "Hero League";
        } else if (resource.getFilename().equals("hotsliggity_teamleague.txt")) {
            this.matchType = "Team League";
        } else {
            //TODO catch exception to prevent bad data
        }
    }
}
