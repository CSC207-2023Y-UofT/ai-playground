package com.playground.playground.usecase.feature;

import static org.junit.jupiter.api.Assertions.*;

import com.playground.playground.entity.FeatureApplier;
import com.playground.playground.entity.FeatureConstants;
import com.playground.playground.usecase.features.FeatureApplierFactory;
import com.playground.playground.usecase.features.MultiplyFeatureApplier;
import com.playground.playground.usecase.features.SinFeatureApplier;
import com.playground.playground.usecase.features.SquareFeatureApplier;
import org.junit.jupiter.api.Test;

/**
 * Test class for FeatureApplierFactory.
 */
public class FeatureApplierFactoryTest {

  /**
   * Tests the factory method for SquareFeatureApplier with SQUARE_X constant.
   */
  // Modify this test to use a constant for "squareX"
  @Test
  public void testSquareFeatureApplierFactory() {
    FeatureApplier feature = FeatureApplierFactory.getFeature(FeatureConstants.SQUARE_X);
    assertNotNull(feature);
    assertTrue(feature instanceof SquareFeatureApplier);
  }
  /**
   * Tests the factory method for SquareFeatureApplier with SQUARE_Y constant.
   */
  @Test
  public void testSquareYFeatureApplierFactory() {
    FeatureApplier feature = FeatureApplierFactory.getFeature(FeatureConstants.SQUARE_Y);
    assertNotNull(feature);
    assertTrue(feature instanceof SquareFeatureApplier);
  }

  /**
   * Tests the factory method for MultiplyFeatureApplier with X_TIMES_Y constant.
   */
  @Test
  public void testMultiplyFeatureApplierFactory() {
    FeatureApplier feature = FeatureApplierFactory.getFeature(FeatureConstants.X_TIMES_Y);
    assertNotNull(feature);
    assertTrue(feature instanceof MultiplyFeatureApplier);
  }
  /**
   * Tests the factory method for SinFeatureApplier with SIN_X constant.
   */
  @Test
  public void testSinXFeatureApplierFactory() {
    FeatureApplier feature = FeatureApplierFactory.getFeature(FeatureConstants.SIN_X);
    assertNotNull(feature);
    assertTrue(feature instanceof SinFeatureApplier);
  }
  /**
   * Tests the factory method for SinFeatureApplier with SIN_Y constant.
   */
  @Test
  public void testSinFeatureApplierFactory() {
    FeatureApplier feature = FeatureApplierFactory.getFeature(FeatureConstants.SIN_Y);
    assertNotNull(feature);
    assertTrue(feature instanceof SinFeatureApplier);
  }
  /**
   * Tests the factory method with an invalid feature string.
   */
  @Test
  public void testGetInvalidFeature() {
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          FeatureApplierFactory.getFeature("invalidFeature");
        });
  }
}
