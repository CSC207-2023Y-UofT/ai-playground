package com.playground.playground.usecase.datasets;

import java.util.ArrayList;

/**
 * A utility class for transforming datasets generated by DataGenerator to a format more appropriate
 * for Deep Learning.
 */
public class TransformDatasets {

  /**
   * Transforms a dataset from ArrayList of ArrayLists to ArrayList of Lists with weights.
   *
   * @param data The input dataset to be transformed.
   * @return An ArrayList containing points with coordinates and associated weights.
   */
  public static ArrayList<ArrayList<Object>> transform(
      ArrayList<ArrayList<ArrayList<Double>>> data) {
    // Initialize the output dataset
    ArrayList<ArrayList<Object>> dataset = new ArrayList<ArrayList<Object>>();

    // Transform points from cluster 0
    if (!data.isEmpty() && !data.get(0).isEmpty()) {
      int number0 = data.get(0).get(0).size();
      for (int i = 0; i < number0; i++) {
        int weight = 0; // Assign a weight of 0 for points in cluster 0
        ArrayList<Object> point = new ArrayList<Object>();
        ArrayList<Double> coord = new ArrayList<Double>();
        Double xp = data.get(0).get(0).get(i);
        Double yp = data.get(0).get(1).get(i);
        coord.add(xp);
        coord.add(yp);
        point.add(coord);
        point.add(weight);
        dataset.add(point);
      }
    }

    // Transform points from cluster 1
    if (data.size() > 1 && !data.get(1).isEmpty()) {
      int number1 = data.get(1).get(0).size();
      for (int i = 0; i < number1; i++) {
        int weight = 1; // Assign a weight of 1 for points in cluster 1
        ArrayList<Object> point = new ArrayList<Object>();
        ArrayList<Double> coord = new ArrayList<Double>();
        Double xp = data.get(1).get(0).get(i);
        Double yp = data.get(1).get(1).get(i);
        coord.add(xp);
        coord.add(yp);
        point.add(coord);
        point.add(weight);
        dataset.add(point);
      }
    }

    return dataset;
  }
}
