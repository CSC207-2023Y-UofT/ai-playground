package com.playground.playground.feature;

import static com.playground.playground.interface_adapter.controller.FeatureController.createTrainingData;
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

public class FeatureControllerTest {
    @Test
    public void testFeatureController() {
        String dataName = "circular";
        int data_size = 1000;
        ArrayList<String> featureNames = new ArrayList<>(Arrays.asList("squareX", "sinY"));
        int noise = 10;

        List<Pair<INDArray, INDArray>> result =
                FeatureController.createTrainingData(dataName, featureNames, noise);
        assertNotNull(result);

        int rnd_points = 10 * noise;
        assertTrue(result.size() >= data_size + rnd_points);

        for (Pair<INDArray, INDArray> point : result) {
            INDArray coordinates = point.getKey();
            double x = coordinates.getDouble(0);
            double y = coordinates.getDouble(1);
            double squaredX = coordinates.getDouble(2);
            double sinY = coordinates.getDouble(3);

            assertEquals(4, coordinates.size(1));
            assertEquals(x * x, squaredX, 0.0001);
            assertEquals(Math.sin(y), sinY, 0.0001);
        }
    }

    @Test
    public void testFeatureControllerNoFeatures() {
        int data_size = 1000;
        String dataName = "circular";
        ArrayList<String> featureNames = new ArrayList<>();
        int noise = 10;
        List<Pair<INDArray, INDArray>> result =
                FeatureController.createTrainingData(dataName, featureNames, noise);

        assertNotNull(result);
        int rnd_points = 10 * noise;
        assertTrue(result.size() >= data_size + rnd_points);

        for (Pair<INDArray, INDArray> point : result) {
            INDArray coordinates = point.getKey();
            assertEquals(2, coordinates.size(1));
        }
    }
}
