package com.playground.playground;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class HelloController {
    @FXML
    private Button stepButton;

    @FXML
    private Button playButton;

    @FXML
    private Button rewindButton;

    public void initialize() {
        setButtonWithCircleAndText(stepButton, Color.BLUE, "Step");
        setButtonWithCircleAndText(playButton, Color.BLUE, "Play");
        setButtonWithCircleAndText(rewindButton, Color.BLUE, "Rewind");
    }

    private void setButtonWithCircleAndText(Button button, Color color, String text) {
        Circle circle = new Circle(20); // Adjust the radius as needed
        circle.setFill(color);
        button.setGraphic(circle);
        button.setText(text);
        button.getStyleClass().add("circle-button");
    }

    // Your controller logic goes here...
}


