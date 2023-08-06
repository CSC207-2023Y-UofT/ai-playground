package com.playground.playground.data;

import java.util.ArrayList;
import java.util.Random;

/** A data generator for creating datasets containing two clusters with different patterns. */
public class ClusterDatasetGenerator implements DatasetGenerator {

  /**
   * Generates a dataset containing two clusters with different patterns.
   *
   * @param noise The number of random points to add as noise to each cluster dataset.
   * @return An ArrayList containing two ArrayLists representing the datasets for the two clusters.
   *     Each inner ArrayList contains two ArrayLists (one for x-coordinates and one for
   *     y-coordinates) representing the clusters.
   */
  @Override
  public ArrayList<ArrayList<ArrayList<Double>>> generate(int noise) {
    ArrayList<ArrayList<ArrayList<Double>>> clusters = new ArrayList<>();

    // Cluster 1 Parameters
    double cluster1CenterX = 5.0;
    double cluster1CenterY = 5.0;
    double cluster1StdDeviation = 1.5;
    int cluster1Size = 1000;

    ArrayList<ArrayList<Double>> cluster1 =
        generateCluster(
            cluster1CenterX, cluster1CenterY, cluster1StdDeviation, cluster1Size, noise);
    clusters.add(cluster1);

    // Cluster 2 Parameters
    double cluster2CenterX = -5.0;
    double cluster2CenterY = -5.0;
    double cluster2StdDeviation = 1.0;
    int cluster2Size = 1000;

    ArrayList<ArrayList<Double>> cluster2 =
        generateCluster(
            cluster2CenterX, cluster2CenterY, cluster2StdDeviation, cluster2Size, noise);
    clusters.add(cluster2);

    return clusters;
  }

  /**
   * Generates a cluster dataset with the specified parameters.
   *
   * @param centerX The x-coordinate of the cluster center.
   * @param centerY The y-coordinate of the cluster center.
   * @param stdDeviation The standard deviation to determine the spread of points around the cluster
   *     center.
   * @param size The number of points to generate for the cluster.
   * @param noise The number of random points to add as noise to the cluster.
   * @return An ArrayList containing two ArrayLists (one for x-coordinates and one for
   *     y-coordinates) representing the cluster dataset.
   */
  public static ArrayList<ArrayList<Double>> generateCluster(
      double centerX, double centerY, double stdDeviation, int size, int noise) {
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
}
