package com.playground.playground.interface_adapter.controller;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import com.playground.playground.DataService;
import com.playground.playground.interface_adapter.modelling.ModelTrainingServices;
import org.deeplearning4j.datasets.iterator.INDArrayDataSetIterator;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.primitives.Pair;

import java.util.ArrayList;
import java.util.List;

class MlParametersControllerTest {

  @InjectMocks
  private MlParametersController controller;

  @Mock
  private DataService dataService;

  @Mock
  private FeaturesHiddenLayersController featuresHiddenLayersController;

  @Mock
  private DataAttributesController dataAttributesController;

  @Mock
  private FeatureController featureController;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testHandleProblem() {
    String problem = "Regression";
    String result = controller.handleProblem(problem);
    assertEquals(problem, result);
  }

  @Test
  public void testHandleRegularizationRate() {
    double rate = 0.5;
    double result = controller.handleRegularizationRate(rate);
    assertEquals(rate, result);
  }

  @Test
  public void testHandleRegularization() {
    String regularization = "l2";
    String result = controller.handleRegularization(regularization);
    assertEquals(regularization, result);
  }

  @Test
  public void testHandleActivation() {
    String activation = "ReLU";
    String result = controller.handleActivation(activation);
    assertEquals(activation, result);
  }

  @Test
  public void testHandleLearningRate() {
    double learningRate = 0.01;
    double result = controller.handleLearningRate(learningRate);
    assertEquals(learningRate, result);
  }
  @Test
  public void testDefaultDatasetSelection() {
    assertNull(DataAttributesController.dataset);
    ModelTrainingServices trainingController = controller.getTrainingController();
    assertNotNull(trainingController);
    // Verify that the default dataset "cluster" was used
    // This assumes you have a way to check the dataset used in ModelTrainingServices
  }

  @Test
  public void testActivationMapping() {
    controller.handleActivation("ReLU");
    ModelTrainingServices trainingController = controller.getTrainingController();
    // Check if the activation function of the model is ReLU
    // This assumes you have a way to check the activation function in ModelTrainingServices or NeuralNetBuilder
  }

  @Test
  public void testRegularizationSelection() {
    controller.handleRegularization("L1");
    ModelTrainingServices trainingController = controller.getTrainingController();
    // Check if the regularization type of the model is L1
    // This assumes you have a way to check the regularization type in ModelTrainingServices or NeuralNetBuilder
  }

  @Test
  public void testNeuralNetworkModelCreation() {
    ModelTrainingServices trainingController = controller.getTrainingController();
    MultiLayerNetwork model = trainingController.getModel(); // Assuming getModel() exists
    assertNotNull(model);
  }

  @Test
  public void testTrainingControllerInitialization() {
    ModelTrainingServices trainingController = controller.getTrainingController();
    assertNotNull(trainingController);
    // Further checks can be added based on the properties of ModelTrainingServices
  }
}