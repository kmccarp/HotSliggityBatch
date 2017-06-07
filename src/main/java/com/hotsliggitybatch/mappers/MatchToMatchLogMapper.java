package com.hotsliggitybatch.mappers;

import com.hotsliggitybatch.enumerations.Seasons;
import com.hotsliggitybatch.helpers.MatchDateTimeHelper;
import com.hotsliggitybatch.models.Match;
import com.hotsliggitybatch.models.MatchLog;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class MatchToMatchLogMapper {

    DateTimeFormatter matchDateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    DateTimeFormatter matchTimeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");

    public MatchLog map(Match match) {

        MatchLog matchLog = new MatchLog();

        matchLog.setMatchType(match.getMatchType());
        matchLog.setMapName(match.getMapName());
        matchLog.setMatchLength(match.getMatchLength());
        matchLog.setHeroName(match.getHeroName());
        matchLog.setHeroLevel(match.getHeroLevel());
        matchLog.setMatchmakingRating(match.getMatchmakingRating());
        matchLog.setRatingAdjustmentPoints(match.getRatingAdjustmentPoints());
        matchLog.setMatchDate(deriveMatchDate(match.getMatchDateTime()));
        matchLog.setMatchTime(deriveMatchTime(match.getMatchDateTime()));
        matchLog.setMatchOutcome(deriveMatchOutcome(match.getRatingAdjustmentPoints()));
        matchLog.setSeason(deriveSeason(match.getMatchDateTime()));

        return matchLog;
    }

    private String deriveMatchDate(String matchDateTime) {
        return LocalDate.parse(MatchDateTimeHelper.toMatchDate(matchDateTime), matchDateFormatter).toString();
    }

    private String deriveMatchTime(String matchDateTime) {
        String matchTime = MatchDateTimeHelper.toMatchTime(matchDateTime);
        LocalTime time = LocalTime.parse(matchTime, matchTimeFormatter);
        String stringTime = time.toString();

        return stringTime;
    }

    private String deriveMatchOutcome(String ratingAdjustmentPoints) {
        //TODO catch exception when ratingAdjustmentPoints cannot convert to Integer
        if(Integer.valueOf(ratingAdjustmentPoints) <= 0) {
            return "Loss";
        }
        else {
            return "Win";
        }
    }

    protected String deriveSeason(String matchDateTime) {

        LocalDate matchDate = LocalDate.parse(MatchDateTimeHelper.toMatchDate(matchDateTime), matchDateFormatter);

        for(Seasons season : Seasons.values()) {
            LocalDate seasonStartDate = LocalDate.parse(season.getSeasonStartDate(), matchDateFormatter);

            if(matchDate.isAfter(seasonStartDate)) {
                return season.getSeasonName();
            }
        }

        //TODO throw custom exception to prevent bad data
        return "";
    }
}
