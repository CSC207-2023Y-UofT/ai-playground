package com.playground.playground.interface_adapter.controller;

import java.util.ArrayList;

import com.playground.playground.interface_adapter.controller.views.DataAttributesView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

/** This controller handles all the dataset related options on the UI. */
public class DataAttributesController {
  public static int initializeTestRatio;
  public static int initializeNoise;
  public static int initializeBatchSize;
  private ArrayList<Button> listButtons = new ArrayList<>();
  private DataAttributesView view;
  public static int testRatio = 80;
  public static int batchSize = 20;
  public static int noise = 1;
  public static String dataset;

  public DataAttributesController(DataAttributesView view) {
    this.view = view;
  }
  public void initialize() {
    // Set initial values
    view.updateSlider1Percent(testRatio, 100);
    view.updateSlider2Percent(noise);
    view.updateSlider3Percent(batchSize);

    // Initialize buttons
    view.setButtonFixedSize("cluster");
    view.setButtonFixedSize("radial");
    view.setButtonFixedSize("spiral");
    view.setButtonFixedSize("rectangular");

    // Initialize button selection
    view.toggleButtonSelection("rectangular");
  }



  public long findSlider1Percent(double value, double max) {
    double percentage = (value / max) * 100;
    long roundedPercentage = Math.round(percentage);
    DataAttributesController.initializeTestRatio = (int) roundedPercentage;
    return roundedPercentage;
  }

  public String findSlider2Percent(int value) {
    DataAttributesController.initializeNoise = value;
    String stringVal = String.format("%d", value);
    return stringVal;
  }

  public String findSlider3Percent(int value) {
    DataAttributesController.initializeBatchSize = value;
    String stringVal = String.format("%d", value);
    return stringVal;
  }

  /**
   * Sets the preferred size of the given button to 70 by 50.
   *
   * @param button the button to be resized
   */
  private void setButtonFixedSize(Button button) {
    button.setPrefSize(70, 50);
  }


  public int initializeTestRatio(int testRatio) {
    DataAttributesController.initializeTestRatio = testRatio;
    return testRatio;
  }

  public int initializeNoise(int noise) {
    DataAttributesController.initializeNoise = noise;
    return noise;
  }


  public int initializeBatchSize(int batchSize) {
    DataAttributesController.initializeBatchSize = batchSize;
    return batchSize;
  }

  public void handleClusterButton() {
    DataAttributesController.dataset = "cluster";
  }

  public void handleRadialButton() {
    DataAttributesController.dataset = "circular";
  }


  public void handleSpiralButton() {
    DataAttributesController.dataset = "spiral";
  }

  public void handleRectangularButton() {
    DataAttributesController.dataset = "quadrant";
  }
}
