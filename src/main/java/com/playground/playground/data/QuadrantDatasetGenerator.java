package com.playground.playground.data;

import java.util.ArrayList;
import java.util.Random;

/**
 * A data generator for creating datasets representing points in the four quadrants of the Cartesian
 * plane.
 */
public class QuadrantDatasetGenerator implements DatasetGenerator {

  /**
   * Generates a dataset containing points in the first and third quadrants.
   *
   * @param noise The number of random points to add as noise to each quadrant dataset.
   * @return An ArrayList containing two ArrayLists representing the datasets for the first and
   *     third quadrants. Each inner ArrayList contains two ArrayLists (one for x-coordinates and
   *     one for y-coordinates).
   */
  @Override
  public ArrayList<ArrayList<ArrayList<Double>>> generate(int noise) {
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
   * @return An ArrayList containing two ArrayLists (one for x-coordinates and one for
   *     y-coordinates) representing the quadrant dataset.
   */
  public static ArrayList<ArrayList<Double>> generateQuadrantDataset(
      int size, int xSign, int ySign, int noise) {
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
}
