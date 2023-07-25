package com.playground.playground;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class FeaturesHiddenLayersController implements Initializable {
    @FXML
    private Button x1button;
    @FXML
    private Button x2button;
    @FXML
    private Button x1pow2button;
    @FXML
    private Button x2pow2button;
    @FXML
    private Button x1x2button;
    @FXML
    private Button sinx1button;
    @FXML
    private Button sinx2button;

    public void initialize(URL location, ResourceBundle resources) {
        setButtonWithImage(x1button, "playground-images/x1button.jpg");
        setButtonWithImage(x2button, "playground-images/x2button.jpg");
        setButtonWithImage(x1pow2button, "playground-images/x1pow2button.jpg");
        setButtonWithImage(x2pow2button, "playground-images/x2pow2button.jpg");
        setButtonWithImage(x1x2button, "playground-images/x1x2button.jpg");
        setButtonWithImage(sinx1button, "playground-images/sinx1button.jpg");
        setButtonWithImage(sinx2button, "playground-images/sinx2button.jpg");
    }

    // method which takes two parameters, button and string (the image path), and sets the button with the
    // corresponding image
    private void setButtonWithImage(Button button, String imagePath) {
        ImageView imageView = new ImageView(getClass().getResource(imagePath).toExternalForm());
        imageView.setFitWidth(35);
        imageView.setFitHeight(35);
        button.setGraphic(imageView);
        button.getStyleClass().add("image-button");
    }
}
