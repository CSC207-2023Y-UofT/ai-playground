package com.playground.playground.usecase.datasets;

import com.playground.playground.data.DatasetGenerator;

import java.util.ArrayList;

/** A data generator for creating datasets containing two circular clusters. */
public class CircularDatasetGenerator implements DatasetGenerator {

  /**
   * Generates a dataset containing two circular clusters with noise.
   *
   * @param noise The number of random points to add as noise to each cluster.
   * @return An ArrayList containing two ArrayLists representing the two clusters. Each inner
   *     ArrayList contains two ArrayLists (one for x-coordinates and one for y-coordinates)
   *     representing the clusters.
   */
  @Override
  public ArrayList<ArrayList<ArrayList<Double>>> generate(int noise) {
    ArrayList<ArrayList<ArrayList<Double>>> dataset = new ArrayList<ArrayList<ArrayList<Double>>>();
    ArrayList<ArrayList<Double>> dataset0 = new ArrayList<ArrayList<Double>>();
    ArrayList<ArrayList<Double>> dataset1 = new ArrayList<ArrayList<Double>>();
    ArrayList<Double> x0 = new ArrayList<Double>();
    ArrayList<Double> y0 = new ArrayList<Double>();
    ArrayList<Double> x1 = new ArrayList<Double>();
    ArrayList<Double> y1 = new ArrayList<Double>();
    int radius0 = 7;

    // Generate points for the first cluster
    for (int i = 0; i < 500; i++) {
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
    for (int i = 0; i < 500; i++) {
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
}
