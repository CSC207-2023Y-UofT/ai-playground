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
