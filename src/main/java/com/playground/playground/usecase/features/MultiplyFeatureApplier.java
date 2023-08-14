package com.playground.playground.usecase.features;

import com.playground.playground.entity.FeatureApplier;
import java.util.ArrayList;

/**
 * Applies a multiplication feature to the dataset by multiplying the x and y values of each datasets
 * point.
 */
public class MultiplyFeatureApplier implements FeatureApplier {
  /**
   * Multiplies the x and y values of each datasets point in the provided dataset.
   *
   * @param dataset Given in the transformed dataset format
   * @return the same dataset with the x multiplied with y added to the correct datasets set.
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
