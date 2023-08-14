package com.playground.playground.feature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.playground.playground.usecase.features.MultiplyFeatureApplier;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class MultiplyFeatureTest {
  @Test
  public void testMultiplyFeatureApplier() {
    ArrayList<Object> dataPoint1 =
        new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(2.0, 3.0)), 0));
    ArrayList<Object> dataPoint2 =
        new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(4.0, 5.0)), 1));
    ArrayList<ArrayList<Object>> dataset = new ArrayList<>(Arrays.asList(dataPoint1, dataPoint2));

    MultiplyFeatureApplier multiplyFeatureApplier = new MultiplyFeatureApplier();
    ArrayList<ArrayList<Object>> result = multiplyFeatureApplier.applyFeature(dataset);

    assertNotNull(result);
    assertEquals(2, result.size());

    ArrayList<Double> data1 = (ArrayList<Double>) result.get(0).get(0);
    assertEquals(6.0, data1.get(2));

    ArrayList<Double> data2 = (ArrayList<Double>) result.get(1).get(0);
    assertEquals(20.0, data2.get(2));
  }
}
