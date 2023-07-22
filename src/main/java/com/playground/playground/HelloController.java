package com.playground.playground;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
    @FXML
    private Button stepButton;

    @FXML
    private Button playButton;

    @FXML
    private Button rewindButton;

    @FXML
    private Button clusterButton;

    @FXML
    private Button radialButton;

    @FXML
    private Button spiralButton;

    @FXML
    private Button rectangularButton;

    @FXML
    private Slider slider1;

    @FXML
    private Slider slider2;

    @FXML
    private Slider slider3;

    @FXML
    private Label slider1Percent;

    @FXML
    private Label slider2Percent;

    @FXML
    private Label slider3Percent;


    public void initialize(URL location, ResourceBundle resources) {
        // setting buttons
        setButtonWithImage(rewindButton, "playground-images/rewind-button.png");
        setButtonWithImage(playButton, "playground-images/play-button.png");
        setButtonWithImage(stepButton, "playground-images/fast-forward-button.png");
        setButtonFixedSize(clusterButton);
        setButtonFixedSize(radialButton);
        setButtonFixedSize(spiralButton);
        setButtonFixedSize(rectangularButton);

        slider1.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateSlider1Percent(slider1, slider1Percent);
        });

        slider2.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateSlider2Percent(slider2, slider2Percent);
        });

        slider3.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateSlider3Percent(slider3, slider3Percent);
        });
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


    }

    private void setButtonWithImage(Button button, String imagePath) {
        ImageView imageView = new ImageView(getClass().getResource(imagePath).toExternalForm());
        imageView.setFitWidth(40); // Adjust the width as needed
        imageView.setFitHeight(40); // Adjust the height as needed
        button.setGraphic(imageView);
        button.getStyleClass().add("image-button");
    }


    private void setButtonFixedSize(Button button) {
        button.setPrefSize(70, 50);
    }

    private void updateSlider1Percent(Slider slider, Label percentLabel) {
        double value = slider.getValue();
        double max = slider.getMax();
        double percentage = (value / max) * 100;
        long roundedPercentage = Math.round(percentage);
        percentLabel.setText(String.format("%d%%", roundedPercentage));
    }

    private void updateSlider2Percent(Slider slider, Label numberLabel) {
        int value = (int) slider.getValue();
        numberLabel.setText(String.format("%d", value));
    }

    private void updateSlider3Percent(Slider slider, Label numberLabel) {
        int value = (int) slider.getValue();
        numberLabel.setText(String.format("%d", value));
    }

    // Place other controller logic here pls
}


