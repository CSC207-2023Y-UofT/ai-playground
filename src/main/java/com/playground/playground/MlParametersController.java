package com.playground.playground;

import java.awt.*;
import java.beans.EventHandler;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import com.google.common.eventbus.DeadEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.control.MenuItem;

public class MlParametersController implements Initializable {
  @FXML private Button stepButton;

  @FXML private Button playButton;
  @FXML private Button rewindButton;
  @FXML private Text epochNumber;
  @FXML private MenuItem item1;
  @FXML private MenuItem item2;
  @FXML private MenuItem item3;
  @FXML private MenuItem item4;
  @FXML private MenuItem item5;
  @FXML private MenuItem item6;
  @FXML private MenuItem item7;
  @FXML private MenuItem item8;
  @FXML private MenuItem item9;
  @FXML private MenuItem item10;
  @FXML private MenuItem item11;
  @FXML private MenuItem item12;
  @FXML private MenuItem reLu;
  @FXML private MenuItem tanH;
  @FXML private MenuItem sigmoid;
  @FXML private MenuItem linear;


  /**
   * Initializer for MIParametersController.java
   *
   * @param location The location used to resolve relative paths for the root object, or {@code
   *     null} if the location is not known.
   * @param resources The resources used to localize the root object, or {@code null} if the root
   *     object was not localized.
   */
  public void initialize(URL location, ResourceBundle resources) {
    // setting buttons
    setButtonWithImage(rewindButton, "playground-images/rewind-button.png");
    setButtonWithImage(playButton, "playground-images/play-button.png");
    setButtonWithImage(stepButton, "playground-images/fast-forward-button.png");
    item1.setOnAction(this::handleLearn);
    item2.setOnAction(this::handleLearn);
    item3.setOnAction(this::handleLearn);
    item4.setOnAction(this::handleLearn);
    item5.setOnAction(this::handleLearn);
    item6.setOnAction(this::handleLearn);
    item7.setOnAction(this::handleLearn);
    item8.setOnAction(this::handleLearn);
    item9.setOnAction(this::handleLearn);
    item10.setOnAction(this::handleLearn);
    item11.setOnAction(this::handleLearn);
    item12.setOnAction(this::handleLearn);
    reLu.setOnAction(this::handleActivation);
    tanH.setOnAction(this::handleActivation);
    sigmoid.setOnAction(this::handleActivation);
    linear.setOnAction(this::handleActivation);
  }

  Double learningRate;
  String activation;
  public void handleActivation(ActionEvent actionEvent) {
    MenuItem selection = (MenuItem) actionEvent.getSource();
    activation = selection.getText();
    System.out.println(activation);
  }

  public void handleLearn(ActionEvent actionEvent) {
    MenuItem selection = (MenuItem) actionEvent.getSource();
    learningRate = Double.parseDouble(selection.getText());

  }






  private void setButtonWithImage(Button button, String imagePath) {
    ImageView imageView =
        new ImageView(Objects.requireNonNull(getClass().getResource(imagePath)).toExternalForm());
    imageView.setFitWidth(40); // Adjust the width as needed
    imageView.setFitHeight(40); // Adjust the height as needed
    button.setGraphic(imageView);
    button.getStyleClass().add("image-button");
  }


}
