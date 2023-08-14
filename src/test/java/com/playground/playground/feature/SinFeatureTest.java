package com.playground.playground.feature;

import com.playground.playground.usecase.features.SinFeatureApplier;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SinFeatureTest {
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
        assertEquals(1.0, data1.get(2), 0.0001); // Applying the sine function to the second element (Math.PI / 2) in the first data point

        ArrayList<Double> data2 = (ArrayList<Double>) result.get(1).get(0);
        assertEquals(0.0, data2.get(2), 0.0001); // Applying the sine function to the second element (0.0) in the second data point
    }

}
