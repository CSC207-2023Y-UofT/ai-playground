package com.playground.playground.controller;

import com.playground.playground.DataService;
import com.playground.playground.entity.NeuralNetBuilder;
import com.playground.playground.interface_adapter.modelling.ModelTrainingServices;
import com.playground.playground.usecase.modelling.PrepareData;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.deeplearning4j.datasets.iterator.INDArrayDataSetIterator;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.primitives.Pair;

/** This class handles user-selected parameters for the machine learning model. */
public class MlParametersController {
  // Fields for storing user selections
  private static String handleProblem = "Classification";
  private static double handleRegularizationRate = 1;
  private static String handleActivation = "Sigmoid";
  private static String handleRegularization = "L1";
  private static double handleLearningRate = 1;

  private DataService dataService;

  /** Constructs an instance of MlParametersController and initializes the DataService. */
  public MlParametersController() {
    this.dataService = DataService.getInstance();
  }

  /**
   * Sets the problem type selected by the user.
   *
   * @param problem The problem type selected by the user.
   * @return The selected problem type.
   */
  public String handleProblem(String problem) {
    MlParametersController.handleProblem = problem;
    return problem;
  }

  /**
   * Sets the regularization rate selected by the user.
   *
   * @param regularizationRate The regularization rate selected by the user.
   * @return The selected regularization rate.
   */
  public double handleRegularizationRate(double regularizationRate) {
    MlParametersController.handleRegularizationRate = regularizationRate;
    return regularizationRate;
  }

  /**
   * Sets the regularization type selected by the user.
   *
   * @param regularization The regularization type selected by the user.
   * @return The selected regularization type.
   */
  public String handleRegularization(String regularization) {
    MlParametersController.handleRegularization = regularization;
    return regularization;
  }

  /**
   * Sets the activation function selected by the user.
   *
   * @param activation The activation function selected by the user.
   * @return The selected activation function.
   */
  public String handleActivation(String activation) {
    MlParametersController.handleActivation = activation;
    return activation;
  }

  /**
   * Sets the learning rate selected by the user.
   *
   * @param learningRate The learning rate selected by the user.
   * @return The selected learning rate.
   */
  public double handleLearningRate(double learningRate) {
    MlParametersController.handleLearningRate = learningRate;
    return learningRate;
  }

  /**
   * Retrieves the ModelTrainingServices object for training the neural network model.
   *
   * @return The ModelTrainingServices object with the necessary parameters set.
   */
  public ModelTrainingServices getTrainingController() {
    // Fetch necessary parameters from other controllers
    int noise = DataAttributesController.initializeNoise;
    int batch = DataAttributesController.initializeBatchSize;
    int test = DataAttributesController.initializeTestRatio;

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
    System.out.println(DataAttributesController.dataset);
    if (DataAttributesController.dataset == null) {
      dataset = "cluster";
    }
    ArrayList<String> selectedButtons = FeaturesHiddenLayersController.selectedButtons;

    if (selectedButtons == null) {
      selectedButtons = new ArrayList<>();
    }

    // Prepare training and test data
    List<Pair<INDArray, INDArray>> rawData =
        FeatureController.createTrainingData(dataset, selectedButtons, noise);
    List<Pair<INDArray, INDArray>> rawTestData =
        FeatureController.createTrainingData(dataset, selectedButtons, noise);

    dataService.setDataset(rawData);
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
        new ModelTrainingServices(trainDataset, model, "statsLog", testDataset);
    return trainingController;
  }
}
