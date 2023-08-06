package com.playground.playground.data;

import java.util.ArrayList;
import java.util.Random;

/**
 * A data generator for creating spiral datasets in both clockwise and counterclockwise directions.
 * The dataset contains two spiral patterns with increasing and decreasing radii, respectively.
 */
public class SpiralDatasetGenerator implements DatasetGenerator {

  /**
   * Generates a dataset containing two spiral patterns.
   *
   * @param noise The number of random points to add as noise to each spiral dataset.
   * @return An ArrayList containing two ArrayLists representing the datasets for the two spiral
   *     patterns. Each inner ArrayList contains two ArrayLists (one for x-coordinates and one for
   *     y-coordinates).
   */
  @Override
  public ArrayList<ArrayList<ArrayList<Double>>> generate(int noise) {
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
   * @param direction The direction of the spiral pattern (1 for clockwise or -1 for
   *     counterclockwise).
   * @param noise The number of random points to add as noise to the spiral dataset.
   * @return An ArrayList containing two ArrayLists (one for x-coordinates and one for
   *     y-coordinates) representing the spiral dataset.
   */
  public static ArrayList<ArrayList<Double>> generateSpiralDataset(
      int size, int direction, int noise) {
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
