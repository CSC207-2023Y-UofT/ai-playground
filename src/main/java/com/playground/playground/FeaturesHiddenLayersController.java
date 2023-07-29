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

    private void setButtonsVisibility(int index, boolean isVisible) {
        addButtons[index].setVisible(isVisible);
        removeButtons[index].setVisible(isVisible);
    }

    private void removeColumn(int index) {
        for (int j = 0; j < aButtonCounts[index]; j++) {
            neuralConnections.getChildren().remove(aButtons[index][j]);
            aButtons[index][j] = null;
        }
        aButtonCounts[index] = 0;
    }

    @FXML
    public void onAddButtonClicked(ActionEvent event) {
        int index = Integer.parseInt(((Button) event.getSource()).getId().substring(3)) - 1;
        if (aButtonCounts[index] < 8) {
            Button newButton = new Button("neuron");
            aButtons[index][aButtonCounts[index]] = newButton;
            neuralConnections.add(newButton, index, aButtonCounts[index] + 2);
            aButtonCounts[index]++;
        }

        neuronLabels[index].setText(aButtonCounts[index] + " Neurons");
        neuronLabels[index].setVisible(true);
    }

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

