package com.playground.playground;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class FeaturesHiddenLayersController implements Initializable {
  @FXML private Text numHiddenLayers;
  @FXML private Button addLayer;
  @FXML private Button removeLayer;
  @FXML private Button x1button;
  @FXML private Button x2button;
  @FXML private Button x1pow2button;
  @FXML private Button x2pow2button;
  @FXML private Button x1x2button;
  @FXML private Button sinx1button;
  @FXML private Button sinx2button;
  @FXML public GridPane neuralConnections;

  public void initialize(URL location, ResourceBundle resources) {
    setButtonWithImage(x1button, "playground-images/x1button.jpg");
    setButtonWithImage(x2button, "playground-images/x2button.jpg");
    setButtonWithImage(x1pow2button, "playground-images/x1pow2button.jpg");
    setButtonWithImage(x2pow2button, "playground-images/x2pow2button.jpg");
    setButtonWithImage(x1x2button, "playground-images/x1x2button.jpg");
    setButtonWithImage(sinx1button, "playground-images/sinx1button.jpg");
    setButtonWithImage(sinx2button, "playground-images/sinx2button.jpg");
  }

  // Method which takes two parameters, button and string (the image path), and sets the button with
  // the
  // corresponding image
  private void setButtonWithImage(Button button, String imagePath) {
    ImageView imageView = new ImageView(getClass().getResource(imagePath).toExternalForm());
    imageView.setFitWidth(35);
    imageView.setFitHeight(35);
    button.setGraphic(imageView);
    button.getStyleClass().add("image-button");
  }

  int i = 1;

  @FXML
  private void onAddLayerClicked(ActionEvent event) {
    int currentCount = Integer.parseInt(numHiddenLayers.getText());
    if (currentCount < 6) {
      currentCount++;
      numHiddenLayers.setText(String.valueOf(currentCount));
      addButton(i);
      i++;
    }
  }

  @FXML
  private void onRemoveLayerClicked(ActionEvent event) {
    int currentCount = Integer.parseInt(numHiddenLayers.getText());
    if (currentCount > 0) {
      currentCount--;
      numHiddenLayers.setText(String.valueOf(currentCount));
    }
  }

  @FXML
  public void addButton(int i) {
    int j = 1;
    Button newLayer = new Button("APPLE");
    neuralConnections.add(newLayer, i, j, j, j);
  }
}
