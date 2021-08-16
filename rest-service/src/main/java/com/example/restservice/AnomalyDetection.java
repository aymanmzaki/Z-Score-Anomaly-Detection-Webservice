package com.example.restservice;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AnomalyDetection {

    public  OutlierResponse detectAnomaly(double[] numArray,double threshold){
        double sum = 0.0;
        double length = numArray.length;
        Map<Integer,Double> outliers = new HashMap<>();
        int index=0;
        for(double num : numArray){
            sum += num;
        }
        double mean = sum/length;

        double std = 0.0;
        for(double num: numArray) {
            std += Math.pow(num - mean, 2);
        }

        std = Math.sqrt(std/length);
        boolean result = false;

        for(double num: numArray) {
            index++;
           double z = (num - mean) / std;
            if (z > threshold) {
                result = true;
                outliers.put(index,num);
            }
        }

        OutlierResponse response = new OutlierResponse();
        response.setOutlier(result);
        response.setOutlierPoints(outliers);

        return response;
    }
}