package com.nishithadesilva.lugxgaming.analyticsapi.service;


import com.clickhouse.client.*;

import com.nishithadesilva.lugxgaming.analyticsapi.domain.AnalyticsEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ClickHouseService {

    private final ClickHouseClient client;
    private final ClickHouseNode server;

    public ClickHouseService(
            @Value("${clickhouse.url}") String clickhouseUrl,
            @Value("${clickhouse.user}") String username,
            @Value("${clickhouse.password}") String password
    ) {
        HashMap<String, String> options = new HashMap<>();
        options.put("user", username);
        options.put("password", password);

        this.server = ClickHouseNode.of(clickhouseUrl, options);
        this.client = ClickHouseClient.newInstance(ClickHouseProtocol.HTTP);
    }

    public void insertAnalyticsEvent(AnalyticsEvent event) throws Exception {
        String query = String.format(
                "INSERT INTO analyticsdb.analytics_events " +
                        "(sessionId, pageUrl, scrollDepth, timeSpent, clicks, timestamp) VALUES " +
                        "('%s', '%s', %d, %d, %d, %d)",
                escapeString(event.getSessionId()),
                escapeString(event.getPageUrl()),
                event.getScrollDepth(),
                event.getTimeSpent(),
                event.getClicks(),
                event.getTimestamp()
        );

        client.write(server).query(query).execute().get();
    }

    private String escapeString(String value) {
        return value.replace("'", "''");
    }
}
