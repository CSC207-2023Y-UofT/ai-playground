package com.playground.playground.interface_adapter;

import java.util.ArrayList;

public class SquareFeatureApplier implements FeatureApplier {
  private final int axis;

  /**
   * @param axis the axis of the coordinates to be squared (0 = x-axis, 1 = y-axis) for Example: 0
   */
  public SquareFeatureApplier(int axis) {
    this.axis = axis;
  }

  /**
   * Squares the values of either the x or y-axis of a dataset
   *
   * @param dataset Given in the transformed dataset format for Example: [ [[x_0, y_0], 0], [[x_1,
   *     y_1], 1], [[x_2, y_2], 0], [[x_3, y_3], 1] ]
   * @return The same dataset with the correct axis values squared appended to the correct
   *     coordinates list. result Example: [ [[x_0, y_0, x_0^2], 0], [[x_1, y_1, x_1^2], 1], [[x_2,
   *     y_2, x_2^2], 0], [[x_3, y_3, x_3^2], 1] ]
   */
  @Override
  public ArrayList<ArrayList<Object>> applyFeature(ArrayList<ArrayList<Object>> dataset) {
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
}
