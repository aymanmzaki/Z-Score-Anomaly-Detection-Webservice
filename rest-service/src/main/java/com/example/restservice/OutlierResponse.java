package com.example.restservice;

import java.util.HashMap;
import java.util.Map;

public class OutlierResponse{
    public int getInputSize() {
        return inputSize;
    }

    public void setInputSize(int inputSize) {
        this.inputSize = inputSize;
    }

    private int inputSize;
    private boolean outlier;
    private Map<Integer,Double> outlierPoints;

    public OutlierResponse(){
        outlierPoints = new HashMap<>();
    }
    public void setOutlier(boolean outlier) {
        this.outlier = outlier;
    }

    public boolean isOutlier() {
        return outlier;
    }

    public void setOutlierPoints(Map<Integer, Double> outlierPoints) {
        this.outlierPoints = outlierPoints;
    }

    public Map<Integer, Double> getOutlierPoints() {
        return outlierPoints;
    }
}
