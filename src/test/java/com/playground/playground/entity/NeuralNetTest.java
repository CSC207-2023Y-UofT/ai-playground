package com.playground.playground.entity;

import com.playground.playground.entity.NeuralNet;
import java.util.ArrayList;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.Updater;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.lossfunctions.LossFunctions;

/** Test class to validate the functionality of the NeuralNet class. */
class NeuralNetTest {
  private NeuralNet neuralNet;
  private NeuralNet neuralNet1Layer;
  /** Sets up the NeuralNet instance with required configurations before each test. */
  @BeforeEach
  void setUp() {
    // Set up the configuration parameters for the NeuralNet instance
    ArrayList<Integer> layers = new ArrayList<>();
    layers.add(2);
    layers.add(4);
    layers.add(2);
    int seed = 123;
    int inputs = 2;
    double learningRate = 0.01;
    Updater optimizer = Updater.ADAM;
    OptimizationAlgorithm optimizationAlgorithm = OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT;
    Activation activation = Activation.RELU;
    WeightInit weightInit = WeightInit.XAVIER;
    int nOut = 2;
    LossFunctions.LossFunction lossFunction = LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD;
    boolean regularization = true;
    String regularizationType = "l2";
    double regularizationFactor = 0.001;

    // Create the NeuralNet instance
    neuralNet =
        new NeuralNet(
            layers,
            seed,
            inputs,
            learningRate,
            optimizer,
            optimizationAlgorithm,
            activation,
            weightInit,
            nOut,
            lossFunction,
            regularization,
            regularizationType,
            regularizationFactor);

    ArrayList<Integer> layers1layered = new ArrayList<>();
    layers1layered.add(2);
    String regularizationType1layer = "l1";
    neuralNet1Layer =
        new NeuralNet(
            layers1layered,
            seed,
            inputs,
            learningRate,
            optimizer,
            optimizationAlgorithm,
            activation,
            weightInit,
            nOut,
            lossFunction,
            regularization,
            regularizationType1layer,
            regularizationFactor);
  }

  /**
   * Test the generateModel() method of NeuralNet class to ensure it generates a model correctly.
   */
  @Test
  void testGenerateModel() {
    // When
    MultiLayerNetwork model = neuralNet.generateModel();
    // Then
    Assertions.assertNotNull(model);
  }

  @Test
  void testGenerate1LayerModel() {
    // When

    MultiLayerNetwork model = neuralNet1Layer.generateModel();
    // Then
    Assertions.assertNotNull(model);
  }

  /**
   * Test the modelSummary() method of NeuralNet class to ensure it provides a summary of the model.
   */
  @Test
  void testModelSummary() {
    // When
    MultiLayerNetwork model = neuralNet.generateModel();
    String summary = neuralNet.modelSummary();
    // Then
    Assertions.assertNotNull(summary);
    Assertions.assertEquals(model.summary(), summary);
  }
}
