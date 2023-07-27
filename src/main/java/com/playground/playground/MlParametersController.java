package com.playground.playground;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Duration;

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
    Timeline epochTimer;
    int mil;
    int sec;
    int min;
    int hr;

    public void initialize(URL location, ResourceBundle resources) {
        // setting buttons
        setButtonWithImage(rewindButton, "playground-images/rewind-button.png");
        setButtonWithImage(playButton, "playground-images/play-button.png");
        setButtonWithImage(stepButton, "playground-images/fast-forward-button.png");
        epochTimer = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                update(epochNumber);
            }
        }));

        epochTimer.setCycleCount(Timeline.INDEFINITE);
        epochTimer.setAutoReverse(false);

        playButton.setOnAction(this::startCode);
        rewindButton.setOnAction(this::resetCode);
    }

    private void setButtonWithImage(Button button, String imagePath) {
        ImageView imageView = new ImageView(Objects.requireNonNull(getClass().getResource(imagePath)).toExternalForm());
        imageView.setFitWidth(40); // Adjust the width as needed
        imageView.setFitHeight(40); // Adjust the height as needed
        button.setGraphic(imageView);
        button.getStyleClass().add("image-button");
    }

    public void startCode(ActionEvent e){
        epochTimer.play();
        playButton.setOnAction(e2 -> startAgain(e2));
    }

    public void startAgain(ActionEvent e2) {
        epochTimer.pause();
        playButton.setOnAction(e -> startCode(e));
    }

    public void resetCode(ActionEvent e){
        epochTimer.stop();
        mil = 0;
        epochNumber.setText("000,000");
    }

    void update (Text epochNumber){
        epochNumber.setText(String.valueOf(mil));
    }

}


