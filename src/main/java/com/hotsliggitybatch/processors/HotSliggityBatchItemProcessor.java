package com.hotsliggitybatch.processors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotsliggitybatch.mappers.MatchToMatchLogMapper;
import com.hotsliggitybatch.models.Match;
import com.hotsliggitybatch.models.MatchLog;
import com.hotsliggitybatch.models.MatchesRequest;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@JobScope
public class HotSliggityBatchItemProcessor implements ItemProcessor<Match, MatchLog>
{
    @Autowired
    private MatchToMatchLogMapper matchToMatchLogMapper;

    @Autowired
    private MatchesRequest matchesRequest;

    @Override
    public MatchLog process(Match match) throws Exception
    {
        MatchLog matchLog = matchToMatchLogMapper.map(match);
        matchesRequest.getMatches().add(matchLog);

        System.out.println(new ObjectMapper().writeValueAsString(matchLog));

        return matchLog;
    }
}