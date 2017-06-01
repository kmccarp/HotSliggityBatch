package com.hotsliggitybatch.models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MatchesRequest {
    private List<MatchLog> matches = new ArrayList<>();

    public List<MatchLog> getMatches() {
        return matches;
    }
}
