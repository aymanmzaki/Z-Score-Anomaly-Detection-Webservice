package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    @Autowired
    AnomalyDetection anomalyDetection;

    private final AtomicLong counter = new AtomicLong();

    @PostMapping ("/data")
    public OutlierResponse anomalyDetection(@RequestParam double[] values, double threshold) {
        return  anomalyDetection.detectAnomaly( values, threshold);
    }
}