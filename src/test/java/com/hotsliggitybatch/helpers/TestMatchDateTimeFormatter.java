package com.hotsliggitybatch.helpers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMatchDateTimeFormatter {

    @Test
    public void testToMatchDate() {
        String matchDateTime = "5/1/2017 2:45:29 AM";

        assertEquals("05/01/2017", MatchDateTimeHelper.toMatchDate(matchDateTime));
    }
}
