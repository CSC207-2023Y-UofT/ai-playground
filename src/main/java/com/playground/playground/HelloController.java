package com.playground.playground;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class HelloController {
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


    public void initialize() {
        setButtonWithCircleAndText(stepButton, Color.BLUE, "Step");
        setButtonWithCircleAndText(playButton, Color.BLUE, "Play");
        setButtonWithCircleAndText(rewindButton, Color.BLUE, "Rewind");
        setButtonFixedSize(clusterButton);
        setButtonFixedSize(radialButton);
        setButtonFixedSize(spiralButton);
        setButtonFixedSize(rectangularButton);
        slider1.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateSliderPercent(slider1, slider1Percent);
        });

        slider2.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateSliderPercent(slider2, slider2Percent);
        });

        slider3.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateSliderPercent(slider3, slider3Percent);
        });

    }

    private void setButtonWithCircleAndText(Button button, Color color, String text) {
        Circle circle = new Circle(20); // Adjust the radius as needed
        circle.setFill(color);
        button.setGraphic(circle);
        button.setText(text);
        button.getStyleClass().add("circle-button");
    }

    private void setButtonFixedSize(Button button) {
        button.setPrefSize(70, 50);
    }

    private void updateSliderPercent(Slider slider, Label percentLabel) {
        double value = slider.getValue();
        double max = slider.getMax();
        double percentage = (value / max) * 100;
        percentLabel.setText(String.format("%.2f%%", percentage));
    }

    // Place other controller logic here pls
}


