package com.hotsliggitybatch.mappers;

import com.hotsliggitybatch.enumerations.Seasons;
import com.hotsliggitybatch.helpers.MatchDateTimeHelper;
import com.hotsliggitybatch.models.Match;
import com.hotsliggitybatch.models.MatchLog;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class MatchToMatchLogMapper {

    public MatchLog map(Match match) {

        MatchLog matchLog = new MatchLog();

        matchLog.setMatchType(match.getMatchType());
        matchLog.setMapName(match.getMapName());
        matchLog.setMatchLength(match.getMatchLength());
        matchLog.setHeroName(match.getHeroName());
        matchLog.setHeroLevel(match.getHeroLevel());
        matchLog.setMatchmakingRating(match.getMatchmakingRating());
        matchLog.setRatingAdjustmentPoints(match.getRatingAdjustmentPoints());
        matchLog.setMatchDateTime(match.getMatchDateTime());
        matchLog.setMatchOutcome(deriveMatchOutcome(match.getRatingAdjustmentPoints()));
        matchLog.setSeason(deriveSeason(match.getMatchDateTime()));

        return matchLog;
    }

    private String deriveMatchOutcome(String ratingAdjustmentPoints) {
        //TODO [datastore] catch exception when ratingAdjustmentPoints cannot convert to Integer
        if(Integer.valueOf(ratingAdjustmentPoints) <= 0) {
            return "loss";
        }
        else {
            return "win";
        }
    }

    protected String deriveSeason(String matchDateTime) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        LocalDate matchDate = LocalDate.parse(MatchDateTimeHelper.toMatchDate(matchDateTime), dateTimeFormatter);

        for(Seasons season : Seasons.values()) {
            LocalDate seasonStartDate = LocalDate.parse(season.getSeasonStartDate(), dateTimeFormatter);

            if(matchDate.isAfter(seasonStartDate)) {
                return season.getSeasonName();
            }
        }

        //TODO [datastore] throw custom exception to prevent bad data
        return "";
    }
}
