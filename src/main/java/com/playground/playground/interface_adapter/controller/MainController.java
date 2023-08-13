package com.playground.playground.interface_adapter.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.playground.playground.interface_adapter.controller.views.MainView;
import com.playground.playground.interface_adapter.controller.views.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/** The MainController class is responsible for assimilating values from other controllers. */
public class MainController {
  private final MainView mainView;
  private final ViewFactory viewFactory;

  public MainController(MainView mainView, ViewFactory viewFactory) {
    this.mainView = mainView;
    this.viewFactory = viewFactory;
  }

  public void initialize() {
    mainView.setMlParametersBox(viewFactory.createMlParametersView().getNode());
    mainView.setDataAttributesBox(viewFactory.createDataAttributesView().getNode());
    mainView.setGraphSystemBox(viewFactory.createGraphSystemView().getNode());
    mainView.setFeaturesHiddenLayersBox(viewFactory.createFeaturesHiddenLayersView().getNode());
  }
}
