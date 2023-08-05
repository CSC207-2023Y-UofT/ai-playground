package com.playground.playground.modelling;

import com.playground.playground.data.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FeatureTest {

    /**
     * This tests the SquareFeatureApplier to ensure the correct points are being squared and appended correctly
     */
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

    /**
     * checks that the feature applier is working properly
     */
    @Test
    public void testFeatureApplierFactory() {
        FeatureApplier feature = FeatureApplierFactory.getFeature("squareX");
        assertNotNull(feature);
        assertTrue(feature instanceof SquareFeatureApplier);
    }

    /**
     * This tests the SinFeatureApplier to ensure the correct points are being Sin and appended correctly
     */
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

    /**
     * This tests the MultiplyFeatureApplier to ensure the correct points are being multiplied and appended correctly
     */
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

    /**
     * This tests the FeatureController to ensure there are the correct number of Blue and Orange point, and that
     * the proper Features are being applied correctly.
     */
    @Test
    public void testFeatureController() {
        String dataName = "circular";
        int data_size = 2000;
        ArrayList<String> featureNames = new ArrayList<>(Arrays.asList("squareX", "sinY"));
        int noise = 10;

        ArrayList<ArrayList<Object>> result = FeatureController.createTrainingData(dataName, featureNames, noise);
        assertNotNull(result);

        // If dataGenerator produces 1000 Blue and 1000 Orange points
        int rnd_points = data_size/noise;
        assertEquals(result.size(), data_size + rnd_points);

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
    /**
     * This tests the FeatureController when there are no features. Checks correct number of Blue and Orange points,
     * and that no extra features are being applied.
     */
    @Test
    public void testFeatureControllerNoFeatures() {
        // mock data, no features
        int data_size = 2000;
        String dataName = "circular";
        ArrayList<String> featureNames = new ArrayList<>();
        int noise = 10;
        ArrayList<ArrayList<Object>> result = FeatureController.createTrainingData(dataName, featureNames, noise);

        assertNotNull(result);
        int rnd_points = data_size/noise;
        assertEquals(result.size(), data_size + rnd_points);

        for(ArrayList<Object> point : result) {
            ArrayList<Double> coordinates = (ArrayList<Double>) point.get(0);
            assertEquals(2, coordinates.size());
        }
    }



}
