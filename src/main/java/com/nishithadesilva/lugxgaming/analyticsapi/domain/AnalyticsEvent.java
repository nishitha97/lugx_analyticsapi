package com.nishithadesilva.lugxgaming.analyticsapi.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AnalyticsEvent {

    @NotBlank
    private String sessionId;

    @NotBlank
    private String pageUrl;

    @NotNull
    private Integer scrollDepth;

    @NotNull
    private Integer timeSpent;

    @NotNull
    private Integer clicks;

    private long timestamp = System.currentTimeMillis();

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public Integer getScrollDepth() {
        return scrollDepth;
    }

    public void setScrollDepth(Integer scrollDepth) {
        this.scrollDepth = scrollDepth;
    }

    public Integer getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(Integer timeSpent) {
        this.timeSpent = timeSpent;
    }

    public Integer getClicks() {
        return clicks;
    }

    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}