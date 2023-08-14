package com.playground.playground.interface_adapter.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for FeaturesHiddenLayersController. This class provides JUnit tests for methods in the
 * FeaturesHiddenLayersController that don't directly interact with JavaFX components.
 */
class FeaturesHiddenLayersControllerTest {

  /** Instance of the controller to be tested. */
  private FeaturesHiddenLayersController controller;

  /** Set up method that initializes the controller instance before each test. */
  @BeforeEach
  void setUp() {
    controller = new FeaturesHiddenLayersController();
  }

  /**
   * Test for the setNumHiddenLayers method. Tests if the number of hidden layers is correctly set.
   */
  @Test
  void testSetNumHiddenLayers() {
    controller.setNumHiddenLayers(3);
    assertEquals(3, FeaturesHiddenLayersController.numHiddenLayersAccess);
  }

  /** Test for the setLayersNeurons method. Tests if the neurons in each layer are correctly set. */
  @Test
  void testSetLayersNeurons() {
    FeaturesHiddenLayersController.aButtonsCountsAccess = new int[] {3, 4, 5};
    FeaturesHiddenLayersController.numHiddenLayersAccess = 3;

    FeaturesHiddenLayersController.setLayersNeurons();

    assertEquals(3, FeaturesHiddenLayersController.layersNeurons.size());
    assertEquals(3, FeaturesHiddenLayersController.layersNeurons.get(0));
    assertEquals(4, FeaturesHiddenLayersController.layersNeurons.get(1));
    assertEquals(5, FeaturesHiddenLayersController.layersNeurons.get(2));
  }
}
