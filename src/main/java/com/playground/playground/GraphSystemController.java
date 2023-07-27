package com.playground.playground;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class GraphSystemController implements Initializable {
    @FXML
    private NumberAxis yAxis;
    @FXML
    private NumberAxis xAxis;
    @FXML
    private ScatterChart neuralNetwork;

    public void initialize(URL location, ResourceBundle resources) {
        XYChart.Series<Double, Double> seriesHigh = new XYChart.Series<>();
        seriesHigh.setName("Label1");
        seriesHigh.getData().add(new XYChart.Data<>(20.9, 20.9));
        seriesHigh.getData().add(new XYChart.Data<>(30.9, 30.9));
        seriesHigh.getData().add(new XYChart.Data<>(40.9, 40.9));

        XYChart.Series<Double, Double> seriesLow = new XYChart.Series<>();
        seriesLow.setName("Label2");
        seriesLow.getData().add(new XYChart.Data<>(10.9, 10.9));
        seriesLow.getData().add(new XYChart.Data<>(25.9, 25.9));
        seriesLow.getData().add(new XYChart.Data<>(32.9, 32.9));

        neuralNetwork.getData().addAll(seriesHigh, seriesLow);
    }
}
