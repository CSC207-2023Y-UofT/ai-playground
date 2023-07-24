package com.playground.playground;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import java.net.URL;
import java.util.ResourceBundle;

public class DataAttributesController implements Initializable {
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

    public void initialize(URL location, ResourceBundle resources){

        slider1.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateSlider1Percent(slider1, slider1Percent);
        });

        slider2.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateSlider2Percent(slider2, slider2Percent);
        });

        slider3.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateSlider3Percent(slider3, slider3Percent);
        });

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
}
