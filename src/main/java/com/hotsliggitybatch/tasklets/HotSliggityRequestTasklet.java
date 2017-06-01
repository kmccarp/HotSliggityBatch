package com.hotsliggitybatch.tasklets;

import com.hotsliggitybatch.models.MatchesRequest;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HotSliggityRequestTasklet implements Tasklet {

    @Autowired
    private MatchesRequest matchesRequest;

    @Value("${uri.post}")
    private String postUri;

    private RestTemplate restTemplate;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        HttpEntity<MatchesRequest> entity = new HttpEntity<>(matchesRequest);

        restTemplate = new RestTemplate();

        restTemplate.exchange(postUri, HttpMethod.POST, entity, Void.class);

        return RepeatStatus.FINISHED;
    }
}
