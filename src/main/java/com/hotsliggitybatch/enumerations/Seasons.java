package com.hotsliggitybatch.enumerations;

public enum Seasons {

    SEASON_1_2017("2017 Season 1", "03/15/2017"),
    SEASON_3_2016("2016 Season 3", "12/15/2016"),
    SEASON_2_2016("2016 Season 2", "09/14/2016"),
    SEASON_1_2016("2016 Season 1", "06/15/2016"),
    PRESEASON("Preseason", "03/10/2014");

    private String seasonName;
    private String seasonStartDate;

    Seasons(String seasonName, String seasonStartDate) {
        this.seasonName = seasonName;
        this.seasonStartDate = seasonStartDate;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public String getSeasonStartDate() {
        return seasonStartDate;
    }

    public void setSeasonStartDate(String seasonStartDate) {
        this.seasonStartDate = seasonStartDate;
    }
}
