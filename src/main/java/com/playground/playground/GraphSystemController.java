package com.playground.playground;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;

public class GraphSystemController implements Initializable {
  @FXML private ScatterChart neuralNetwork;
  private DataService dataService;

  /**
   * Construct the graph using the neural network.
   *
   * @param location The location used to resolve relative paths for the root object, or {@code
   *     null} if the location is not known.
   * @param resources The resources used to localize the root object, or {@code null} if the root
   *     object was not localized.
   */
  public void initialize(URL location, ResourceBundle resources) {
    // Get the DataService instance
    dataService = DataService.getInstance();

    // Add a listener to the dataset property in the data service
    dataService.datasetProperty().addListener(new ChangeListener<ArrayList<ArrayList<ArrayList<Double>>>>() {
      @Override
      public void changed(ObservableValue<? extends ArrayList<ArrayList<ArrayList<Double>>>> observable, ArrayList<ArrayList<ArrayList<Double>>> oldValue, ArrayList<ArrayList<ArrayList<Double>>> newValue) {
        updateGraph(newValue);
      }
    });
  }

  public void updateGraph(ArrayList<ArrayList<ArrayList<Double>>> dataset) {
    // Clear the current data
    neuralNetwork.getData().clear();

    // Add the new data
    for (ArrayList<ArrayList<Double>> cluster : dataset) {
      XYChart.Series<Number, Number> series = new XYChart.Series<>();
      ArrayList<Double> x = cluster.get(0);
      ArrayList<Double> y = cluster.get(1);
      for (int i = 0; i < x.size(); i++) {
        series.getData().add(new XYChart.Data<Number, Number>(x.get(i), y.get(i)));
      }
      neuralNetwork.getData().add(series);
    }
  }
}

