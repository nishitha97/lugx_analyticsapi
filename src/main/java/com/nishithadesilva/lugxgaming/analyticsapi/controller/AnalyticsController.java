package com.nishithadesilva.lugxgaming.analyticsapi.controller;

import com.nishithadesilva.lugxgaming.analyticsapi.domain.AnalyticsEvent;
import com.nishithadesilva.lugxgaming.analyticsapi.service.ClickHouseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/analytics")
@Validated
public class AnalyticsController {

    private final ClickHouseService clickHouseService;

    public AnalyticsController(ClickHouseService clickHouseService) {
        this.clickHouseService = clickHouseService;
    }

    @PostMapping("/track")
    public ResponseEntity<String> track(@Valid @RequestBody AnalyticsEvent event) {
        try {
            clickHouseService.insertAnalyticsEvent(event);
            return ResponseEntity.ok("Analytics event inserted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to insert event: " + e.getMessage());
        }
    }
}
