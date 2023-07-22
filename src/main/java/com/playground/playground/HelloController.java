package com.playground.playground;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class HelloController {
    @FXML
    private StackPane stepCircle;

    @FXML
    private StackPane playCircle;

    @FXML
    private StackPane rewindCircle;

    public void initialize() {
        Circle stepCircleShape = createCircle(Color.BLUE);
        Circle playCircleShape = createCircle(Color.BLUE);
        Circle rewindCircleShape = createCircle(Color.BLUE);

        setCircleWithText(stepCircle, stepCircleShape, "Step");
        setCircleWithText(playCircle, playCircleShape, "Play");
        setCircleWithText(rewindCircle, rewindCircleShape, "Rewind");
    }

    private Circle createCircle(Color color) {
        Circle circle = new Circle(20);
        circle.setFill(color);
        return circle;
    }

    private void setCircleWithText(StackPane stackPane, Circle circle, String text) {
        Label label = new Label(text);
        label.setTextFill(Color.WHITE);
        stackPane.getChildren().addAll(circle, label);

    }

    // Place controller logic here
}
