package com.playground.playground;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;

public class GraphSystemController implements Initializable {
  @FXML private NumberAxis yAxis;
  @FXML private NumberAxis xAxis;
  @FXML private ScatterChart neuralNetwork;

  /**
   * Construct the graph using the neural network.
   *
   * @param location The location used to resolve relative paths for the root object, or {@code
   *     null} if the location is not known.
   * @param resources The resources used to localize the root object, or {@code null} if the root
   *     object was not localized.
   */
  public void initialize(URL location, ResourceBundle resources) {
    //        XYChart.Series<String, Double> seriesHigh = new XYChart.Series<>();
    //        seriesHigh.getData().add(new XYChart.Data<>("SubLabel1", 20.9));
    //        seriesHigh.getData().add(new XYChart.Data<>("SubLabel2", 30.9));
    //        seriesHigh.getData().add(new XYChart.Data<>("SubLabel3", 40.9));
    //
    //        XYChart.Series<String, Double> seriesLow = new XYChart.Series<>();
    //        seriesLow.setName("Label2");
    //        seriesLow.getData().add(new XYChart.Data<>("SubSubLabel1", 10.9));
    //        seriesLow.getData().add(new XYChart.Data<>("SubSubLabel2", 25.9));
    //        seriesLow.getData().add(new XYChart.Data<>("SubSubLabel3", 32.9));
    //
    //        neuralNetwork.getData().addAll(seriesHigh, seriesLow);
  }
}
