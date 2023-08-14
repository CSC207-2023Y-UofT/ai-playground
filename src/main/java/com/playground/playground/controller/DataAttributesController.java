package com.playground.playground.controller;


/** This controller handles all the dataset related options on the UI. */
public class DataAttributesController {
  // ... (fields and constants)
  public static int initializeTestRatio;
  public static int initializeNoise;
  public static int initializeBatchSize;

  public static int testRatio = 80;
  public static int batchSize = 20;
  public static int noise = 1;
  public static String dataset;

  /**
   * Calculates the percentage value based on the provided slider value and maximum.
   *
   * @param value The current value of the slider.
   * @param max   The maximum value of the slider.
   * @return The rounded percentage value.
   */
  public long setSlider1Percent(double value, double max) {
    double percentage = (value / max) * 100;
    long roundedPercentage = Math.round(percentage);
    DataAttributesController.initializeTestRatio = (int) roundedPercentage;
    return roundedPercentage;
  }

  /**
   * Sets the noise percentage value and returns it as a formatted string.
   *
   * @param value The new value of the noise slider.
   * @return The noise value as a formatted string.
   */
  public String setSlider2Percent(int value) {
    DataAttributesController.initializeNoise = value;
    String stringVal = String.format("%d", value);
    return stringVal;
  }

  /**
   * Sets the batch size value and returns it as a formatted string.
   *
   * @param value The new value of the batch size slider.
   * @return The batch size value as a formatted string.
   */
  public String setSlider3Percent(int value) {
    DataAttributesController.initializeBatchSize = value;
    String stringVal = String.format("%d", value);
    return stringVal;
  }

  /**
   * Initializes the test ratio with the given value.
   *
   * @param newRatio The new test ratio value.
   * @return The initialized test ratio.
   */
  public int initializeTestRatio(int newRatio) {
    testRatio = newRatio;
    DataAttributesController.initializeTestRatio = testRatio;
    return testRatio;
  }

  /**
   * Initializes the noise value with the given value.
   *
   * @param newNoise The new noise value.
   * @return The initialized noise value.
   */
  public int initializeNoise(int newNoise) {
    noise = newNoise;
    DataAttributesController.initializeNoise = noise;
    return noise;
  }

  /**
   * Initializes the batch size value with the given value.
   *
   * @param newBatchSize The new batch size value.
   * @return The initialized batch size value.
   */
  public int initializeBatchSize(int newBatchSize) {
    batchSize = newBatchSize;
    DataAttributesController.initializeBatchSize = newBatchSize;
    return batchSize;
  }

}
