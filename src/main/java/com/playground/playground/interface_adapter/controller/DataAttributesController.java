package com.playground.playground.interface_adapter.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.playground.playground.interface_adapter.viewmodel.DataAttributesViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.beans.binding.Bindings;
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
  public static String dataset;
  private DataAttributesViewModel viewModel = new DataAttributesViewModel();
  /**
   * Initializer for DataAttributesController.java
   *
   * @param location The location used to resolve relative paths for the root object, or {@code
   *     null} if the location is not known.
   * @param resources The resources used to localize the root object, or {@code null} if the root
   *     object was not localized.
   */
  public void initialize(URL location, ResourceBundle resources) {
    testRatio = 80;
    batchSize = 20;
    noise = 1;
    dataset = "cluster";
    viewModel.setDataset("cluster");
    initializeTestRatio = testRatio; // Initialize static variable
    initializeBatchSize = batchSize; // Initialize static variable
    initializeNoise = noise;         // Initialize static variable

    slider1.valueProperty().bindBidirectional(viewModel.testRatio);
    slider2.valueProperty().bindBidirectional(viewModel.noise);
    slider3.setMin(1);
    slider3.valueProperty().bindBidirectional(viewModel.batchSize);

    // Explicitly set the values to trigger the listeners
    viewModel.setTestRatio(testRatio);
    viewModel.setNoise(noise);
    viewModel.setBatchSize(batchSize);
    viewModel.setDataset(dataset);

    // Bind the labels to the ViewModel properties
    slider1label.textProperty().bind(viewModel.testRatioLabel);
    slider2label.textProperty().bind(viewModel.noiseLabel);
    slider3label.textProperty().bind(viewModel.batchSizeLabel);

    setButtonFixedSize(clusterButton);
    setButtonFixedSize(radialButton);
    setButtonFixedSize(spiralButton);
    setButtonFixedSize(rectangularButton);
    listButtons.add(clusterButton);
    listButtons.add(radialButton);
    listButtons.add(spiralButton);
    listButtons.add(rectangularButton);
    bindButtonStyleToSelectedDataset(clusterButton, "cluster");
    bindButtonStyleToSelectedDataset(radialButton, "circular");
    bindButtonStyleToSelectedDataset(spiralButton, "spiral");
    bindButtonStyleToSelectedDataset(rectangularButton, "quadrant");
  }

  private void bindButtonStyleToSelectedDataset(Button button, String datasetName) {
    button.styleProperty().bind(Bindings.when(viewModel.selectedDataset.isEqualTo(datasetName))
            .then("-fx-background-color: lightblue;")
            .otherwise(""));
    button.setOnAction(event -> viewModel.selectDataset(datasetName));
  }

  /**
   * Sets the preferred size of the given button to 70 by 50.
   *
   * @param button the button to be resized
   */
  private void setButtonFixedSize(Button button) {
    button.setPrefSize(70, 50);
  }

}
