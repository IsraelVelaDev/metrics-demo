package com.isra_dev.metrics_demo.config;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class MetricsConfig {

    @Bean
    public AtomicInteger activeSessionsGauge(MeterRegistry registry) {
        AtomicInteger activeSessions = new AtomicInteger(0);
        Gauge.builder("active.sessions", activeSessions, AtomicInteger::get)
                .description("Number of currently active sessions")
                .register(registry);
        return activeSessions;
    }
}