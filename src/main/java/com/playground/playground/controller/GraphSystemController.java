package com.playground.playground.controller;

import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.primitives.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for updating the ScatterChart with new data points and colors.
 */
public class GraphSystemController {

    /**
     * Updates the ScatterChart with new data points and colors.
     *
     * @param dataset The list of data clusters (pairs of INDArray points and labels).
     * @param colors  An ArrayList of color values corresponding to each data point.
     * @param neuralNetwork The ScatterChart component to be updated.
     * @param seriesBlue The series for data points with color value >= 0.5.
     * @param seriesGreen The series for data points with color value < 0.5.
     * @return An array containing the updated series for blue and green data points.
     */
    public XYChart.Series<Number, Number>[] updateGraphHelper(List<Pair<INDArray, INDArray>> dataset, ArrayList<Double> colors, ScatterChart neuralNetwork, XYChart.Series<Number, Number> seriesBlue, XYChart.Series<Number, Number> seriesGreen) {

      // Add the new data
      for (int i = 0; i < dataset.size(); i++) {
          Pair<INDArray, INDArray> cluster = dataset.get(i);
          INDArray point = cluster.getKey();
          double[] coords = point.data().asDouble();
          double x = coords[0];
          double y = coords[1];

          Circle dot = new Circle(2);

          XYChart.Data<Number, Number> data = new XYChart.Data<>(x, y);
          data.setNode(dot); // Set the node

          // Change the color of the data point based on the color value
          if (colors.get(i) >= 0.5) {
              dot.setFill(Color.BLUE);
              seriesBlue.getData().add(data);
          } else {
              dot.setFill(Color.GREEN);
              seriesGreen.getData().add(data);
          }

      }
      return new XYChart.Series[]{seriesBlue, seriesGreen};
  }
}

