package com.playground.playground.usecase.feature;

import static org.junit.jupiter.api.Assertions.*;

import com.playground.playground.entity.FeatureApplier;
import com.playground.playground.entity.FeatureConstants;
import com.playground.playground.usecase.features.FeatureApplierFactory;
import com.playground.playground.usecase.features.MultiplyFeatureApplier;
import com.playground.playground.usecase.features.SinFeatureApplier;
import com.playground.playground.usecase.features.SquareFeatureApplier;
import org.junit.jupiter.api.Test;

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
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          FeatureApplierFactory.getFeature("invalidFeature");
        });
  }
}
