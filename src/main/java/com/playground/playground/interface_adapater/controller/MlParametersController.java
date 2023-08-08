package com.playground.playground.interface_adapater.controller;

import com.playground.playground.DataService;
import com.playground.playground.entity.NeuralNetBuilder;
import com.playground.playground.interface_adapater.modelling.ModelTrainingServices;
import com.playground.playground.usecase.modelling.PrepareData;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import org.deeplearning4j.datasets.iterator.INDArrayDataSetIterator;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.primitives.Pair;

/**
 * The MlParametersController class handles the user interface for specifying machine learning
 * parameters. It allows users to choose various hyperparameters like activation functions,
 * regularization, learning rate, etc.
 */
public class MlParametersController implements Initializable {
  // Fields for storing user selections
  private static String handleProblem = "Classification";
  private static double handleRegularizationRate = 1;
  private static String handleActivation = "Sigmoid";
  private static String handleRegularization = "L1";
  private static double handleLearningRate = 1;

  // JavaFX Components
  @FXML private Button stepButton;
  @FXML private Button playButton;
  @FXML private Button rewindButton;
  @FXML private Text epochNumber;
  @FXML private MenuItem learn1;
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
  private DataService dataService;

  public static boolean stopButtonClick = false;
  private GraphSystemController graphSystemController;

  public MlParametersController() {
    this.dataService = DataService.getInstance();
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
        rewindButton, "/com/playground/playground/playground-images/rewind-button.png");
    setButtonWithImage(playButton, "/com/playground/playground/playground-images/play-button.png");
    setButtonWithImage(
        stepButton, "/com/playground/playground/playground-images/fast-forward-button.png");

    // Set event handlers for menu items
    learn1.setOnAction(this::handleLearningRate);
    learn2.setOnAction(this::handleLearningRate);
    learn3.setOnAction(this::handleLearningRate);
    learn4.setOnAction(this::handleLearningRate);
    learn5.setOnAction(this::handleLearningRate);
    learn6.setOnAction(this::handleLearningRate);
    learn7.setOnAction(this::handleLearningRate);
    learn8.setOnAction(this::handleLearningRate);
    learn9.setOnAction(this::handleLearningRate);
    learn10.setOnAction(this::handleLearningRate);
    learn11.setOnAction(this::handleLearningRate);
    learn12.setOnAction(this::handleLearningRate);
    reLu.setOnAction(this::handleActivation);
    tanH.setOnAction(this::handleActivation);
    sigmoid.setOnAction(this::handleActivation);
    softMax.setOnAction(this::handleActivation);
    none.setOnAction(this::handleRegularization);
    l1.setOnAction(this::handleRegularization);
    l2.setOnAction(this::handleRegularization);
    reg1.setOnAction(this::handleRegularizationRate);
    reg2.setOnAction(this::handleRegularizationRate);
    reg3.setOnAction(this::handleRegularizationRate);
    reg4.setOnAction(this::handleRegularizationRate);
    reg5.setOnAction(this::handleRegularizationRate);
    reg6.setOnAction(this::handleRegularizationRate);
    reg7.setOnAction(this::handleRegularizationRate);
    reg8.setOnAction(this::handleRegularizationRate);
    reg9.setOnAction(this::handleRegularizationRate);
    reg10.setOnAction(this::handleRegularizationRate);
    classify.setOnAction(this::handleProblem);
    regress.setOnAction(this::handleProblem);
    graphSystemController = new GraphSystemController();
  }

  /**
   * Handles the event when the user selects a problem type (classification or regression) from the
   * menu.
   *
   * @param actionEvent The ActionEvent representing the user's selection.
   * @return The selected problem type.
   */
  public String handleProblem(ActionEvent actionEvent) {
    MenuItem selection = (MenuItem) actionEvent.getSource();
    String problem = selection.getText();
    MlParametersController.handleProblem = problem;
    return problem;
  }

  /**
   * Handles the event when the user selects a regularization rate from the menu.
   *
   * @param actionEvent The ActionEvent representing the user's selection.
   * @return The selected regularization rate.
   */
  public double handleRegularizationRate(ActionEvent actionEvent) {
    MenuItem selection = (MenuItem) actionEvent.getSource();
    double regularizationRate = Double.parseDouble(selection.getText());
    MlParametersController.handleRegularizationRate = regularizationRate;
    return regularizationRate;
  }

  public String handleRegularization(ActionEvent actionEvent) {
    MenuItem selection = (MenuItem) actionEvent.getSource();
    String regularization = selection.getText().toLowerCase();
    MlParametersController.handleRegularization = regularization;
    return regularization;
  }

  /**
   * Handles the event when the user selects an activation function from the menu.
   *
   * @param actionEvent The ActionEvent representing the user's selection.
   * @return The selected activation function.
   */
  public String handleActivation(ActionEvent actionEvent) {
    MenuItem selection = (MenuItem) actionEvent.getSource();
    String activation = selection.getText();
    MlParametersController.handleActivation = activation;
    return activation;
  }

  /**
   * Handles the event when the user selects a learning rate from the menu.
   *
   * @param actionEvent The ActionEvent representing the user's selection.
   * @return The selected learning rate.
   */
  public double handleLearningRate(ActionEvent actionEvent) {
    MenuItem selection = (MenuItem) actionEvent.getSource();
    double learningRate = Double.parseDouble(selection.getText());
    MlParametersController.handleLearningRate = learningRate;
    return learningRate;
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
   * Handles the event when the "Play" button is clicked to start the model training. This method
   * fetches user-selected parameters, prepares data, creates a neural network model, trains the
   * model, and updates the graph with the training results.
   *
   * @param actionEvent The ActionEvent representing the "Play" button click.
   */
  public void handlePlayButtonClick(javafx.event.ActionEvent actionEvent) {
    // Fetch necessary parameters from other controllers
    int noise = DataAttributesController.initializeNoise;
    int batch = DataAttributesController.initializeBatchSize;
    int test = DataAttributesController.initializeTestRatio;

    // Get user-selected parameters from other components
    String problemType = MlParametersController.handleProblem;
    double regularRate = MlParametersController.handleRegularizationRate;
    String regular = MlParametersController.handleRegularization;
    String activate = MlParametersController.handleActivation;
    double learnRate = MlParametersController.handleLearningRate;
    double regularizeRate = MlParametersController.handleRegularizationRate;

    // Fetch hidden layers from other components
    FeaturesHiddenLayersController.setLayersNeurons();
    System.out.println(FeaturesHiddenLayersController.getLayersNeurons());
    List<Integer> hiddenLayers = FeaturesHiddenLayersController.getLayersNeurons();

    // Map activation function string to Activation enum
    String activation = MlParametersController.handleActivation;
    Activation activationType = Activation.SOFTMAX;
    if (Objects.equals(activation, "ReLU")) {
      activationType = Activation.RELU;
    } else if (Objects.equals(activation, "TanH")) {
      activationType = Activation.TANH;
    } else if (Objects.equals(activation, "Sigmoid")) {
      activationType = Activation.SIGMOID;
    }

    // Get dataset and selected buttons
    String dataset = DataAttributesController.dataset;
    ArrayList<String> selectedButtons = FeaturesHiddenLayersController.selectedButtons;

    if (selectedButtons == null) {
      selectedButtons = new ArrayList<>();
    }

    // Prepare training and test data
    List<Pair<INDArray, INDArray>> rawData =
        FeatureController.createTrainingData(dataset, selectedButtons, noise);
    List<Pair<INDArray, INDArray>> rawTestData =
        FeatureController.createTrainingData(dataset, selectedButtons, noise);

    PrepareData dataGen = new PrepareData(batch, rawData, rawTestData);
    INDArrayDataSetIterator trainDataset = dataGen.getDataset();
    INDArrayDataSetIterator testDataset = dataGen.getTestDataset();

    // Set default regularization type
    String regularizationType = "l2";
    boolean shouldRegularize = false;
    if (regular != null) {
      shouldRegularize = true;
      regularizationType = regular;
    }

    int numFeatures = selectedButtons.size() + 2;
    // Create the neural network model
    MultiLayerNetwork model =
        new NeuralNetBuilder()
            .activation(activationType)
            .inputs(numFeatures)
            .layers((ArrayList<Integer>) hiddenLayers)
            .learningRate(learnRate)
            .nOut(1)
            .regularization(shouldRegularize)
            .regularizationType(regularizationType)
            .regularizationFactor(regularRate)
            .buildNeuralNet()
            .generateModel();

    hiddenLayers.add(0, numFeatures);

    // Train the model and get the results
        ModelTrainingServices trainingController =
            new ModelTrainingServices(
                    trainDataset, model, "statsLog", testDataset);
//    ModelTrainingServices trainingController =
//            new ModelTrainingServices(
//                    trainDataset, dataGen.getDataset(), model, "statsLog", testDataset);

//    Object[] results = trainingController.trainModel(true);
    while (!stopButtonClick) {
      Object[] results = trainingController.trainModel(true);
      System.out.println("Setting dataset...");
      dataService.setDataset(rawData);
      dataService.setResults((ArrayList<Integer>) results[2]);
      System.out.println("Dataset set to: " + dataService.getDataset());
    }

//    System.out.println("Setting dataset...");
//    dataService.setDataset(rawData);
//    dataService.setResults((ArrayList<Integer>) results[2]);
//    System.out.println("Dataset set to: " + dataService.getDataset());

  }

  public void handleStopButtonClick(ActionEvent actionEvent) {
    stopButtonClick = true;
  }
}
