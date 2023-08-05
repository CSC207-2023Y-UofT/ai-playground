package com.playground.playground.modelling;

import com.playground.playground.data.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FeatureTest {

    @Test
    public void testSquareFeatureApplier() {
        ArrayList<Object> dataPoint1 = new ArrayList<>(
                Arrays.asList(new ArrayList<>(Arrays.asList(2.0, 3.0)), 0));
        ArrayList<Object> dataPoint2 = new ArrayList<>(
                Arrays.asList(new ArrayList<>(Arrays.asList(4.0, 5.0)), 1));
        ArrayList<ArrayList<Object>> dataset = new ArrayList<>(
                Arrays.asList(dataPoint1, dataPoint2));

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
    public void testFeatureApplierFactory() {
        FeatureApplier feature = FeatureApplierFactory.getFeature("squareX");
        assertNotNull(feature);
        assertTrue(feature instanceof SquareFeatureApplier);
    }


    @Test
    public void testSinFeatureApplier() {
        ArrayList<Object> dataPoint1 = new ArrayList<>(
                Arrays.asList(new ArrayList<>(Arrays.asList(Math.PI/2, 3.0)), 0));
        ArrayList<Object> dataPoint2 = new ArrayList<>(
                Arrays.asList(new ArrayList<>(Arrays.asList(0.0, 5.0)), 1));
        ArrayList<ArrayList<Object>> dataset = new ArrayList<>(
                Arrays.asList(dataPoint1, dataPoint2));

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
    public void testMultiplyFeatureApplier() {
        ArrayList<Object> dataPoint1 = new ArrayList<>(
                Arrays.asList(new ArrayList<>(Arrays.asList(2.0, 3.0)), 0));
        ArrayList<Object> dataPoint2 = new ArrayList<>(
                Arrays.asList(new ArrayList<>(Arrays.asList(4.0, 5.0)), 1));
        ArrayList<ArrayList<Object>> dataset = new ArrayList<>(
                Arrays.asList(dataPoint1, dataPoint2));

        MultiplyFeatureApplier multiplyFeatureApplier = new MultiplyFeatureApplier();
        ArrayList<ArrayList<Object>> result = multiplyFeatureApplier.applyFeature(dataset);

        assertNotNull(result);
        assertEquals(2, result.size());

        ArrayList<Double> data1 = (ArrayList<Double>) result.get(0).get(0);
        assertEquals(6.0, data1.get(2));

        ArrayList<Double> data2 = (ArrayList<Double>) result.get(1).get(0);
        assertEquals(20.0, data2.get(2));
    }

    @Test
    public void testFeatureController() {
        // mock data, noise, and features
        String dataName = "circular";
        ArrayList<String> featureNames = new ArrayList<>(Arrays.asList("squareX", "sinY"));
        int noise = 10;

        ArrayList<ArrayList<Object>> result = FeatureController.createTrainingData(dataName, featureNames, noise);
        assertNotNull(result);
        assertEquals(1000, result.size());

        for(ArrayList<Object> point : result) {
            ArrayList<Double> coordinates = (ArrayList<Double>) point.get(0);

            assertEquals(4, coordinates.size());

            double x = coordinates.get(0);
            double y = coordinates.get(1);
            double squaredX = coordinates.get(2);
            double sinY = coordinates.get(3);

            assertEquals(x * x, squaredX, 1e-6);
            assertEquals(Math.sin(y), sinY, 1e-6);
        }
    }



}
