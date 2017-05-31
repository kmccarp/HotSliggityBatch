package com.hotsliggitybatch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableBatchProcessing
public class HotSliggityBatchApp
{
    public static void main(String[] args)
    {
        int exitCode = SpringApplication.exit(SpringApplication.run(HotSliggityBatchApp.class, args));

        System.exit(exitCode);
    }
}
