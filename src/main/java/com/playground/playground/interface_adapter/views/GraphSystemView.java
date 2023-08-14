package com.playground.playground.interface_adapter.views;

import com.playground.playground.DataService;
import com.playground.playground.controller.GraphSystemController;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.primitives.Pair;

public class GraphSystemView implements Initializable {
  @FXML private ScatterChart neuralNetwork;
  @FXML private Label testLoss;
  @FXML private Label trainingLoss;
  private DataService dataService;

  private GraphSystemController graphSystemController;

  public GraphSystemView() {
    this.graphSystemController = new GraphSystemController();
  }

  /** Construct the graph using the neural network. */
  public void initialize(URL location, ResourceBundle resources) {
    // Setting the legend as not visible
    neuralNetwork.setLegendVisible(false);
    // Get the DataService instance
    dataService = DataService.getInstance();

    // Add a listener to the dataset property in the data service
    dataService
        .datasetProperty()
        .addListener(
            new ChangeListener<List<Pair<INDArray, INDArray>>>() {
              @Override
              public void changed(
                  ObservableValue<? extends List<Pair<INDArray, INDArray>>> observable,
                  List<Pair<INDArray, INDArray>> oldValue,
                  List<Pair<INDArray, INDArray>> newValue) {
                updateGraph(newValue, dataService.getResults());
              }
            });

    // Add a listener to the results property in the data service
    dataService
        .resultsProperty()
        .addListener(
            new ChangeListener<ArrayList<Double>>() {
              @Override
              public void changed(
                  ObservableValue<? extends ArrayList<Double>> observable,
                  ArrayList<Double> oldValue,
                  ArrayList<Double> newValue) {
                updateGraph(dataService.getDataset(), newValue);
              }
            });
    // Add a listener to the trainScore property in the data service
    dataService
        .trainScoreProperty()
        .addListener(
            new ChangeListener<Number>() {
              @Override
              public void changed(
                  ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                setTrainingLoss(newValue.doubleValue());
              }
            });

    // Add a listener to the testScore property in the data service
    dataService
        .testScoreProperty()
        .addListener(
            new ChangeListener<Number>() {
              @Override
              public void changed(
                  ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                setTestLoss(newValue.doubleValue());
              }
            });
  }

  /**
   * Sets the test loss value on the UI, rounded to three decimal places.
   *
   * @param testL The test loss value to be displayed.
   */
  public void setTestLoss(double testL) {
    Platform.runLater(
        () -> {
          String roundedValue = String.format("%.3f", testL);
          testLoss.setText(roundedValue);
        });
  }

  /**
   * Sets the training loss value on the UI, rounded to three decimal places.
   *
   * @param trainL The training loss value to be displayed.
   */
  public void setTrainingLoss(double trainL) {
    Platform.runLater(
        () -> {
          String roundedValue = String.format("%.3f", trainL);
          trainingLoss.setText(roundedValue);
        });
  }

  /**
   * Updates the graph with a new dataset.
   *
   * <p>The method first clears the current data in the graph, and then adds the new data. Each
   * cluster is added as a new series in the graph. Then, it sets the colours of the points
   *
   * @param dataset The new dataset to display in the graph.
   * @param colors An ArrayList of 0's or 1's corresponding to the colour of the points on the
   *     dataset.
   */
  public void updateGraph(List<Pair<INDArray, INDArray>> dataset, ArrayList<Double> colors) {
    Platform.runLater(
        () -> {
          System.out.println("Colors: " + colors);
          // Clear the current data
          neuralNetwork.getData().clear();
          System.out.println("Updating graph...");
          // Create series for each unique color
          XYChart.Series<Number, Number> seriesBlue = new XYChart.Series<>();
          XYChart.Series<Number, Number> seriesGreen = new XYChart.Series<>();

          XYChart.Series[] series =
              graphSystemController.updateGraphHelper(
                  dataset, colors, neuralNetwork, seriesBlue, seriesGreen);
          series[0] = seriesBlue;
          series[1] = seriesGreen;
          // Add the series to the chart
          neuralNetwork.getData().addAll(seriesBlue, seriesGreen);
          System.out.println("Updated graph");
        });
  }
}
