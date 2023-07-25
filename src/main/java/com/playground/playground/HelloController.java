package com.playground.playground;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.image.ImageView;


public class HelloController implements Initializable {
    @FXML
    private CategoryAxis yAxis;
    @FXML
    private NumberAxis xAxis;
    @FXML
    private ScatterChart neuralNetwork;

    private DataAttributesController dataAttributesController;
    @FXML
    private VBox dataAttributesBox;
    private MlParametersController mlParametersController;
    @FXML
    private HBox mlParametersBox;



    public void initialize(URL location, ResourceBundle resources) {
//        // setting buttons
//        setButtonWithImage(rewindButton, "playground-images/rewind-button.png");
//        setButtonWithImage(playButton, "playground-images/play-button.png");
//        setButtonWithImage(stepButton, "playground-images/fast-forward-button.png");
//        setButtonFixedSize(clusterButton);
//        setButtonFixedSize(radialButton);
//        setButtonFixedSize(spiralButton);
//        setButtonFixedSize(rectangularButton);


        XYChart.Series<String, Double> seriesHigh = new XYChart.Series<>();
        seriesHigh.setName("Label1");
        seriesHigh.getData().add(new XYChart.Data<>("SubLabel1", 20.9));
        seriesHigh.getData().add(new XYChart.Data<>("SubLabel2", 30.9));
        seriesHigh.getData().add(new XYChart.Data<>("SubLabel3", 40.9));

        XYChart.Series<String, Double> seriesLow = new XYChart.Series<>();
        seriesLow.setName("Label2");
        seriesLow.getData().add(new XYChart.Data<>("SubSubLabel1", 10.9));
        seriesLow.getData().add(new XYChart.Data<>("SubSubLabel2", 25.9));
        seriesLow.getData().add(new XYChart.Data<>("SubSubLabel3", 32.9));

        neuralNetwork.getData().addAll(seriesHigh, seriesLow);

        FXMLLoader dataattloader = new FXMLLoader(getClass().getResource("data-attributes-view.fxml"));
        try {
            dataAttributesBox = dataattloader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dataAttributesController = dataattloader.getController();
        dataAttributesController.initialize(location, resources);

        FXMLLoader mlparamloader = new FXMLLoader(getClass().getResource("ml-parameters-view.fxml"));
        try {
            mlParametersBox = mlparamloader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mlParametersController = mlparamloader.getController();
        mlParametersController.initialize(location, resources);


    }


}


