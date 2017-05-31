package com.hotsliggitybatch.writers;

import com.hotsliggitybatch.models.ItemToWrite;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class HotSliggityBatchItemWriter implements ItemWriter<ItemToWrite>
{
    @Override
    public void write(List<? extends ItemToWrite> items) throws Exception {}
}
