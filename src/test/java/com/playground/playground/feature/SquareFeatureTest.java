package com.playground.playground.feature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.playground.playground.entity.FeatureApplier;
import com.playground.playground.interface_adapter.controller.FeatureController;
import com.playground.playground.usecase.features.FeatureApplierFactory;
import com.playground.playground.usecase.features.MultiplyFeatureApplier;
import com.playground.playground.usecase.features.SinFeatureApplier;
import com.playground.playground.usecase.features.SquareFeatureApplier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.primitives.Pair;
public class SquareFeatureTest {
    @Test
    public void testSquareFeatureApplier() {
        ArrayList<Object> dataPoint1 =
                new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(2.0, 3.0)), 0));
        ArrayList<Object> dataPoint2 =
                new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(4.0, 5.0)), 1));
        ArrayList<ArrayList<Object>> dataset = new ArrayList<>(Arrays.asList(dataPoint1, dataPoint2));

        SquareFeatureApplier squareFeatureApplier = new SquareFeatureApplier(0);
        ArrayList<ArrayList<Object>> result = squareFeatureApplier.applyFeature(dataset);

        assertNotNull(result);
        assertEquals(2, result.size());

        ArrayList<Double> data1 = (ArrayList<Double>) result.get(0).get(0);
        assertEquals(4.0, data1.get(2));

        ArrayList<Double> data2 = (ArrayList<Double>) result.get(1).get(0);
        assertEquals(16.0, data2.get(2));
    }

    @Test
    public void testSquareFeatureApplierAxisOne() {
        ArrayList<Object> dataPoint1 =
                new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(2.0, 3.0)), 0));
        ArrayList<Object> dataPoint2 =
                new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(4.0, 5.0)), 1));
        ArrayList<ArrayList<Object>> dataset = new ArrayList<>(Arrays.asList(dataPoint1, dataPoint2));

        SquareFeatureApplier squareFeatureApplier = new SquareFeatureApplier(1);
        ArrayList<ArrayList<Object>> result = squareFeatureApplier.applyFeature(dataset);

        assertNotNull(result);
        assertEquals(2, result.size());

        ArrayList<Double> data1 = (ArrayList<Double>) result.get(0).get(0);
        assertEquals(9.0, data1.get(2)); // Squaring the second element (3.0) in the first data point

        ArrayList<Double> data2 = (ArrayList<Double>) result.get(1).get(0);
        assertEquals(25.0, data2.get(2)); // Squaring the second element (5.0) in the second data point
    }

}
