package com.playground.playground.data;

import java.util.ArrayList;

public class Features {

  /**
   * Squares the values of either the x or y-axis of a dataset
   *
   * @param dataset Given in the transformed dataset format for Example: [ [[x_0, y_0], 0], [[x_1,
   *     y_1], 1], [[x_2, y_2], 0], [[x_3, y_3], 1] ]
   * @param axis the axis of the coordinates to be squared (0 = x-axis, 1 = y-axis) for Example: 0
   * @return The same dataset with the correct axis values squared appended to the correct
   *     coordinates list. result Example: [ [[x_0, y_0, x_0^2], 0], [[x_1, y_1, x_1^2], 1], [[x_2,
   *     y_2, x_2^2], 0], [[x_3, y_3, x_3^2], 1] ]
   */
  public static ArrayList<ArrayList<Object>> squareVal(
      ArrayList<ArrayList<Object>> dataset, int axis) {
    ArrayList<ArrayList<Object>> newDataset = new ArrayList<>();

    for (ArrayList<Object> datapoint : dataset) {
      ArrayList<Double> oldCoordinates = (ArrayList<Double>) datapoint.get(0);
      ArrayList<Double> newCoordinates = new ArrayList<>(oldCoordinates);
      Integer state = (Integer) datapoint.get(1);
      Double point = newCoordinates.get(axis);
      newCoordinates.add(point * point);
      ArrayList<Object> newDatapoint = new ArrayList<>();
      newDatapoint.add(newCoordinates);
      newDatapoint.add(state);
      newDataset.add(newDatapoint);
    }
    return newDataset;
  }

  /**
   * Applies the sin function to the values of either the x or y-axis of a dataset.
   *
   * @param dataset Given in the transformed dataset format
   * @param axis the axis of the coordinates to apply the sin function to (0 = x-axis, 1 = y-axis)
   * @return The same dataset with sin applied to the correct axis values appended to the correct
   *     coordinates list
   */
  public static ArrayList<ArrayList<Object>> sinVal(
      ArrayList<ArrayList<Object>> dataset, int axis) {
    ArrayList<ArrayList<Object>> newDataset = new ArrayList<>();

    for (ArrayList<Object> datapoint : dataset) {
      ArrayList<Double> oldCoordinates = (ArrayList<Double>) datapoint.get(0);
      ArrayList<Double> newCoordinates = new ArrayList<>(oldCoordinates);
      Integer state = (Integer) datapoint.get(1);
      Double point = newCoordinates.get(axis);
      point = Math.sin(point);
      newCoordinates.add(point);
      ArrayList<Object> newDatapoint = new ArrayList<>();
      newDatapoint.add(newCoordinates);
      newDatapoint.add(state);
      newDataset.add(newDatapoint);
    }
    return newDataset;
  }

  /**
   * Multiplies the x and y values of each data point in the provided dataset.
   *
   * @param dataset Given in the transformed dataset format
   * @return the same dataset with the x multiplied with y added to the correct data set.
   */
  public static ArrayList<ArrayList<Object>> multiplyVal(ArrayList<ArrayList<Object>> dataset) {
    ArrayList<ArrayList<Object>> newDataset = new ArrayList<>();

    for (ArrayList<Object> datapoint : dataset) {
      ArrayList<Double> oldCoordinates = (ArrayList<Double>) datapoint.get(0);
      ArrayList<Double> newCoordinates = new ArrayList<>(oldCoordinates);
      Integer state = (Integer) datapoint.get(1);
      Double point = newCoordinates.get(0) * newCoordinates.get(1);
      newCoordinates.add(point);
      ArrayList<Object> newDatapoint = new ArrayList<>();
      newDatapoint.add(newCoordinates);
      newDatapoint.add(state);
      newDataset.add(newDatapoint);
    }
    return newDataset;
  }
}
