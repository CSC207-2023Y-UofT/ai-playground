package com.playground.playground.interface_adapter.controller;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/** This controller is responsible for handling data related to the hidden layers and features. */
public class FeaturesHiddenLayersController {
  private Button[] addButtons;
  private Button[] removeButtons;
  private Button[][] aButtons;
  private int[] aButtonCounts;
  private int i = 0;

  private Label[] neuronLabels;

  public static ArrayList<String> selectedButtons = new ArrayList<>();
  public static List<Integer> layersNeurons = new ArrayList<>();

  public static Button[][] aButtonsAccess;
  public static int[] aButtonsCountsAccess;
  public static int numHiddenLayersAccess;

  public void setButtons(Button[] newAddButtons, Button[] newRemoveButtons, Label[] newNeuronLabels) {
    addButtons = newAddButtons;
    removeButtons = newRemoveButtons;
    aButtons = new Button[6][8];
    aButtonsAccess = new Button[6][8];
    aButtonCounts = new int[6];
    aButtonsCountsAccess = new int[6];
    neuronLabels = new Label[newNeuronLabels.length];
    System.arraycopy(newNeuronLabels, 0, neuronLabels, 0, newNeuronLabels.length);
  }


  /**
   * @return A list of the selected buttons.
   */
  public static ArrayList<String> getSelectedButtons() {
    return FeaturesHiddenLayersController.selectedButtons;
  }


  public void onRemoveLayerClickedHelper(int i) {
    neuronLabels[i].setVisible(false);
    aButtonCounts[i] = 0;
    aButtonsCountsAccess[i] = 0;
  }

  /**
   * Helper function for onAddLayerClicked and onRemovedLayerClicked used to make the addButtons and
   * removeButtons visible.
   *
   * @param index of the button to be set visible or invisible.
   * @param isVisible dictates whether button is set to be visible or invisible.
   */
  public void setButtonsVisibility(int index, boolean isVisible) {
    addButtons[index].setVisible(isVisible);
    removeButtons[index].setVisible(isVisible);
  }


  /**
   * Helper function for onRemovedLayerClicked used to remove a column as decided by the user.
   *
   * @param index of the column to be removed.
   */
  public void removeColumn(int index, GridPane neuralConnections) {
    for (int j = 0; j < aButtonCounts[index]; j++) {
      neuralConnections.getChildren().remove(aButtons[index][j]);
      aButtons[index][j] = null;
      aButtonsAccess[index][j] = null;
    }
    aButtonCounts[index] = 0;
    aButtonsCountsAccess[index] = 0;
  }

  public void onAddButtonClickedHelper(int index, GridPane neuralConnections) {
    if (aButtonCounts[index] < 8) {
      Button newButton = new Button("Node");
      aButtons[index][aButtonCounts[index]] = newButton;
      aButtonsAccess[index][aButtonsCountsAccess[index]] = newButton;
      neuralConnections.add(newButton, index, aButtonCounts[index] + 2);
      aButtonCounts[index]++;
      aButtonsCountsAccess[index]++;
    }

    neuronLabels[index].setText(aButtonCounts[index] + " Neurons");
    neuronLabels[index].setVisible(true);
  }

  public void onRemoveButtonClickedHelper(int index, GridPane neuralConnections) {
    if (aButtonCounts[index] > 0) {
      aButtonCounts[index]--;
      aButtonsCountsAccess[index]--;
      neuralConnections.getChildren().remove(aButtons[index][aButtonCounts[index]]);
      aButtons[index][aButtonCounts[index]] = null;
      aButtonsAccess[index][aButtonsCountsAccess[index]] = null;

      // Update the neuron count label
      if (aButtonCounts[index] == 0) {
        neuronLabels[index].setVisible(false);
      } else {
        neuronLabels[index].setText(aButtonCounts[index] + " Neurons");
      }
    }
  }

  /** Parse and set the number of hidden layers. */
  public void setNumHiddenLayers(int num) {
    numHiddenLayersAccess = num;
  }

  public static void setLayersNeurons() {
    List<Integer> layerNeurons = new ArrayList<>();
    int numberHiddenLayers = numHiddenLayersAccess; // Correct do not change.
    for (int i = 0; i < numberHiddenLayers; i++) {
      layerNeurons.add(aButtonsCountsAccess[i]);
    }
    layersNeurons = layerNeurons;
  }

  /**
   * @return A List of the Neural Network architecture
   */
  public static List<Integer> getLayersNeurons() {
    return layersNeurons;
  }
}
