package com.playground.playground.data;
import java.util.HashMap;
import java.util.Map;

/**
 * Possible names for Features:
 *  'squareX'
 *  'squareY'
 *  'XtimesY'
 *  'sinX'
 *  'sinY'
 */
public class FeatureApplierFactory {
    private static final Map<String, FeatureApplier> applierMap= new HashMap<>();

    static {
        applierMap.put("squareX", new SquareFeatureApplier(0));
        applierMap.put("squareY", new SquareFeatureApplier(1));
        applierMap.put("XtimesY", new MultiplyFeatureApplier());
        applierMap.put("sinX", new SinFeatureApplier(0));
        applierMap.put("sinY", new SinFeatureApplier(1));
    }

    public static FeatureApplier getFeature(String featureName){
        FeatureApplier feature = applierMap.get(featureName);

        if (feature == null){
            throw new IllegalArgumentException("Invalid feature name: " + featureName);
        }
        return feature;
    }



}
