package com.playground.playground.interface_adapter.controller;

import com.playground.playground.interface_adapter.controller.views.DataAttributesView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DataAttributesViewController implements Initializable, DataAttributesView {
    @FXML
    private VBox root;
    @FXML private Slider slider1;
    @FXML private Slider slider2;
    @FXML private Slider slider3;

    @FXML private Label slider1label;
    @FXML private Label slider2label;
    @FXML private Label slider3label;

    @FXML private Button clusterButton;
    @FXML private Button radialButton;
    @FXML private Button spiralButton;
    @FXML private Button rectangularButton;
    private ArrayList<Button> listButtons = new ArrayList<>();
    private DataAttributesController dataAttributesController;
    public void setDataAttributesController(DataAttributesController controller) {
        this.dataAttributesController = controller;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dataAttributesController.initialize();
        slider1.setValue(DataAttributesController.testRatio);
        slider1
                .valueProperty()
                .addListener(
                        (observable, oldValue, newValue) -> {
                            updateSlider1Percent(slider1.getValue(), slider1.getMax());
                        });
        // Set noise slider to default value
        slider2.setValue(DataAttributesController.noise);
        slider2
                .valueProperty()
                .addListener(
                        (observable, oldValue, newValue) -> {
                            updateSlider2Percent((int) slider2.getValue());
                        });
        // Set batch size slider to default value
        slider3.setValue(DataAttributesController.batchSize);
        slider3
                .valueProperty()
                .addListener(
                        (observable, oldValue, newValue) -> {
                            updateSlider3Percent((int) slider3.getValue());
                        });

    }
    @Override
    public Node getNode() {
        return root;
    }


    @Override
    public void updateSlider1Percent(double value, double max) {
        slider1label.setText("Ratio of training to test data: " + dataAttributesController.findSlider1Percent(value, max) + "%");
    }

    @Override
    public void updateSlider2Percent(int value) {
        slider2label.setText("Noise: " + dataAttributesController.findSlider2Percent(value));
    }

    @Override
    public void updateSlider3Percent(int value) {
        slider3label.setText("Batch size: " + dataAttributesController.findSlider3Percent(value));
    }

    @Override
    public void setButtonFixedSize(String buttonType) {
        getButtonById(buttonType).setPrefSize(70, 50);
    }

    @Override
    public void toggleButtonSelection(String button) {
        getButtonById(button).setOnAction(
                event -> {
                    for (Button btn : listButtons) {
                        btn.setStyle("");
                    }
                    getButtonById(button).setStyle("-fx-background-color: lightblue;");
                    if (getButtonById(button) == clusterButton) {
                        handleClusterButton(new javafx.event.ActionEvent(null, null));
                    } else if (getButtonById(button) == rectangularButton) {
                        handleRectangularButton(new javafx.event.ActionEvent(null, null));
                    } else if (getButtonById(button) == radialButton) {
                        handleRadialButton(new javafx.event.ActionEvent(null, null));
                    } else if (getButtonById(button) == spiralButton) {
                        handleSpiralButton(new ActionEvent(null, null));
                    }
                });
    }

    @Override
    public void handleClusterButton(ActionEvent actionEvent) {
        dataAttributesController.handleClusterButton();
    }

    @Override
    public void handleRadialButton(ActionEvent actionEvent) {
        dataAttributesController.handleRadialButton();
    }

    @Override
    public void handleSpiralButton(ActionEvent actionEven) {
        dataAttributesController.handleSpiralButton();
    }

    @Override
    public void handleRectangularButton(ActionEvent actionEven) {
        dataAttributesController.handleRectangularButton();
    }

    @Override
    public void initializeTestRatio(MouseEvent mouseEvent) {
       int testRatio = (int) slider1.getValue();
        dataAttributesController.initializeTestRatio(testRatio);
    }

    @Override
    public void initializeNoise(MouseEvent mouseEvent) {
        int noise = (int) slider2.getValue();
        dataAttributesController.initializeNoise(noise);
    }

    @Override
    public void initializeBatchSize(MouseEvent mouseEvent) {
        int batchSize = (int) slider3.getValue();
        dataAttributesController.initializeBatchSize(batchSize);
    }

    private Button getButtonById(String buttonType) {
        switch (buttonType) {
            case "cluster": return clusterButton;
            case "radial": return radialButton;
            case "spiral": return spiralButton;
            case "rectangular": return rectangularButton;
            default: throw new IllegalArgumentException("Unknown button type: " + buttonType);
        }
    }

}
