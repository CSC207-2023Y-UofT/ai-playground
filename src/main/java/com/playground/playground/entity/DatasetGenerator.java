package com.playground.playground.entity;

import java.util.ArrayList;

/**
 * The interface for a dataset generator that creates datasets for testing machine learning
 * algorithms. Implementations of this interface are responsible for generating datasets with
 * specific patterns such as circular clusters, cluster patterns, quadrant datasets, and spiral
 * datasets.
 */
public interface DatasetGenerator {

  /**
   * Generates a dataset with a specific pattern.
   *
   * @param noise The number of random points to add as noise to the dataset.
   * @return An ArrayList containing ArrayLists representing the dataset. Each inner ArrayList
   *     contains two ArrayLists (one for x-coordinates and one for y-coordinates) representing the
   *     pattern.
   */
  ArrayList<ArrayList<ArrayList<Double>>> generate(int noise);
}
