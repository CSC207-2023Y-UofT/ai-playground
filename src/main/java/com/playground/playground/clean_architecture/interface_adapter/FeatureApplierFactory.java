package com.playground.playground.clean_architecture.interface_adapter;

import java.util.HashMap;
import java.util.Map;

public class FeatureApplierFactory {
  private static final Map<String, FeatureApplier> applierMap = new HashMap<>();

  static {
    applierMap.put("squareX", new SquareFeatureApplier(0));
    applierMap.put("squareY", new SquareFeatureApplier(1));
    applierMap.put("XtimesY", new MultiplyFeatureApplier());
    applierMap.put("sinX", new SinFeatureApplier(0));
    applierMap.put("sinY", new SinFeatureApplier(1));
  }

  /**
   * @param featureName String representing the feature chosen by the user. Possible names for
   *     Features: 'squareX' 'squareY' 'XtimesY' 'sinX' 'sinY'
   * @return A FeatureApplier, this object applies the needed feature
   */
  public static FeatureApplier getFeature(String featureName) {
    FeatureApplier feature = applierMap.get(featureName);

    if (feature == null) {
      throw new IllegalArgumentException("Invalid feature name: " + featureName);
    }
    return feature;
  }
}
