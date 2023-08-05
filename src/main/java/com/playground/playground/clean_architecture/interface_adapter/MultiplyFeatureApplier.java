package com.playground.playground.clean_architecture.interface_adapter;

import java.util.ArrayList;

public class MultiplyFeatureApplier implements FeatureApplier {
  /**
   * Multiplies the x and y values of each data point in the provided dataset.
   *
   * @param dataset Given in the transformed dataset format
   * @return the same dataset with the x multiplied with y added to the correct data set.
   */
  @Override
  public ArrayList<ArrayList<Object>> applyFeature(ArrayList<ArrayList<Object>> dataset) {
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
