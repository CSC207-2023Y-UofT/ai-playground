package com.playground.playground;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FeaturesHiddenLayersController implements Initializable{
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
    public GridPane neuralConnections;
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

    public void initialize(URL location, ResourceBundle resources) {
        setButtonWithImage(x1pow2button, "playground-images/x1pow2button.jpg");
        setButtonWithImage(x2pow2button, "playground-images/x2pow2button.jpg");
        setButtonWithImage(x1x2button, "playground-images/x1x2button.jpg");
        setButtonWithImage(sinx1button, "playground-images/sinx1button.jpg");
        setButtonWithImage(sinx2button, "playground-images/sinx2button.jpg");

    }

    // Method which takes two parameters, button and string (the image path), and sets the button with the
    // corresponding image
    private void setButtonWithImage(Button button, String imagePath) {
        ImageView imageView = new ImageView(getClass().getResource(imagePath).toExternalForm());
        imageView.setFitWidth(35);
        imageView.setFitHeight(35);
        button.setGraphic(imageView);
        button.getStyleClass().add("image-button");
    }
    int i = 0;

    @FXML
    private void onAddLayerClicked(ActionEvent event) {
        int currentCount = Integer.parseInt(numHiddenLayers.getText());
        if (currentCount < 6 && i < 6) {
            currentCount++;
            numHiddenLayers.setText(String.valueOf(currentCount));
            if (i >= 0){
                add1.setVisible(true);
                remove1.setVisible(true);
            }
            if (i >= 1) {
                add2.setVisible(true);
                remove2.setVisible(true);
            }
            if (i >= 2) {
                add3.setVisible(true);
                remove3.setVisible(true);
            }
            if (i >= 3) {
                add4.setVisible(true);
                remove4.setVisible(true);
            }
            if (i >= 4) {
                add5.setVisible(true);
                remove5.setVisible(true);
            }
            if (i >= 5) {
                add6.setVisible(true);
                remove6.setVisible(true);
            }
            addButton(i);
            i++;
        }
    }

    @FXML
    private void onRemoveLayerClicked(ActionEvent event) {
        int currentCount = Integer.parseInt(numHiddenLayers.getText());
        if (currentCount > 0 && i > 0) {
            currentCount--;
            numHiddenLayers.setText(String.valueOf(currentCount));
            if (i > 0){
                add1.setVisible(false);
                remove1.setVisible(false);
            }
            if (i > 1) {
                add2.setVisible(false);
                remove2.setVisible(false);
            }
            if (i > 2) {
                add3.setVisible(false);
                remove3.setVisible(false);
            }
            if (i > 3) {
                add4.setVisible(false);
                remove4.setVisible(false);
            }
            if (i > 4) {
                add5.setVisible(false);
                remove5.setVisible(false);
            }
            if (i > 5) {
                add6.setVisible(false);
                remove6.setVisible(false);
            }
            removeButton(i);
            i--;
        }
    }

    @FXML
    public void addButton(int i){
        int j = 1;
        Button newLayer = new Button("a");
        neuralConnections.add(newLayer, i, j, 1, 1);
    }
    @FXML
    public void removeButton(int i){
        int j = 1;
        neuralConnections.getChildren().removeIf(Button -> GridPane.getColumnIndex(Button) == i && GridPane.getRowIndex(Button) == j);
    }


}
