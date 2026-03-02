package com.isra_dev.metrics_demo.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
public class TransactionService {

    private final MeterRegistry registry;
    private final AtomicInteger activeSessions;

    public TransactionService(MeterRegistry registry, AtomicInteger activeSessions) {
        this.registry = registry;
        this.activeSessions = activeSessions;
    }

    public String processTransaction(String type) {
        return Timer.builder("endpoint.latency")
                .tag("operation", "processTransaction")
                .description("Latency of transaction processing")
                .register(registry)
                .record(() -> {
                    simulateWork();
                    Counter.builder("transactions.processed")
                            .tag("type", type.toUpperCase())
                            .description("Total transactions processed")
                            .register(registry)
                            .increment();
                    log.info("Transaction processed [type={}]", type);
                    return "Processed: " + type;
                });
    }

    public void openSession() {
        activeSessions.incrementAndGet();
        log.info("Session opened. Active sessions: {}", activeSessions.get());
    }

    public void closeSession() {
        activeSessions.decrementAndGet();
        log.info("Session closed. Active sessions: {}", activeSessions.get());
    }

    private void simulateWork() {
        try {
            Thread.sleep((long) (Math.random() * 200));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}