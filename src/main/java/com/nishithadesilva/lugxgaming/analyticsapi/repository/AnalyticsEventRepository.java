package com.nishithadesilva.lugxgaming.analyticsapi.repository;

import com.nishithadesilva.lugxgaming.analyticsapi.domain.AnalyticsEvent;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Repository
public class AnalyticsEventRepository {

    private final String url = System.getenv("CLICKHOUSE_URL");

    public AnalyticsEvent save(AnalyticsEvent event) {
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "INSERT INTO analytics_events (sessionId, pageUrl, scrollDepth, timeSpent, clicks, timestamp) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, event.getSessionId());
            stmt.setString(2, event.getPageUrl());
            stmt.setInt(3, event.getScrollDepth());
            stmt.setInt(4, event.getTimeSpent());
            stmt.setInt(5, event.getClicks());
            stmt.setLong(6, event.getTimestamp());
            stmt.executeUpdate();
            return event;
        } catch (Exception e) {
            throw new RuntimeException("Failed to save analytics event", e);
        }
    }
}