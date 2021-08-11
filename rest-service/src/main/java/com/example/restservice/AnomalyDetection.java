package com.example.restservice;

public class AnomalyDetection {

    private final long id;
    private final boolean fake;
    public AnomalyDetection(long id, double [] values, double threshold) {
        this.id = id;
        this.fake = detectAnomaly(values, threshold);
    }


    public static boolean detectAnomaly(double[] numArray,double threshold){
        double sum = 0.0;
        double length = numArray.length;

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
           double z = (num - mean) / std;
            if (z > threshold) {
                result = true;
                break;
            }
        }

        return result;
    }

    public long getId() {
        return id;
    }

    public boolean getFake() {
        return fake;
    }

}