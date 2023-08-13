package com.playground.playground.interface_adapter.controller.views;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;


public interface DataAttributesView {
    Node getNode();
    void updateSlider1Percent(double value, double max);
    void updateSlider2Percent(int value);
    void updateSlider3Percent(int value);
    void setButtonFixedSize(String buttonType);
    void toggleButtonSelection(String button);
    void handleClusterButton(ActionEvent actionEvent);
    void handleRadialButton(ActionEvent actionEvent);
    void handleSpiralButton(ActionEvent actionEvent);
    void handleRectangularButton(ActionEvent actionEvent);
    void initializeTestRatio(MouseEvent mouseEvent);
    void initializeNoise(MouseEvent mouseEvent);
    void initializeBatchSize(MouseEvent mouseEvent);
}
