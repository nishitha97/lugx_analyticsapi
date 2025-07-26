package com.nishithadesilva.lugxgaming.analyticsapi.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthController {

    @PersistenceContext
    private EntityManager entityManager;

    @Value("${app.version:unknown}")
    private String appVersion;

    @GetMapping("/health")
    public Map<String, String> healthCheck() {
        Map<String, String> response = new HashMap<>();
        response.put("version", appVersion);
        try {
            entityManager.createNativeQuery("SELECT 1").getSingleResult();
            response.put("status", "HEALTHY");
        } catch (Exception e) {
            response.put("status", "SICK");
        }
        return response;
    }

}
