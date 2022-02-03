package com.okay.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

public class ScheduledJob {

    private Logger LOGGER = LoggerFactory.getLogger(ScheduledJob.class);

    @Scheduled(cron = "0 0/60 * * * ?")
    public void interval60Min() {
        LOGGER.info("Date: {}", new Date());
    }
}