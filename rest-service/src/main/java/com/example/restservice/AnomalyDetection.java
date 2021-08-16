package com.example.restservice;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AnomalyDetection {

    public  OutlierResponse detectAnomaly(double[] numArray,double threshold){
        double sum = 0.0;
        Map<Integer,Double> outliers = new HashMap<>();
        int index=0;
        for(double num : numArray){
            sum += num;
        }
        double mean = sum/numArray.length;

        double std = 0.0;
        for(double num: numArray) {
            std += Math.pow(num - mean, 2);
        }

        std = Math.sqrt(std/numArray.length);
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
        response.setInputSize(numArray.length);
        response.setOutlier(result);
        response.setOutlierPoints(outliers);

        return response;
    }
}