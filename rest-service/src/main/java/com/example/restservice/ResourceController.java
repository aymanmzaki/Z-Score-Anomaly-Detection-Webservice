package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    private final AtomicLong counter = new AtomicLong();

    @PostMapping ("/data")
    public AnomalyDetection anomalyDetection(@RequestParam double[] values, double threshold) {
        return new AnomalyDetection(counter.incrementAndGet(), values, threshold);
    }
}