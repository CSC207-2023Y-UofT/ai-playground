package com.playground.playground.usecase.datasets;

import com.playground.playground.entity.DatasetGenerator;

/**
 * The DataGeneratorFactory class is responsible for creating instances of various DatasetGenerator
 * implementations based on the given data name.
 */
public class DataGeneratorFactory {

  /**
   * Creates and returns the appropriate DatasetGenerator based on the provided data name.
   *
   * @param dataName The name of the required dataset, which can be one of the following values:
   *     "circular", "cluster", "quadrant", or "spiral".
   * @return A new instance of the DatasetGenerator that matches the given data name.
   * @throws IllegalArgumentException If the provided data name is not one of the valid options.
   */
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