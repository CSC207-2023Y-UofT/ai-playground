package com.playground.playground.interface_adapter.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.playground.playground.interface_adapter.controller.views.MainView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Node;
public class MainViewController implements Initializable, MainView {
    @FXML private VBox dataAttributesBox;
    @FXML private HBox mlParametersBox;
    @FXML private VBox graphSystemBox;
    @FXML private VBox featuresHiddenLayersBox;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void setMlParametersBox(Node node) {
        mlParametersBox.getChildren().add(node);
    }

    @Override
    public void setDataAttributesBox(Node node) {
        dataAttributesBox.getChildren().add(node);
    }
    @Override
    public void setGraphSystemBox(Node node) {
        graphSystemBox.getChildren().add(node);
    }

    @Override
    public void setFeaturesHiddenLayersBox(Node node) {
        featuresHiddenLayersBox.getChildren().add(node);
    }
}
