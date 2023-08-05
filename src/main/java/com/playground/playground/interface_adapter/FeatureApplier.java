package com.playground.playground.interface_adapter;

import java.util.ArrayList;

public interface FeatureApplier {
  /**
   * @param dataset
   * @return
   */
  ArrayList<ArrayList<Object>> applyFeature(ArrayList<ArrayList<Object>> dataset);
}
