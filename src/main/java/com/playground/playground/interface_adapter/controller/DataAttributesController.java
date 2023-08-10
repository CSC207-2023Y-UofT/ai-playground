package com.playground.playground.interface_adapter.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

/** This controller handles all the dataset related options on the UI. */
public class DataAttributesController implements Initializable {
  public static int initializeTestRatio;
  public static int initializeNoise;
  public static int initializeBatchSize;
  @FXML private Slider slider1;

  @FXML private Slider slider2;

  @FXML private Slider slider3;

  @FXML private Label slider1label;

  @FXML private Label slider2label;

  @FXML private Label slider3label;
  @FXML private Button clusterButton;

  @FXML private Button radialButton;

  @FXML private Button spiralButton;

  @FXML private Button rectangularButton;
  private ArrayList<Button> listButtons = new ArrayList<>();


  public static int testRatio = 80;
  public static int batchSize = 20;
  public static int noise = 1;
  public static String dataset = "cluster";

  /**
   * Initializer for DataAttributesController.java
   *
   * @param location The location used to resolve relative paths for the root object, or {@code
   *     null} if the location is not known.
   * @param resources The resources used to localize the root object, or {@code null} if the root
   *     object was not localized.
   */
  public void initialize(URL location, ResourceBundle resources) {
    //Set testRatio slider to default value
    slider1.setValue(testRatio);
    updateSlider1Percent(slider1, slider1label);
    slider1
        .valueProperty()
        .addListener(
            (observable, oldValue, newValue) -> {
              updateSlider1Percent(slider1, slider1label);
            });
    //Set noise slider to default value
    slider2.setValue(noise);
    updateSlider2Percent(slider2, slider2label);
    slider2
        .valueProperty()
        .addListener(
            (observable, oldValue, newValue) -> {
              updateSlider2Percent(slider2, slider2label);
            });
    //Set batchsize slider to default value
    slider3.setValue(batchSize);
    updateSlider3Percent(slider3, slider3label);
    slider3
        .valueProperty()
        .addListener(
            (observable, oldValue, newValue) -> {
              updateSlider3Percent(slider3, slider3label);
            });

    setButtonFixedSize(clusterButton);
    setButtonFixedSize(radialButton);
    setButtonFixedSize(spiralButton);
    setButtonFixedSize(rectangularButton);
    listButtons.add(clusterButton);
    listButtons.add(radialButton);
    listButtons.add(spiralButton);
    listButtons.add(rectangularButton);

    // Adding the behavior for buttons
    toggleButtonSelection(clusterButton);
    toggleButtonSelection(radialButton);
    toggleButtonSelection(spiralButton);
    toggleButtonSelection(rectangularButton);
    //Show cluster dataset as default
    clusterButton.setStyle("-fx-background-color: lightblue;");
  }

  private void toggleButtonSelection(Button button) {
    button.setOnAction(
            event -> {
              for(Button btn : listButtons) {
                btn.setStyle("");
              }
              button.setStyle("-fx-background-color: lightblue;");
            });
  }

  /**
   * Slider for users to adjust the ratio of training to test data percentage.
   *
   * @param slider allows user to adjust the ratio of training to test data percentage.
   * @param percentLabel displays the percent selected by the user using slider.
   */
  private void updateSlider1Percent(Slider slider, Label percentLabel) {
    double value = slider.getValue();
    double max = slider.getMax();
    double percentage = (value / max) * 100;
    long roundedPercentage = Math.round(percentage);
    DataAttributesController.initializeTestRatio = (int) roundedPercentage;
    percentLabel.setText("Ratio of training to test data: " + roundedPercentage + "%");
  }

  /**
   * Slider for users to adjust the noise.
   *
   * @param slider allows user to adjust the noise.
   * @param numberLabel displays the noise value selected by the using the slider.
   */
  private void updateSlider2Percent(Slider slider, Label numberLabel) {
    int value = (int) slider.getValue();
    DataAttributesController.initializeNoise = value;
    String stringVal = String.format("%d", value);
    numberLabel.setText("Noise: " + stringVal);
  }

  /**
   * Slider for users to adjust the batch size.
   *
   * @param slider allows user to adjust the batch size.
   * @param numberLabel displays the batch size value selected by the using the slider.
   */
  private void updateSlider3Percent(Slider slider, Label numberLabel) {
    int value = (int) slider.getValue();
    DataAttributesController.initializeBatchSize = value;
    String stringVal = String.format("%d", value);
    numberLabel.setText("Batch size: " + stringVal);
  }

  /**
   * Sets the preferred size of the given button to 70 by 50.
   *
   * @param button the button to be resized
   */
  private void setButtonFixedSize(Button button) {
    button.setPrefSize(70, 50);
  }

  /**
   * Initializes the test ratio value from the slider and updates the corresponding attribute in
   * DataAttributesController.
   *
   * @param mouseEvent the event triggered by the mouse
   * @return the initialized test ratio
   */
  public int initializeTestRatio(MouseEvent mouseEvent) {
    testRatio = (int) slider1.getValue();
    DataAttributesController.initializeTestRatio = testRatio;
    return testRatio;
  }

  /**
   * Initializes the noise value from the slider and updates the corresponding attribute in
   * DataAttributesController.
   *
   * @param mouseEvent the event triggered by the mouse
   * @return the initialized noise value
   */
  public int initializeNoise(MouseEvent mouseEvent) {
    noise = (int) slider2.getValue();
    DataAttributesController.initializeNoise = noise;
    return noise;
  }

  /**
   * Initializes the batch size value from the slider and updates the corresponding attribute in
   * DataAttributesController.
   *
   * @param mouseEvent the event triggered by the mouse
   * @return the initialized batch size
   */
  public int initializeBatchSize(MouseEvent mouseEvent) {
    batchSize = (int) slider3.getValue();
    DataAttributesController.initializeBatchSize = batchSize;
    return batchSize;
  }

  /**
   * Handles the action event when the "cluster" button is clicked, setting the dataset to
   * "cluster".
   *
   * @param actionEvent the action event triggered by the button
   */
  public void handleCLusterButton(ActionEvent actionEvent) {
    dataset = "cluster";

  }

  /**
   * Handles the action event when the "circular" button is clicked, setting the dataset to
   * "circular".
   *
   * @param actionEvent the action event triggered by the button
   */
  public void handleRadialButton(ActionEvent actionEvent) {
    dataset = "circular";
  }

  /**
   * Handles the action event when the "spiral" button is clicked, setting the dataset to "spiral".
   *
   * @param actionEvent the action event triggered by the button
   */
  public void handleSpiralButton(ActionEvent actionEvent) {
    dataset = "spiral";
  }

  /**
   * Handles the action event when the "quadrant" button is clicked, setting the dataset to
   * "quadrant".
   *
   * @param actionEvent the action event triggered by the button
   */
  public void handleRectangularButton(ActionEvent actionEvent) {
    dataset = "quadrant";
  }
}
