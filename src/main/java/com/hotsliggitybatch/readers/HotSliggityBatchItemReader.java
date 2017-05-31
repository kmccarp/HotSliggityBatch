package com.hotsliggitybatch.readers;

import com.hotsliggitybatch.models.Match;
import org.springframework.batch.item.ItemReader;

public class HotSliggityBatchItemReader implements ItemReader<Match>
{
    @Override
    public Match read() throws Exception {

        Match match = new Match();

        return match;
    }
}
