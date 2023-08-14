package com.playground.playground.interface_adapter.views;

import com.playground.playground.DataService;
import com.playground.playground.controller.MlParametersController;
import com.playground.playground.interface_adapter.modelling.ModelTrainingServices;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 * The view class that handles the interaction between UI components and the backend logic related
 * to model parameters and training.
 */
public class MlParametersView implements Initializable {

  // JavaFX Components
  @FXML private Button playButton;
  @FXML private Button rewindButton;
  @FXML private Text epochNumber;
  @FXML private MenuItem learn2;
  @FXML private MenuItem learn3;
  @FXML private MenuItem learn4;
  @FXML private MenuItem learn5;
  @FXML private MenuItem learn6;
  @FXML private MenuItem learn7;
  @FXML private MenuItem learn8;
  @FXML private MenuItem learn9;
  @FXML private MenuItem learn10;
  @FXML private MenuItem learn11;
  @FXML private MenuItem learn12;
  @FXML private MenuItem reLu;
  @FXML private MenuItem tanH;
  @FXML private MenuItem sigmoid;
  @FXML private MenuItem softMax;
  @FXML private MenuItem none;
  @FXML private MenuItem l1;
  @FXML private MenuItem l2;
  @FXML private MenuItem reg1;
  @FXML private MenuItem reg2;
  @FXML private MenuItem reg3;
  @FXML private MenuItem reg4;
  @FXML private MenuItem reg5;
  @FXML private MenuItem reg6;
  @FXML private MenuItem reg7;
  @FXML private MenuItem reg8;
  @FXML private MenuItem reg9;
  @FXML private MenuItem reg10;
  @FXML private MenuItem classify;
  @FXML private MenuItem regress;
  @FXML private Label learn;
  @FXML private Label active;
  @FXML private Label reg;
  @FXML private Label regR;
  @FXML private Label prob;
  public static boolean stopButtonClick = false;
  private MlParametersController mlParametersController;
  private DataService dataService;

  /**
   * Constructs a new instance of the MlParametersView class. Initializes the data service and the
   * ML parameters controller used in the view.
   */
  public MlParametersView() {
    this.dataService = DataService.getInstance();
    this.mlParametersController = new MlParametersController();
  }

  /**
   * Initializes the MlParametersController after its root element has been processed.
   *
   * @param location The location used to resolve relative paths for the root object, or {@code
   *     null} if the location is not known.
   * @param resources The resources used to localize the root object, or {@code null} if the root
   *     object was not localized.
   */
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    // setting buttons
    setButtonWithImage(
        rewindButton, "/com/playground/playground/playground-images/stop-button.png");
    setButtonWithImage(playButton, "/com/playground/playground/playground-images/play-button.png");

    mlParametersController = new MlParametersController();
  }

  /**
   * Handles the event when a problem type (Classification or Regression) is selected.
   *
   * @param actionEvent The ActionEvent representing the menu item selection.
   */
  public void sendProblem(ActionEvent actionEvent) {
    MenuItem selection = (MenuItem) actionEvent.getSource();
    String problem = selection.getText();
    prob.setText(selection.getText());
    mlParametersController.handleProblem(problem);
  }

  /**
   * Handles the event when a regularization rate menu item is selected.
   *
   * @param actionEvent The ActionEvent representing the menu item selection.
   */
  public void sendRegularizationRate(ActionEvent actionEvent) {
    MenuItem selection = (MenuItem) actionEvent.getSource();
    double regularizationRate = Double.parseDouble(selection.getText());
    regR.setText(selection.getText());
    mlParametersController.handleRegularizationRate(regularizationRate);
  }

  /**
   * Handles the event when a regularization type menu item is selected.
   *
   * @param actionEvent The ActionEvent representing the menu item selection.
   */
  public void sendRegularization(ActionEvent actionEvent) {
    MenuItem selection = (MenuItem) actionEvent.getSource();
    String regularization = selection.getText().toLowerCase();
    mlParametersController.handleRegularization(regularization);
    reg.setText(selection.getText());
  }

  /**
   * Handles the event when an activation function menu item is selected.
   *
   * @param actionEvent The ActionEvent representing the menu item selection.
   */
  public void sendActivation(ActionEvent actionEvent) {
    MenuItem selection = (MenuItem) actionEvent.getSource();
    String activation = selection.getText();
    active.setText(selection.getText());
    mlParametersController.handleActivation(activation);
  }

  /**
   * Handles the event when a learning rate menu item is selected.
   *
   * @param actionEvent The ActionEvent representing the menu item selection.
   */
  public void sendLearningRate(ActionEvent actionEvent) {
    MenuItem selection = (MenuItem) actionEvent.getSource();
    double learningRate = Double.parseDouble(selection.getText());
    learn.setText(selection.getText());
    mlParametersController.handleLearningRate(learningRate);
  }

  /**
   * Sets the graphic (image) for a button.
   *
   * @param button The Button to which the image should be set.
   * @param imagePath The path of the image file.
   */
  private void setButtonWithImage(Button button, String imagePath) {
    ImageView imageView =
        new ImageView(Objects.requireNonNull(getClass().getResource(imagePath)).toExternalForm());
    imageView.setFitWidth(40); // Adjust the width as needed
    imageView.setFitHeight(40); // Adjust the height as needed
    button.setGraphic(imageView);
    button.getStyleClass().add("image-button");
  }

  /**
   * Handles the event when the "Play" button is clicked to start the model training.
   *
   * @param actionEvent The ActionEvent representing the "Play" button click.
   */
  public void handlePlayButtonClick(javafx.event.ActionEvent actionEvent) {
    // Get user-selected parameters from other components

    ModelTrainingServices trainingController = mlParametersController.getTrainingController();
    Task<Void> task =
        new Task<Void>() {
          @Override
          protected Void call() throws Exception {
            int i = 0;
            while (!stopButtonClick) {
              System.out.println(trainingController);
              Object[] results = trainingController.trainModel(true);
              System.out.println("Setting dataset...");
              dataService.setResults((ArrayList<Double>) results[2]);
              System.out.println("Dataset set to: " + dataService.getDataset());
              System.out.println("Results set to: " + dataService.getResults());

              final int iteration = i;
              Platform.runLater(
                  () -> {
                    epochNumber.setText(Integer.toString(iteration));
                  });
              i++;
            }
            return null;
          }
        };
    // Start the task on a new thread
    new Thread(task).start();
  }

  /**
   * Handles the event when the "Stop" button is clicked to stop the model training.
   *
   * @param actionEvent The ActionEvent representing the "Stop" button click.
   */
  public void handleStopButtonClick(ActionEvent actionEvent) {
    stopButtonClick = true;
  }
}
