package com.playground.playground.interface_adapter.views;

import com.playground.playground.controller.DataAttributesController;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

/** This class represents the UI view for handling data attributes. */
public class DataAttributesView implements Initializable {
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
  public DataAttributesController dataAttributesController;
  private ArrayList<Button> listButtons = new java.util.ArrayList<>();

  /**
   * Initializes the DataAttributesView by setting default values, listeners, and behaviors.
   *
   * @param location The location used to resolve relative paths.
   * @param resources The resources used to localize the root object.
   */
  public void initialize(URL location, ResourceBundle resources) {
    dataAttributesController = new DataAttributesController();
    // Set testRatio slider to default value
    slider1.setValue(DataAttributesController.testRatio);
    updateSlider1Percent(slider1, slider1label);
    slider1
        .valueProperty()
        .addListener(
            (observable, oldValue, newValue) -> {
              updateSlider1Percent(slider1, slider1label);
            });
    // Set noise slider to default value
    slider2.setValue(DataAttributesController.noise);
    updateSlider2Percent(slider2, slider2label);
    slider2
        .valueProperty()
        .addListener(
            (observable, oldValue, newValue) -> {
              updateSlider2Percent(slider2, slider2label);
            });
    // Set batchsize slider to default value
    slider3.setValue(DataAttributesController.batchSize);
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

    clusterButton.setStyle("-fx-background-color: lightblue;");
    handleCLusterButton(new ActionEvent(null, null)); // Call the handler to set the dataset
  }

  /**
   * Toggles the selection of the provided button and updates the styles of all buttons.
   *
   * @param button The button whose selection needs to be toggled.
   */
  private void toggleButtonSelection(Button button) {
    button.setOnAction(
        event -> {
          for (Button btn : listButtons) {
            btn.setStyle("");
          }
          button.setStyle("-fx-background-color: lightblue;");
          if (button == clusterButton) {
            handleCLusterButton(new ActionEvent(null, null));
          } else if (button == rectangularButton) {
            handleRectangularButton(new ActionEvent(null, null));
          } else if (button == radialButton) {
            handleRadialButton(new ActionEvent(null, null));
          } else if (button == spiralButton) {
            handleSpiralButton(new ActionEvent(null, null));
          }
        });
  }

  /**
   * Updates the label showing the slider1 percentage based on the slider value.
   *
   * @param slider The slider for which the percentage needs to be updated.
   * @param percentLabel The label displaying the percentage value.
   */
  private void updateSlider1Percent(Slider slider, Label percentLabel) {
    double value = slider.getValue();
    double max = slider.getMax();
    percentLabel.setText(
        "Ratio of training to test data: "
            + dataAttributesController.setSlider1Percent(value, max)
            + "%");
  }

  /**
   * Updates the label showing the slider2 percentage based on the slider value.
   *
   * @param slider The slider for which the percentage needs to be updated.
   * @param numberLabel The label displaying the number value.
   */
  private void updateSlider2Percent(Slider slider, Label numberLabel) {
    int value = (int) slider.getValue();
    numberLabel.setText("Noise: " + dataAttributesController.setSlider2Percent(value));
  }

  /**
   * Updates the label showing the slider3 percentage based on the slider value.
   *
   * @param slider The slider for which the percentage needs to be updated.
   * @param numberLabel The label displaying the number value.
   */
  private void updateSlider3Percent(Slider slider, Label numberLabel) {
    int value = (int) slider.getValue();
    numberLabel.setText("Batch size: " + dataAttributesController.setSlider3Percent(value));
  }

  /**
   * Sets a fixed size for the provided button.
   *
   * @param button The button for which the size needs to be fixed.
   */
  private void setButtonFixedSize(Button button) {
    button.setPrefSize(70, 50);
  }

  /**
   * Sends the test ratio value to the data attributes controller upon a mouse event.
   *
   * @param mouseEvent The mouse event triggering this action.
   */
  public void sendTestRatio(MouseEvent mouseEvent) {
    int ratio = (int) slider1.getValue();
    dataAttributesController.initializeTestRatio(ratio);
  }

  /**
   * Sends the noise value to the data attributes controller upon a mouse event.
   *
   * @param mouseEvent The mouse event triggering this action.
   */
  public void sendNoise(MouseEvent mouseEvent) {
    dataAttributesController.initializeNoise((int) slider2.getValue());
  }

  /**
   * Sends the batch size value to the data attributes controller upon a mouse event.
   *
   * @param mouseEvent The mouse event triggering this action.
   */
  public void sendBatchSize(MouseEvent mouseEvent) {
    dataAttributesController.initializeBatchSize((int) slider3.getValue());
  }

  /**
   * Handles the action event when the "cluster" button is clicked, setting the dataset to
   * "cluster".
   *
   * @param actionEvent the action event triggered by the button
   */
  public void handleCLusterButton(ActionEvent actionEvent) {
    DataAttributesController.dataset = "cluster";
  }

  /**
   * Handles the action event when the "circular" button is clicked, setting the dataset to
   * "circular".
   *
   * @param actionEvent the action event triggered by the button
   */
  public void handleRadialButton(ActionEvent actionEvent) {
    DataAttributesController.dataset = "circular";
  }

  /**
   * Handles the action event when the "spiral" button is clicked, setting the dataset to "spiral".
   *
   * @param actionEvent the action event triggered by the button
   */
  public void handleSpiralButton(ActionEvent actionEvent) {
    DataAttributesController.dataset = "spiral";
  }

  /**
   * Handles the action event when the "quadrant" button is clicked, setting the dataset to
   * "quadrant".
   *
   * @param actionEvent the action event triggered by the button
   */
  public void handleRectangularButton(ActionEvent actionEvent) {
    DataAttributesController.dataset = "quadrant";
  }
}
