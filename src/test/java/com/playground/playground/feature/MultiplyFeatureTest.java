package com.playground.playground.feature;

import com.playground.playground.usecase.features.MultiplyFeatureApplier;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
/**
 * Test class for MultiplyFeatureApplier, responsible for verifying the multiplication feature application.
 */
public class MultiplyFeatureTest {
    /**
     * Tests the application of the multiplication feature on a dataset.
     * Verifies that the result contains the correct multiplication of the given coordinates.
     */
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
