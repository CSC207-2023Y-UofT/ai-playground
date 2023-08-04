package com.playground.playground.data;

import java.util.ArrayList;

public class SinFeatureApplier implements FeatureApplier {
  private final int axis;

  /**
   * @param axis the axis of the coordinates to apply the sin function to (0 = x-axis, 1 = y-axis)
   */
  public SinFeatureApplier(int axis) {
    this.axis = axis;
  }

  /**
   * Applies the sin function to the values of either the x or y-axis of a dataset.
   *
   * @param dataset Given in the transformed dataset format
   * @return The same dataset with sin applied to the correct axis values appended to the correct
   *     coordinates list
   */
  @Override
  public ArrayList<ArrayList<Object>> applyFeature(ArrayList<ArrayList<Object>> dataset) {
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
}
