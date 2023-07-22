package com.playground.playground;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class HelloController {
    @FXML
    private Label stepCircle;

    @FXML
    private Label playCircle;

    @FXML
    private Label rewindCircle;

    public void initialize() {
        Circle stepCircleShape = createCircle(Color.BLUE);
        Circle playCircleShape = createCircle(Color.BLUE);
        Circle rewindCircleShape = createCircle(Color.BLUE);

        stepCircle.setGraphic(stepCircleShape);
        playCircle.setGraphic(playCircleShape);
        rewindCircle.setGraphic(rewindCircleShape);
    }

    private Circle createCircle(Color color) {
        Circle circle = new Circle(20); // Adjust the radius as needed
        circle.setFill(color);
        return circle;
    }

    // Your controller logic goes here...
}
