package com.playground.playground.interface_adapter.controller.views;
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
public class ViewFactoryImpl implements ViewFactory {
    @Override
    public DataAttributesView createDataAttributesView() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/playground/playground/data-attributes-view.fxml"));
        try {
            Node node = loader.load();
            return loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public MlParametersView createMlParametersView() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/playground/playground/ml-parameters-view.fxml"));
        try {
            Node node = loader.load();
            return loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public GraphSystemView createGraphSystemView() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/playground/playground/graph-system-view.fxml"));
        try {
            Node node = loader.load();
            return loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public FeaturesHiddenLayersView createFeaturesHiddenLayersView() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/playground/playground/features-hidden-layers-view.fxml"));
        try {
            Node node = loader.load();
            return loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

