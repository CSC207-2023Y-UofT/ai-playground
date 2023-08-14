package com.playground.playground.interface_adapter.views;

import com.playground.playground.controller.FeaturesHiddenLayersController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class FeaturesHiddenLayersView implements Initializable {
  public Label x2pow2label;
  public Label x1x2label;
  public Label x1pow2label;
  @FXML private Text numHiddenLayers;
  @FXML private Button addLayer;
  @FXML private Button removeLayer;
  @FXML private Button x1pow2button;
  @FXML private Button x2pow2button;
  @FXML private Button x1x2button;
  @FXML private Button sinx1button;
  @FXML private Button sinx2button;
  @FXML private Button add1;
  @FXML private Button remove1;
  @FXML private Button add2;
  @FXML private Button remove2;
  @FXML private Button add3;
  @FXML private Button remove3;
  @FXML private Button add4;
  @FXML private Button remove4;
  @FXML private Button add5;
  @FXML private Button remove5;
  @FXML private Button add6;
  @FXML private Button remove6;
  @FXML public GridPane neuralConnections;
  private int i = 0;
  @FXML private Label neurons1, neurons2, neurons3, neurons4, neurons5, neurons6;
  private FeaturesHiddenLayersController featuresHiddenLayersController;

  public FeaturesHiddenLayersView() {
    this.featuresHiddenLayersController = new FeaturesHiddenLayersController();
  }

  public void initialize(URL location, ResourceBundle resources) {
    Button[] newAddButtons = new Button[] {add1, add2, add3, add4, add5, add6};
    Button[] newRemoveButtons = new Button[] {remove1, remove2, remove3, remove4, remove5, remove6};
    Label[] newNeuronLabels =
        new Label[] {neurons1, neurons2, neurons3, neurons4, neurons5, neurons6};
    featuresHiddenLayersController.setButtons(newAddButtons, newRemoveButtons, newNeuronLabels);

    setButtonWithImage(
        x1pow2button, "/com/playground/playground/playground-images/x1pow2button.jpg");
    setButtonWithImage(
        x2pow2button, "/com/playground/playground/playground-images/x2pow2button.jpg");
    setButtonWithImage(x1x2button, "/com/playground/playground/playground-images/x1x2button.jpg");
    setButtonWithImage(sinx1button, "/com/playground/playground/playground-images/sinx1button.jpg");
    setButtonWithImage(sinx2button, "/com/playground/playground/playground-images/sinx2button.jpg");

    // Adding the behavior for buttons
    toggleButtonSelection(x1pow2button, "squareX");
    toggleButtonSelection(x2pow2button, "squareY");
    toggleButtonSelection(x1x2button, "XtimesY");
    toggleButtonSelection(sinx1button, "sinX");
    toggleButtonSelection(sinx2button, "sinY");

    // Set default configuration to 1 hidden layer 1 node in the UI
    onAddButtonClicked(new ActionEvent(add1, null));
    onAddLayerClicked(new ActionEvent(addLayer, null));
    // Fix internal variables
    FeaturesHiddenLayersController.numHiddenLayersAccess = 1;
    FeaturesHiddenLayersController.aButtonsCountsAccess = new int[6];
    FeaturesHiddenLayersController.aButtonsCountsAccess[0] = 1;
  }

  /**
   * Set an image to be placed over a button.
   *
   * @param button The button to set an image on.
   * @param imagePath The path to the image.
   */
  private void setButtonWithImage(Button button, String imagePath) {
    ImageView imageView = new ImageView(getClass().getResource(imagePath).toExternalForm());
    imageView.setFitWidth(35);
    imageView.setFitHeight(35);
    button.setGraphic(imageView);
    button.getStyleClass().add("image-button");
  }

  /**
   * Handles the toggling of parameter buttons, and adds them to the selectedbuttons arraylist
   *
   * @param button The button to set the behavior for.
   * @param buttonName The string representation of the button that will be stored in the arraylist
   */
  private void toggleButtonSelection(Button button, String buttonName) {
    button.setOnAction(
        event -> {
          String currentStyle = button.getStyle();
          if (currentStyle.contains("-fx-background-color: blue;")) {
            // Button was selected, unselect it
            button.setStyle("");
            // Remove the button name from the selectedButtons list
            FeaturesHiddenLayersController.selectedButtons.remove(buttonName);
          } else {
            // Button wasn't selected, select it
            button.setStyle("-fx-background-color: blue;");
            // Add the button name to the selectedButtons list
            FeaturesHiddenLayersController.selectedButtons.add(buttonName);
          }
        });
  }

  /**
   * Adds a layer to the hidden layer graph and increases the value of the layer counter by 1.
   *
   * @param event is triggered by user interaction with the add layer button.
   */
  @FXML
  private void onAddLayerClicked(ActionEvent event) {
    int currentCount = Integer.parseInt(numHiddenLayers.getText());
    if (currentCount < 6 && i < 6) {
      currentCount++;
      numHiddenLayers.setText(String.valueOf(currentCount));
      sendNumHiddenLayers();
      featuresHiddenLayersController.setButtonsVisibility(i, true);
      i++;
    }
  }

  /**
   * Removes a layer to the hidden layer graph and decreases the value of the layer counter by 1.
   *
   * @param event is triggered by user interaction with the remove layer button.
   */
  @FXML
  private void onRemoveLayerClicked(ActionEvent event) {

    int currentCount = Integer.parseInt(numHiddenLayers.getText());
    if (currentCount > 0 && i > 0) {
      currentCount--;
      numHiddenLayers.setText(String.valueOf(currentCount));
      sendNumHiddenLayers();
      featuresHiddenLayersController.setButtonsVisibility(i - 1, false);
      featuresHiddenLayersController.removeColumn(i - 1, neuralConnections);
      i--;
      featuresHiddenLayersController.onRemoveLayerClickedHelper(i);
    }
  }

  @FXML
  public void onAddButtonClicked(ActionEvent event) {
    int index = Integer.parseInt(((Button) event.getSource()).getId().substring(3)) - 1;
    featuresHiddenLayersController.onAddButtonClickedHelper(index, neuralConnections);
  }

  @FXML
  public void onRemoveButtonClicked(ActionEvent event) {
    int index = Integer.parseInt(((Button) event.getSource()).getId().substring(6)) - 1;
    featuresHiddenLayersController.onRemoveButtonClickedHelper(index, neuralConnections);
  }

  private void sendNumHiddenLayers() {
    int num = Integer.parseInt(numHiddenLayers.getText());
    featuresHiddenLayersController.setNumHiddenLayers(num);
  }
}
