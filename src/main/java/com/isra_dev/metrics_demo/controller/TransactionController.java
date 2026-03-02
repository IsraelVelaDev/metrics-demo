package com.isra_dev.metrics_demo.controller;

import com.isra_dev.metrics_demo.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/{type}")
    public ResponseEntity<String> processTransaction(@PathVariable String type) {
        if (!type.equalsIgnoreCase("CREDIT") && !type.equalsIgnoreCase("DEBIT")) {
            return ResponseEntity.badRequest().body("Type must be CREDIT or DEBIT");
        }
        return ResponseEntity.ok(transactionService.processTransaction(type));
    }

    @PostMapping("/sessions/open")
    public ResponseEntity<String> openSession() {
        transactionService.openSession();
        return ResponseEntity.ok("Session opened");
    }

    @PostMapping("/sessions/close")
    public ResponseEntity<String> closeSession() {
        transactionService.closeSession();
        return ResponseEntity.ok("Session closed");
    }
}