package com.playground.playground.data;

import java.util.ArrayList;

public interface FeatureApplier {
  /**
   * @param dataset in the correct NN format
   * @return the same dataset with the correct feature appended
   */
  ArrayList<ArrayList<Object>> applyFeature(ArrayList<ArrayList<Object>> dataset);
}
