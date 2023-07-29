package com.playground.playground;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class DataAttributesController implements Initializable {
    @FXML
    private Slider slider1;

    @FXML
    private Slider slider2;

    @FXML
    private Slider slider3;

    @FXML
    private Label slider1label;

    @FXML
    private Label slider2label;

    @FXML
    private Label slider3label;
    @FXML
    private Button clusterButton;

    @FXML
    private Button radialButton;

    @FXML
    private Button spiralButton;

    @FXML
    private Button rectangularButton;

    public void initialize(URL location, ResourceBundle resources) {

        slider1.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateSlider1Percent(slider1, slider1label);
        });

        slider2.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateSlider2Percent(slider2, slider2label);
        });

        slider3.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateSlider3Percent(slider3, slider3label);
        });

        setButtonFixedSize(clusterButton);
        setButtonFixedSize(radialButton);
        setButtonFixedSize(spiralButton);
        setButtonFixedSize(rectangularButton);

//        setButtonWithImage(clusterButton, "playground-images/circle.jpg");
//        setButtonWithImage(radialButton, "playground-images/gauss.jpg");
//        setButtonWithImage(spiralButton, "playground-images/xor.jpg");
//        setButtonWithImage(rectangularButton, "playground-images/spiral.jpg");

    }

    private void setButtonWithImage(Button button, String imagePath) {
        ImageView imageView = new ImageView(Objects.requireNonNull(getClass().getResource(imagePath)).toExternalForm());
        button.setGraphic(imageView);
        button.getStyleClass().add("image-button");
    }


    private void updateSlider1Percent(Slider slider, Label percentLabel) {
        double value = slider.getValue();
        double max = slider.getMax();
        double percentage = (value / max) * 100;
        long roundedPercentage = Math.round(percentage);
        percentLabel.setText("Ratio of training to test data: " + roundedPercentage + "%");
    }

    private void updateSlider2Percent(Slider slider, Label numberLabel) {
        int value = (int) slider.getValue();
        String stringVal = String.format("%d", value);
        numberLabel.setText("Noise: " + stringVal);
    }

    private void updateSlider3Percent(Slider slider, Label numberLabel) {
        int value = (int) slider.getValue();
        String stringVal = String.format("%d", value);
        numberLabel.setText("Batch size: " + stringVal);
    }

    private void setButtonFixedSize(Button button) {
        button.setPrefSize(70, 50);
    }
}
