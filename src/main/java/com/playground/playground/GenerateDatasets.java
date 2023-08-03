package com.playground.playground;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Random;

/**
 * A utility class for generating datasets for testing machine learning algorithms.
 * The datasets are designed to represent different patterns such as circular clusters,
 * cluster patterns, quadrant datasets, and spiral datasets.
 */
public class GenerateDatasets {

    /**
     * Generates a dataset with two circular clusters.
     *
     * @param noise The number of random points to add as noise to each cluster.
     * @return An ArrayList containing two ArrayLists representing the two clusters.
     * Each inner ArrayList contains two ArrayLists (one for x-coordinates and one for y-coordinates).
     */
    public static ArrayList<ArrayList<ArrayList<Double>>> generateCircular(int noise) {
        ArrayList<ArrayList<ArrayList<Double>>> dataset = new ArrayList<ArrayList<ArrayList<Double>>>();
        ArrayList<ArrayList<Double>> dataset0 = new ArrayList<ArrayList<Double>>();
        ArrayList<ArrayList<Double>> dataset1 = new ArrayList<ArrayList<Double>>();
        ArrayList<Double> x0 = new ArrayList<Double>();
        ArrayList<Double> y0 = new ArrayList<Double>();
        ArrayList<Double> x1 = new ArrayList<Double>();
        ArrayList<Double> y1 = new ArrayList<Double>();
        int radius0 = 7;

        // Generate points for the first cluster
        for (int i = 0; i < 1000; i++) {
            double deviation0 = (Math.random() * 4) - 2;
            double angle = Math.random() * 2 * Math.PI;
            double xp = Math.cos(angle) * (radius0 + deviation0);
            double yp = Math.sin(angle) * (radius0 + deviation0);
            x0.add(xp);
            y0.add(yp);
        }
        dataset0.add(x0);
        dataset0.add(y0);
        dataset.add(dataset0);

        int radius1 = 4;
        // Generate points for the second cluster
        for (int i = 0; i < 1000; i++) {
            double deviation1 = Math.random();
            double angle = Math.random() * 2 * Math.PI;
            double xp = Math.cos(angle) * radius1 * deviation1;
            double yp = Math.sin(angle) * radius1 * deviation1;
            x1.add(xp);
            y1.add(yp);
        }

        // Add extra random points (noise) to both clusters
        for (int i = 0; i < noise * 10; i++) {
            double xNoise0 = Math.random() * 20 - 10; // Random x in the range [-10, 10]
            double yNoise0 = Math.random() * 20 - 10; // Random y in the range [-10, 10]
            x0.add(xNoise0);
            y0.add(yNoise0);

            double xNoise1 = Math.random() * 8 - 4; // Random x in the range [-4, 4]
            double yNoise1 = Math.random() * 8 - 4; // Random y in the range [-4, 4]
            x1.add(xNoise1);
            y1.add(yNoise1);
        }
        dataset1.add(x1);
        dataset1.add(y1);
        dataset.add(dataset1);
        return dataset;
    }

    /**
     * Generates a dataset with two cluster patterns.
     *
     * @param noise The number of random points to add as noise to each cluster.
     * @return An ArrayList containing two ArrayLists representing the two clusters.
     * Each inner ArrayList contains two ArrayLists (one for x-coordinates and one for y-coordinates).
     */
    public static ArrayList<ArrayList<ArrayList<Double>>> generateClusters(int noise) {
        ArrayList<ArrayList<ArrayList<Double>>> clusters = new ArrayList<>();

        // Cluster 1 Parameters
        double cluster1CenterX = 5.0;
        double cluster1CenterY = 5.0;
        double cluster1StdDeviation = 1.5;
        int cluster1Size = 1000;

        ArrayList<ArrayList<Double>> cluster1 = generateCluster(cluster1CenterX, cluster1CenterY, cluster1StdDeviation, cluster1Size, noise);
        clusters.add(cluster1);

        // Cluster 2 Parameters
        double cluster2CenterX = -5.0;
        double cluster2CenterY = -5.0;
        double cluster2StdDeviation = 1.0;
        int cluster2Size = 1000;

        ArrayList<ArrayList<Double>> cluster2 = generateCluster(cluster2CenterX, cluster2CenterY, cluster2StdDeviation, cluster2Size, noise);
        clusters.add(cluster2);

        return clusters;
    }

    /**
     * Generates a cluster pattern with the specified parameters.
     *
     * @param centerX The x-coordinate of the cluster center.
     * @param centerY The y-coordinate of the cluster center.
     * @param stdDeviation The standard deviation to determine the spread of points around the cluster center.
     * @param size The number of points to generate for the cluster.
     * @param noise The number of random points to add as noise to the cluster.
     * @return An ArrayList containing two ArrayLists (one for x-coordinates and one for y-coordinates) representing the cluster.
     */
    public static ArrayList<ArrayList<Double>> generateCluster(double centerX, double centerY, double stdDeviation, int size, int noise) {
        ArrayList<ArrayList<Double>> cluster = new ArrayList<>();
        ArrayList<Double> x = new ArrayList<>();
        ArrayList<Double> y = new ArrayList<>();

        Random random = new Random();

        // Generate points for the cluster
        for (int i = 0; i < size; i++) {
            double xValue = random.nextGaussian() * stdDeviation + centerX;
            double yValue = random.nextGaussian() * stdDeviation + centerY;
            x.add(xValue);
            y.add(yValue);
        }

        // Add extra random points (noise) to the cluster
        for (int i = 0; i < noise * 10; i++) {
            double xNoise = random.nextGaussian() * stdDeviation + centerX;
            double yNoise = random.nextGaussian() * stdDeviation + centerY;
            x.add(xNoise);
            y.add(yNoise);
        }

        cluster.add(x);
        cluster.add(y);

        return cluster;
    }

    /**
     * Generates datasets for the first and third quadrants.
     *
     * @param noise The number of random points to add as noise to each quadrant dataset.
     * @return An ArrayList containing two ArrayLists representing the datasets for the first and third quadrants.
     * Each inner ArrayList contains two ArrayLists (one for x-coordinates and one for y-coordinates).
     */
    public static ArrayList<ArrayList<ArrayList<Double>>> generateQuadrantDatasets(int noise) {
        ArrayList<ArrayList<ArrayList<Double>>> datasets = new ArrayList<>();

        // Generate the first and third quadrants dataset
        ArrayList<ArrayList<Double>> dataset1 = generateQuadrantDataset(500, 1, 1, noise);
        datasets.add(dataset1);

        // Generate the second and fourth quadrants dataset
        ArrayList<ArrayList<Double>> dataset2 = generateQuadrantDataset(500, -1, -1, noise);
        datasets.add(dataset2);

        return datasets;
    }

    /**
     * Generates a dataset for a specified quadrant.
     *
     * @param size The number of points to generate for the quadrant dataset.
     * @param xSign The sign (1 or -1) of the x-coordinate values to determine the quadrant.
     * @param ySign The sign (1 or -1) of the y-coordinate values to determine the quadrant.
     * @param noise The number of random points to add as noise to the quadrant dataset.
     * @return An ArrayList containing two ArrayLists (one for x-coordinates and one for y-coordinates) representing the quadrant dataset.
     */
    public static ArrayList<ArrayList<Double>> generateQuadrantDataset(int size, int xSign, int ySign, int noise) {
        ArrayList<ArrayList<Double>> dataset = new ArrayList<>();
        ArrayList<Double> x = new ArrayList<>();
        ArrayList<Double> y = new ArrayList<>();

        Random random = new Random();

        // Generate points for the quadrant dataset
        for (int i = 0; i < size; i++) {
            double xValue = random.nextDouble() * xSign * 10.0;
            double yValue = random.nextDouble() * ySign * 10.0;
            x.add(xValue);
            y.add(yValue);
        }

        // Add extra random points (noise) to the quadrant dataset
        for (int i = 0; i < noise * 10; i++) {
            double xNoise = random.nextDouble() * xSign * 10.0;
            double yNoise = random.nextDouble() * ySign * 10.0;
            x.add(xNoise);
            y.add(yNoise);
        }

        dataset.add(x);
        dataset.add(y);

        return dataset;
    }

    /**
     * Generates datasets for two spiral patterns.
     *
     * @param noise The number of random points to add as noise to each spiral dataset.
     * @return An ArrayList containing two ArrayLists representing the datasets for the two spiral patterns.
     * Each inner ArrayList contains two ArrayLists (one for x-coordinates and one for y-coordinates).
     */
    public static ArrayList<ArrayList<ArrayList<Double>>> generateSpiralDatasets(int noise) {
        ArrayList<ArrayList<ArrayList<Double>>> datasets = new ArrayList<>();

        // Generate the first spiral dataset (clockwise with increasing radius)
        ArrayList<ArrayList<Double>> dataset1 = generateSpiralDataset(500, 1, noise);
        datasets.add(dataset1);

        // Generate the second spiral dataset (counterclockwise with decreasing radius)
        ArrayList<ArrayList<Double>> dataset2 = generateSpiralDataset(500, -1, noise);
        datasets.add(dataset2);

        return datasets;
    }

    /**
     * Generates a dataset for a specified spiral pattern.
     *
     * @param size The number of points to generate for the spiral dataset.
     * @param direction The direction of the spiral pattern (1 for clockwise or -1 for counterclockwise).
     * @param noise The number of random points to add as noise to the spiral dataset.
     * @return An ArrayList containing two ArrayLists (one for x-coordinates and one for y-coordinates) representing the spiral dataset.
     */
    public static ArrayList<ArrayList<Double>> generateSpiralDataset(int size, int direction, int noise) {
        ArrayList<ArrayList<Double>> dataset = new ArrayList<>();
        ArrayList<Double> x = new ArrayList<>();
        ArrayList<Double> y = new ArrayList<>();

        double theta = 0.0;
        double increment = 0.2 * direction;
        double radius = 0.0;

        // Generate points for the spiral dataset
        for (int i = 0; i < size; i++) {
            radius += 0.05;
            theta += increment;

            double xValue = radius * Math.cos(theta);
            double yValue = radius * Math.sin(theta);

            x.add(xValue);
            y.add(yValue);
        }

        // Add extra random points (noise) to the spiral dataset
        Random random = new Random();
        for (int i = 0; i < noise * 10; i++) {
            double xNoise = random.nextDouble() * 10.0 - 5.0; // Random x in the range [-5.0, 5.0]
            double yNoise = random.nextDouble() * 10.0 - 5.0; // Random y in the range [-5.0, 5.0]
            x.add(xNoise);
            y.add(yNoise);
        }

        dataset.add(x);
        dataset.add(y);

        return dataset;
    }
}
