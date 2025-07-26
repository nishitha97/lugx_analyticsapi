package com.nishithadesilva.lugxgaming.analyticsapi.controller;

import com.nishithadesilva.lugxgaming.analyticsapi.domain.AnalyticsEvent;
import com.nishithadesilva.lugxgaming.analyticsapi.repository.AnalyticsEventRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    private final AnalyticsEventRepository repository;

    public AnalyticsController(AnalyticsEventRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/track")
    public ResponseEntity<?> track(@Valid @RequestBody AnalyticsEvent event) {
        return new ResponseEntity<>(repository.save(event), HttpStatus.OK);
    }
}
