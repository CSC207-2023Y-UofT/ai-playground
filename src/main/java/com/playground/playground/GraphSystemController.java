package com.playground.playground;


import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.primitives.Pair;


public class GraphSystemController implements Initializable {
  @FXML private ScatterChart neuralNetwork;
  @FXML private Label testLoss;
  @FXML private Label trainingLoss;



  /**
   * Construct the graph using the neural network.
   */
  public void initialize(URL location, ResourceBundle resources) {

  }

  public void setTestLoss(double testL){
    testLoss.setText("Training Loss: " + testL);
  }

  public void setTrainingLoss(double trainL){
    testLoss.setText("Test Loss: " + trainL);
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

  public void updateGraph(List<Pair<INDArray, INDArray>> dataset, ArrayList<Integer> colors) {
    // Clear the current data
    neuralNetwork.getData().clear();

    XYChart.Series<Number, Number> series = new XYChart.Series<>();

    // Add the new data
    for (int i = 0; i < dataset.size(); i++) {
      Pair<INDArray, INDArray> cluster = dataset.get(i);
      INDArray point = cluster.getKey();
      double[] coords = point.data().asDouble();
      double x = coords[0];
      double y = coords[1];

      XYChart.Data<Number, Number> data = new XYChart.Data<>(x, y);
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

      neuralNetwork.getData().add(series);
    }
  }
}
