package com.playground.playground.interface_adapter.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.playground.playground.interface_adapter.controller.DataAttributesController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Tests class to validate the functionality of DataAttributesController. */
public class DataAttributesControllerTest {
  int min;
  int max;

  private DataAttributesController controller;

  @BeforeEach
  public void setUp() {
    controller = new DataAttributesController();
  }

  /** Tests setSlider1Percent in DataAttributesController to check test ratio values. */
  @Test
  public void testSetSlider1Percent() {
    min = 0;
    max = 100;
    double value = min + (int) (Math.random() * (max - min) + 1);
    long expected = (long) value;
    long actual = controller.setSlider1Percent(value, max);
    assertEquals(expected, actual);
    assertEquals(expected, DataAttributesController.initializeTestRatio);
  }

  /** Tests setSlider2Percent in DataAttributesController to check test noise values. */
  @Test
  public void testSetSlider2Percent() {
    min = 0;
    max = 50;
    int value = min + (int) (Math.random() * (max - min) + 1);
    String expected = String.valueOf(value);
    String actual = controller.setSlider2Percent(value);
    assertEquals(expected, actual);
    assertEquals(value, DataAttributesController.initializeNoise);
  }

  /** Tests setSlider1Percent in DataAttributesController to check batch size values. */
  @Test
  public void testSetSlider3Percent() {
    min = 0;
    max = 30;
    int value = min + (int) (Math.random() * (max - min) + 1);
    String expected = String.valueOf(value);
    String actual = controller.setSlider3Percent(value);
    assertEquals(expected, actual);
    assertEquals(value, DataAttributesController.initializeBatchSize);
  }

  /** Tests initializeTestRatio in DataAttributesController to check test ratio values. */
  @Test
  public void testInitializeTestRatio() {
    min = 0;
    max = 100;
    int newRatio = min + (int) (Math.random() * (max - min) + 1);
    int actual = controller.initializeTestRatio(newRatio);
    assertEquals(newRatio, actual);
    assertEquals(newRatio, DataAttributesController.initializeTestRatio);
  }

  /** Tests initializeNoise in DataAttributesController to check noise values. */
  @Test
  public void testInitializeNoise() {
    min = 0;
    max = 50;
    int newNoise = min + (int) (Math.random() * (max - min) + 1);
    int actual = controller.initializeNoise(newNoise);
    assertEquals(newNoise, actual);
    assertEquals(newNoise, DataAttributesController.initializeNoise);
  }

  /** Tests initializeBatchSize in DataAttributesController to check batch size values. */
  @Test
  public void testInitializeBatchSize() {
    min = 0;
    max = 30;
    int newBatchSize = min + (int) (Math.random() * (max - min) + 1);
    int actual = controller.initializeBatchSize(newBatchSize);
    assertEquals(newBatchSize, actual);
    assertEquals(newBatchSize, DataAttributesController.initializeBatchSize);
  }
}
