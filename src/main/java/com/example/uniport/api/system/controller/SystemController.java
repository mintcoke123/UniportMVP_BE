package com.example.uniport.api.system.controller;

import com.example.uniport.api.system.dto.HealthResponse;
import com.example.uniport.api.system.service.SystemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class SystemController {

    private final SystemService systemService;

    @GetMapping("/health")
    public HealthResponse health() {
        return systemService.health();
    }
}

