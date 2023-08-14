package com.playground.playground.usecase.datasets;

import com.playground.playground.entity.DatasetGenerator;
import com.playground.playground.entity.DatasetType;

/**
 * The {@code DataGeneratorFactory} class is responsible for creating instances of various {@link
 * DatasetGenerator} implementations based on the given {@link DatasetType}.
 */
public class DataGeneratorFactory {

  /**
   * Creates and returns the appropriate {@link DatasetGenerator} based on the provided {@link
   * DatasetType}.
   *
   * @param datasetType The {@link DatasetType} representing the type of dataset to be generated.
   * @return A new instance of the {@link DatasetGenerator} that matches the given {@link
   *     DatasetType}.
   * @throws IllegalArgumentException If the provided {@link DatasetType} is not one of the valid
   *     options or if it's null.
   */
  public static DatasetGenerator createDataGenerator(DatasetType datasetType) {
    if (datasetType == null) {
      throw new IllegalArgumentException("Dataset type cannot be null");
    }

    switch (datasetType) {
      case CIRCULAR:
        return new CircularDatasetGenerator();
      case CLUSTER:
        return new ClusterDatasetGenerator();
      case QUADRANT:
        return new QuadrantDatasetGenerator();
      case SPIRAL:
        return new SpiralDatasetGenerator();
      default:
        throw new IllegalArgumentException("Invalid dataset type: " + datasetType);
    }
  }
}
