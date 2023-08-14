package com.playground.playground.usecase.feature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.playground.playground.usecase.features.SinFeatureApplier;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
/**
 * Test class for SinFeatureApplier, responsible for verifying the sine feature application.
 */
public class SinFeatureTest {
  /**
   * Tests the application of the sine feature on a dataset, applying to the first axis.
   * Verifies that the result contains the correct sine values for the given coordinates.
   */
  @Test
  public void testSinFeatureApplier() {
    ArrayList<Object> dataPoint1 =
        new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(Math.PI / 2, 3.0)), 0));
    ArrayList<Object> dataPoint2 =
        new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(0.0, 5.0)), 1));
    ArrayList<ArrayList<Object>> dataset = new ArrayList<>(Arrays.asList(dataPoint1, dataPoint2));

    SinFeatureApplier sinFeatureApplier = new SinFeatureApplier(0);
    ArrayList<ArrayList<Object>> result = sinFeatureApplier.applyFeature(dataset);

    assertNotNull(result);
    assertEquals(2, result.size());

    ArrayList<Double> data1 = (ArrayList<Double>) result.get(0).get(0);
    assertEquals(1.0, data1.get(2), 0.0001);

    ArrayList<Double> data2 = (ArrayList<Double>) result.get(1).get(0);
    assertEquals(0.0, data2.get(2), 0.0001);
  }

  /**
   * Tests the application of the sine feature on a dataset, applying to the second axis.
   * Verifies that the result contains the correct sine values for the given coordinates.
   */
  @Test
  public void testSinFeatureApplierAxisOne() {
    ArrayList<Object> dataPoint1 =
        new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(2.0, Math.PI / 2)), 0));
    ArrayList<Object> dataPoint2 =
        new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(4.0, 0.0)), 1));
    ArrayList<ArrayList<Object>> dataset = new ArrayList<>(Arrays.asList(dataPoint1, dataPoint2));

    SinFeatureApplier sinFeatureApplier = new SinFeatureApplier(1);
    ArrayList<ArrayList<Object>> result = sinFeatureApplier.applyFeature(dataset);

    assertNotNull(result);
    assertEquals(2, result.size());

    ArrayList<Double> data1 = (ArrayList<Double>) result.get(0).get(0);
    assertEquals(
        1.0,
        data1.get(2),
        0.0001); // Applying the sine function to the second element (Math.PI / 2) in the first
                 // datasets
    // point

    ArrayList<Double> data2 = (ArrayList<Double>) result.get(1).get(0);
    assertEquals(
        0.0,
        data2.get(2),
        0.0001); // Applying the sine function to the second element (0.0) in the second datasets
                 // point
  }
}
