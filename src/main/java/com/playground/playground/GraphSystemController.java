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
   * series in the graph. Then, it sets the colours of the points
   *
   * @param dataset The new dataset to display in the graph.
   * @param colors An ArrayList of 0's or 1's corresponding to the colour of the points on the dataset.
   */

  public void updateGraph(ArrayList<ArrayList<ArrayList<Double>>> dataset, ArrayList<Integer> colors) {
    // Clear the current data
    neuralNetwork.getData().clear();

    // Add the new data
    for (int i = 0; i < dataset.size(); i++) {
      ArrayList<ArrayList<Double>> cluster = dataset.get(i);
      XYChart.Series<Number, Number> series = new XYChart.Series<>();
      ArrayList<Double> x = cluster.get(0);
      ArrayList<Double> y = cluster.get(1);
      for (int j = 0; j < x.size(); j++) {
        XYChart.Data<Number, Number> data = new XYChart.Data<>(x.get(j), y.get(j));
        series.getData().add(data);
        // Change the color of the data point based on the color value
        int finalI = i;
        data.nodeProperty().addListener((ov, oldNode, newNode) -> {
          if (newNode != null) {
            if (colors.get(finalI) == 1) {
              newNode.setStyle("-fx-background-color: blue;");
            } else {
              newNode.setStyle("-fx-background-color: green;");
            }
          }
        });
      }
      neuralNetwork.getData().add(series);
    }
  }
}
