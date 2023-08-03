package com.playground.playground;

import java.util.ArrayList;

public class TestGenerateDatasets {

    public static void main(String[] args) {
        testGenerateCircular();
        testGenerateClusters();
        testGenerateQuadrantDatasets();
        testGenerateSpiralDatasets();
    }

    public static void testGenerateCircular() {
        int noise = 5;
        ArrayList<ArrayList<ArrayList<Double>>> dataset = GenerateDatasets.generateCircular(noise);

        // Validate the size and structure of the dataset
        if (dataset.size() != 2) {
            System.out.println("Test failed: The dataset should contain two clusters.");
            return;
        }

        for (ArrayList<ArrayList<Double>> cluster : dataset) {
            if (cluster.size() != 2) {
                System.out.println("Test failed: Each cluster should contain two ArrayLists for x and y coordinates.");
                return;
            }

            if (cluster.get(0).size() != 1000 + noise * 10 || cluster.get(1).size() != 1000 + noise * 10) {
                System.out.println("Test failed: Each cluster should contain 1000 points + noise.");
                return;
            }
        }

        System.out.println("Test passed: generateCircular()");
    }

    public static void testGenerateClusters() {
        int noise = 5;
        ArrayList<ArrayList<ArrayList<Double>>> clusters = GenerateDatasets.generateClusters(noise);

        // Validate the size and structure of the clusters
        for (ArrayList<ArrayList<Double>> cluster : clusters) {
            if (cluster.size() != 2) {
                System.out.println("Test failed: Each cluster should contain two ArrayLists for x and y coordinates.");
                return;
            }

            if (cluster.get(0).size() != 1000 + noise * 10 || cluster.get(1).size() != 1000 + noise * 10) {
                System.out.println("Test failed: Each cluster should contain 1000 points + noise.");
                return;
            }
        }

        // Validate that the two clusters have different center coordinates
        ArrayList<ArrayList<Double>> cluster1 = clusters.get(0);
        ArrayList<ArrayList<Double>> cluster2 = clusters.get(1);
        if (cluster1.get(0).get(0).equals(cluster2.get(0).get(0)) ||
            cluster1.get(1).get(0).equals(cluster2.get(1).get(0))) {
            System.out.println("Test failed: The first and second clusters should have different center coordinates.");
            return;
        }

        System.out.println("Test passed: generateClusters()");
    }

    public static void testGenerateQuadrantDatasets() {
        int noise = 5;
        ArrayList<ArrayList<ArrayList<Double>>> datasets = GenerateDatasets.generateQuadrantDatasets(noise);

        // Validate the size and structure of the datasets
        if (datasets.size() != 2) {
            System.out.println("Test failed: The datasets should contain two quadrants.");
            return;
        }

        for (ArrayList<ArrayList<Double>> quadrant : datasets) {
            if (quadrant.size() != 2) {
                System.out.println("Test failed: Each quadrant dataset should contain two ArrayLists for x and y coordinates.");
                return;
            }

            if (quadrant.get(0).size() != 500 + noise * 10 || quadrant.get(1).size() != 500 + noise * 10) {
                System.out.println("Test failed: Each quadrant dataset should contain 500 points + noise.");
                return;
            }
        }

        System.out.println("Test passed: generateQuadrantDatasets()");
    }

    public static void testGenerateSpiralDatasets() {
        int noise = 5;
        ArrayList<ArrayList<ArrayList<Double>>> datasets = GenerateDatasets.generateSpiralDatasets(noise);

        // Validate the size and structure of the datasets
        if (datasets.size() != 2) {
            System.out.println("Test failed: The datasets should contain two spiral patterns.");
            return;
        }

        for (ArrayList<ArrayList<Double>> spiral : datasets) {
            if (spiral.size() != 2) {
                System.out.println("Test failed: Each spiral dataset should contain two ArrayLists for x and y coordinates.");
                return;
            }

            if (spiral.get(0).size() != 500 + noise * 10 || spiral.get(1).size() != 500 + noise * 10) {
                System.out.println("Test failed: Each spiral dataset should contain 500 points + noise.");
                return;
            }
        }

        System.out.println("Test passed: generateSpiralDatasets()");
    }
}