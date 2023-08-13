package com.playground.playground.usecase.features;

import com.playground.playground.entity.FeatureApplier;
import com.playground.playground.entity.FeatureConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * A factory class responsible for creating and providing instances of FeatureApplier. Based on the
 * provided feature name, the corresponding FeatureApplier object is returned. The available
 * features include "squareX", "squareY", "XtimesY", "sinX", "sinY".
 */
public class FeatureApplierFactory {
  private static final Map<String, FeatureApplier> applierMap = new HashMap<>();

  static {
    applierMap.put(FeatureConstants.SQUARE_X, new SquareFeatureApplier(0));
    applierMap.put(FeatureConstants.SQUARE_Y, new SquareFeatureApplier(1));
    applierMap.put(FeatureConstants.X_TIMES_Y, new MultiplyFeatureApplier());
    applierMap.put(FeatureConstants.SIN_X, new SinFeatureApplier(0));
    applierMap.put(FeatureConstants.SIN_Y, new SinFeatureApplier(1));
  }

  /**
   * @param featureName String representing the feature chosen by the user. Precondition feature
   *     name either empty list or a list containing one or more of the following: "squareX",
   *     "squareY", "XtimesY", "sinX", "sinY"
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
