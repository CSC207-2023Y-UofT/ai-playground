package com.playground.playground.data;

import java.util.ArrayList;

public class DataGeneratorFactory {
    public static DatasetGenerator createDataGenerator(String dataName) {
        switch (dataName) {
            case "circular":
                return new CircularDatasetGenerator();
            case "cluster":
                return new ClusterDatasetGenerator();
            case "quadrant":
                return new QuadrantDatasetGenerator();
            case "spiral":
                return new SpiralDatasetGenerator();
            default:
                throw new IllegalArgumentException("Invalid dataset name: " + dataName);
        }
    }
}
