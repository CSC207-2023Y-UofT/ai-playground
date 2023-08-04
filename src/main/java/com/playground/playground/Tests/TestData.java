package com.playground.playground.Tests;

import com.playground.playground.data.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class to validate the functionality of various components in the data package.
 */
public class TestData {

    /**
     * Main method to run all the tests.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        testCircularDatasetGenerator();
        testQuadrantDatasetGenerator();
        testSpiralDatasetGenerator();
        testTransformDatasets();
    }

    /**
     * Test the CircularDatasetGenerator to ensure it generates circular clusters correctly.
     */
    private static void testCircularDatasetGenerator() {
        System.out.println("Testing CircularDatasetGenerator...");
        DatasetGenerator circularDatasetGenerator = new CircularDatasetGenerator();
        ArrayList<ArrayList<ArrayList<Double>>> circularDataset = circularDatasetGenerator.generate(10);

        if (circularDataset != null && circularDataset.size() == 2) {
            ArrayList<ArrayList<Double>> cluster1 = circularDataset.get(0);
            ArrayList<ArrayList<Double>> cluster2 = circularDataset.get(1);

            // Check if the clusters are not empty
            if (!cluster1.isEmpty() && !cluster2.isEmpty()) {
                // Check the number of points in each cluster
                if (cluster1.get(0).size() >= 1000 && cluster1.get(1).size() >= 1000
                        && cluster2.get(0).size() >= 1000 && cluster2.get(1).size() >= 1000) {
                    System.out.println("CircularDatasetGenerator test passed.");
                } else {
                    System.err.println("CircularDatasetGenerator test failed: Invalid cluster sizes.");
                }
            } else {
                System.err.println("CircularDatasetGenerator test failed: Empty clusters.");
            }
        } else {
            System.err.println("CircularDatasetGenerator test failed: Invalid dataset size.");
        }
    }

    /**
     * Test the QuadrantDatasetGenerator to ensure it generates datasets for first and third quadrants correctly.
     */
    private static void testQuadrantDatasetGenerator() {
        System.out.println("Testing QuadrantDatasetGenerator...");
        DatasetGenerator quadrantDatasetGenerator = new QuadrantDatasetGenerator();
        ArrayList<ArrayList<ArrayList<Double>>> quadrantDataset = quadrantDatasetGenerator.generate(10);

        if (quadrantDataset != null && quadrantDataset.size() == 2) {
            ArrayList<ArrayList<Double>> cluster1 = quadrantDataset.get(0);
            ArrayList<ArrayList<Double>> cluster2 = quadrantDataset.get(1);

            // Check if the clusters are not empty
            if (!cluster1.isEmpty() && !cluster2.isEmpty()) {
                // Check the number of points in each cluster
                if (cluster1.get(0).size() == 500 && cluster1.get(1).size() == 500
                        && cluster2.get(0).size() == 500 && cluster2.get(1).size() == 500) {
                    System.out.println("QuadrantDatasetGenerator test passed.");
                } else {
                    System.err.println("QuadrantDatasetGenerator test failed: Invalid cluster sizes.");
                }
            } else {
                System.err.println("QuadrantDatasetGenerator test failed: Empty clusters.");
            }
        } else {
            System.err.println("QuadrantDatasetGenerator test failed: Invalid dataset size.");
        }
    }

    /**
     * Test the SpiralDatasetGenerator to ensure it generates datasets for spiral patterns correctly.
     */
    private static void testSpiralDatasetGenerator() {
        System.out.println("Testing SpiralDatasetGenerator...");
        DatasetGenerator spiralDatasetGenerator = new SpiralDatasetGenerator();
        ArrayList<ArrayList<ArrayList<Double>>> spiralDataset = spiralDatasetGenerator.generate(10);

        if (spiralDataset != null && spiralDataset.size() == 2) {
            ArrayList<ArrayList<Double>> cluster1 = spiralDataset.get(0);
            ArrayList<ArrayList<Double>> cluster2 = spiralDataset.get(1);

            // Check if the clusters are not empty
            if (!cluster1.isEmpty() && !cluster2.isEmpty()) {
                // Check the number of points in each cluster
                if (cluster1.get(0).size() >= 500 && cluster1.get(1).size() >= 500
                        && cluster2.get(0).size() >= 500 && cluster2.get(1).size() >= 500) {
                    System.out.println("SpiralDatasetGenerator test passed.");
                } else {
                    System.err.println("SpiralDatasetGenerator test failed: Invalid cluster sizes.");
                }
            } else {
                System.err.println("SpiralDatasetGenerator test failed: Empty clusters.");
            }
        } else {
            System.err.println("SpiralDatasetGenerator test failed: Invalid dataset size.");
        }
    }

    /**
     * Test the TransformDatasets to ensure it correctly transforms the input dataset to a suitable format.
     */
    private static void testTransformDatasets() {
        System.out.println("Testing TransformDatasets...");
        ArrayList<ArrayList<ArrayList<Double>>> sampleData = new ArrayList<>();
        ArrayList<ArrayList<Double>> cluster1 = new ArrayList<>();
        cluster1.add(new ArrayList<>(List.of(1.0, 2.0, 3.0)));
        cluster1.add(new ArrayList<>(List.of(4.0, 5.0, 6.0)));
        ArrayList<ArrayList<Double>> cluster2 = new ArrayList<>();
        cluster2.add(new ArrayList<>(List.of(7.0, 8.0)));
        cluster2.add(new ArrayList<>(List.of(9.0, 10.0)));
        sampleData.add(cluster1);
        sampleData.add(cluster2);

        ArrayList<ArrayList<Object>> transformedData = TransformDatasets.transform(sampleData);
        if (transformedData != null && !transformedData.isEmpty()) {
            // Check the size of transformedData
            if (transformedData.size() == 6) {
                System.out.println("TransformDatasets test passed.");
            } else {
                System.err.println("TransformDatasets test failed: Invalid transformed dataset size.");
            }
        } else {
            System.err.println("TransformDatasets test failed: Failed to transform data.");
        }
    }
}
