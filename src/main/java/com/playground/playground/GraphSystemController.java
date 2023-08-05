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


  /**
   * Construct the graph using the neural network.
   */
  public void initialize(URL location, ResourceBundle resources) {

  }
  /**
   * Updates the graph with a new dataset.
   *
   * The method first clears the current data in the graph, and then adds the new data. Each cluster is added as a new
   * series in the graph.
   *
   * @param dataset The new dataset to display in the graph.
   */


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
