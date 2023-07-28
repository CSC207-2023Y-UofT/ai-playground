package com.playground.playground;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MlParametersController implements Initializable {
    @FXML
    private Button stepButton;

    @FXML
    private Button playButton;
    @FXML
    private Button rewindButton;
    @FXML
    private Text epochNumber;

    public void initialize(URL location, ResourceBundle resources) {
        // setting buttons
        setButtonWithImage(rewindButton, "playground-images/rewind-button.png");
        setButtonWithImage(playButton, "playground-images/play-button.png");
        setButtonWithImage(stepButton, "playground-images/fast-forward-button.png");
    }

    private void setButtonWithImage(Button button, String imagePath) {
        ImageView imageView = new ImageView(Objects.requireNonNull(getClass().getResource(imagePath)).toExternalForm());
        imageView.setFitWidth(40); // Adjust the width as needed
        imageView.setFitHeight(40); // Adjust the height as needed
        button.setGraphic(imageView);
        button.getStyleClass().add("image-button");
    }

}


