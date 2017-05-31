package com.hotsliggitybatch.helpers;

public class MatchDateTimeHelper {

    public static String toMatchDate(String matchDateTime) {
        matchDateTime = addMissingMonthDigit(matchDateTime);
        matchDateTime = addMissingDayDigit(matchDateTime);

        //Remove time
        return matchDateTime.substring(0, 10);
    }

    private static String addMissingMonthDigit(String matchDateTime) {
        if(Character.toString(matchDateTime.charAt(1)).equals("/")) {
            matchDateTime = "0" + matchDateTime;
        }

        return matchDateTime;
    }

    private static String addMissingDayDigit(String matchDateTime) {
        if(Character.toString(matchDateTime.charAt(4)).equals("/")) {
            matchDateTime = matchDateTime.substring(0, 3) + "0" + matchDateTime.substring(3);
        }

        return matchDateTime;
    }
}
