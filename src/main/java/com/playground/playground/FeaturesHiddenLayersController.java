package com.playground.playground;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;


import java.net.URL;
import java.util.ResourceBundle;


public class FeaturesHiddenLayersController implements Initializable {
   @FXML
   private Text numHiddenLayers;
   @FXML
   private Button addLayer;
   @FXML
   private Button removeLayer;
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
   @FXML
   private Button add1;
   @FXML
   private Button remove1;
   @FXML
   private Button add2;
   @FXML
   private Button remove2;
   @FXML
   private Button add3;
   @FXML
   private Button remove3;
   @FXML
   private Button add4;
   @FXML
   private Button remove4;
   @FXML
   private Button add5;
   @FXML
   private Button remove5;
   @FXML
   private Button add6;
   @FXML
   private Button remove6;
   @FXML
   public GridPane neuralConnections;
   private Button[] addButtons;
   private Button[] removeButtons;
   private Button[][] aButtons;
   private int[] aButtonCounts;
   private int i = 0;


   @FXML
   private Label neurons1, neurons2, neurons3, neurons4, neurons5, neurons6;


   private Label[] neuronLabels;


   /**
    * Initializer for FeaturesHiddenLayersController.java
    * @param location
    * The location used to resolve relative paths for the root object, or
    * {@code null} if the location is not known.
    *
    * @param resources
    * The resources used to localize the root object, or {@code null} if
    * the root object was not localized.
    */
   public void initialize(URL location, ResourceBundle resources) {
       setButtonWithImage(x1pow2button, "playground-images/x1pow2button.jpg");
       setButtonWithImage(x2pow2button, "playground-images/x2pow2button.jpg");
       setButtonWithImage(x1x2button, "playground-images/x1x2button.jpg");
       setButtonWithImage(sinx1button, "playground-images/sinx1button.jpg");
       setButtonWithImage(sinx2button, "playground-images/sinx2button.jpg");


       addButtons = new Button[]{add1, add2, add3, add4, add5, add6};
       removeButtons = new Button[]{remove1, remove2, remove3, remove4, remove5, remove6};
       aButtons = new Button[6][8];
       aButtonCounts = new int[6];
       neuronLabels = new Label[]{neurons1, neurons2, neurons3, neurons4, neurons5, neurons6};
   }


   private void setButtonWithImage(Button button, String imagePath) {
       ImageView imageView = new ImageView(getClass().getResource(imagePath).toExternalForm());
       imageView.setFitWidth(35);
       imageView.setFitHeight(35);
       button.setGraphic(imageView);
       button.getStyleClass().add("image-button");
   }


   /**
    * Adds a layer to the hidden layer graph and increases the value of the layer counter by 1.
    * @param event is triggered by user interaction with the add layer button.
    */
   @FXML
   private void onAddLayerClicked(ActionEvent event) {
       int currentCount = Integer.parseInt(numHiddenLayers.getText());
       if (currentCount < 6 && i < 6) {
           currentCount++;
           numHiddenLayers.setText(String.valueOf(currentCount));
           setButtonsVisibility(i, true);
           i++;
       }
   }


   /**
    * Removes a layer to the hidden layer graph and decreases the value of the layer counter by 1.
    * @param event is triggered by user interaction with the remove layer button.
    */
   @FXML
   private void onRemoveLayerClicked(ActionEvent event) {
       int currentCount = Integer.parseInt(numHiddenLayers.getText());
       if (currentCount > 0 && i > 0) {
           currentCount--;
           numHiddenLayers.setText(String.valueOf(currentCount));
           setButtonsVisibility(i-1, false);
           removeColumn(i-1);
           i--;
           neuronLabels[i].setVisible(false);
           aButtonCounts[i] = 0;
       }
   }


   /**
    * Helper function for onAddLayerClicked and onRemovedLayerClicked used to make the addButtons and removeButtons visible.
    * @param index of the button to be set visible or invisible.
    * @param isVisible dictates whether button is set to be visible or invisible.
    */
   private void setButtonsVisibility(int index, boolean isVisible) {
       addButtons[index].setVisible(isVisible);
       removeButtons[index].setVisible(isVisible);
   }


   /**
    * Helper function for onRemovedLayerClicked used to remove a column as decided by the user.
    * @param index of the column to be removed.
    */
   private void removeColumn(int index) {
       for (int j = 0; j < aButtonCounts[index]; j++) {
           neuralConnections.getChildren().remove(aButtons[index][j]);
           aButtons[index][j] = null;
       }
       aButtonCounts[index] = 0;
   }


   /**
    * Helper function for onAddButtonClicked used to add a neuron to the hidden layer graph.
    * @param event is triggered by onAddLayerClicked to add a neuron at a specific index position.
    */
   @FXML
   public void onAddButtonClicked(ActionEvent event) {
       int index = Integer.parseInt(((Button) event.getSource()).getId().substring(3)) - 1;
       if (aButtonCounts[index] < 8) {
           Button newButton = new Button("Node");
           aButtons[index][aButtonCounts[index]] = newButton;
           neuralConnections.add(newButton, index, aButtonCounts[index] + 2);
           aButtonCounts[index]++;
       }


       neuronLabels[index].setText(aButtonCounts[index] + " Neurons");
       neuronLabels[index].setVisible(true);
   }


   /**
    * Helper function for onRemovedLayerClicked used to remove a neuron from the hidden layer graph.
    * @param event is triggered by onRemoveLayerClicked to remove a neuron at a specific index position.
    */
   @FXML
   public void onRemoveButtonClicked(ActionEvent event) {
       int index = Integer.parseInt(((Button) event.getSource()).getId().substring(6)) - 1;
       if (aButtonCounts[index] > 0) {
           aButtonCounts[index]--;
           neuralConnections.getChildren().remove(aButtons[index][aButtonCounts[index]]);
           aButtons[index][aButtonCounts[index]] = null;


           // Update the neuron count label
           if (aButtonCounts[index] == 0) {
               neuronLabels[index].setVisible(false);
           } else {
               neuronLabels[index].setText(aButtonCounts[index] + " Neurons");
           }
       }
   }


}
