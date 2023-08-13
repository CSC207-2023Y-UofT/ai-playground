package com.playground.playground.feature;

import com.playground.playground.entity.FeatureApplier;
import com.playground.playground.entity.FeatureConstants;
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

import static org.junit.jupiter.api.Assertions.*;

public class FeatureApplierFactoryTest {

    // Modify this test to use a constant for "squareX"
    @Test
    public void testSquareFeatureApplierFactory() {
        FeatureApplier feature = FeatureApplierFactory.getFeature(FeatureConstants.SQUARE_X);
        assertNotNull(feature);
        assertTrue(feature instanceof SquareFeatureApplier);
    }

    @Test
    public void testSquareYFeatureApplierFactory() {
        FeatureApplier feature = FeatureApplierFactory.getFeature(FeatureConstants.SQUARE_Y);
        assertNotNull(feature);
        assertTrue(feature instanceof SquareFeatureApplier);
    }

    // Additional tests calling all the constants
    @Test
    public void testMultiplyFeatureApplierFactory() {
        FeatureApplier feature = FeatureApplierFactory.getFeature(FeatureConstants.X_TIMES_Y);
        assertNotNull(feature);
        assertTrue(feature instanceof MultiplyFeatureApplier);
    }

    @Test
    public void testSinXFeatureApplierFactory() {
        FeatureApplier feature = FeatureApplierFactory.getFeature(FeatureConstants.SIN_X);
        assertNotNull(feature);
        assertTrue(feature instanceof SinFeatureApplier);
    }

    @Test
    public void testSinFeatureApplierFactory() {
        FeatureApplier feature = FeatureApplierFactory.getFeature(FeatureConstants.SIN_Y);
        assertNotNull(feature);
        assertTrue(feature instanceof SinFeatureApplier);
    }

    @Test
    public void testGetInvalidFeature() {
        assertThrows(IllegalArgumentException.class, () -> {
            FeatureApplierFactory.getFeature("invalidFeature");
        });
    }

}

