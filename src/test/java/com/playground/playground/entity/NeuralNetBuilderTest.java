package com.playground.playground.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.Updater;
import org.deeplearning4j.nn.weights.WeightInit;
import org.junit.jupiter.api.Test;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.lossfunctions.LossFunctions;

class NeuralNetBuilderTest {

  @Test
  void testBuildNeuralNet() {
    NeuralNetBuilder builder = new NeuralNetBuilder();
    NeuralNet neuralNet = builder.buildNeuralNet();

    assertNotNull(neuralNet);
    // Add more assertions as needed
  }

  @Test
  void testRegularizationType() {
    NeuralNetBuilder builder = new NeuralNetBuilder();
    builder.regularizationType("l1");

    assertEquals("l1", builder.buildNeuralNet().getRegularizationType());
  }

  @Test
  void testRegularizationFactor() {
    NeuralNetBuilder builder = new NeuralNetBuilder();
    builder.regularizationFactor(0.001);

    assertEquals(0.001, builder.buildNeuralNet().getRegularizationFactor());
  }

  @Test
  void testOptimizationAlgorithm() {
    NeuralNetBuilder builder = new NeuralNetBuilder();
    builder.optimizationAlgorithm(OptimizationAlgorithm.LINE_GRADIENT_DESCENT);

    assertEquals(
        OptimizationAlgorithm.LINE_GRADIENT_DESCENT,
        builder.buildNeuralNet().getOptimizationAlgorithm());
  }

  @Test
  void testRegularization() {
    NeuralNetBuilder builder = new NeuralNetBuilder();
    builder.regularization(false);

    assertFalse(builder.buildNeuralNet().isRegularization());
  }

  @Test
  void testOptimizer() {
    NeuralNetBuilder builder = new NeuralNetBuilder();
    builder.optimizer(Updater.NESTEROVS);

    assertEquals(Updater.NESTEROVS, builder.buildNeuralNet().getOptimizer());
  }

  @Test
  void testActivation() {
    NeuralNetBuilder builder = new NeuralNetBuilder();
    builder.activation(Activation.RELU);

    assertEquals(Activation.RELU, builder.buildNeuralNet().getActivation());
  }

  @Test
  void testWeightInit() {
    NeuralNetBuilder builder = new NeuralNetBuilder();
    builder.weightInit(WeightInit.ZERO);

    assertEquals(WeightInit.ZERO, builder.buildNeuralNet().getWeightInit());
  }

  @Test
  void testNOut() {
    NeuralNetBuilder builder = new NeuralNetBuilder();
    builder.nOut(3);

    assertEquals(3, builder.buildNeuralNet().getNOut());
  }

  @Test
  void testLossFunction() {
    NeuralNetBuilder builder = new NeuralNetBuilder();
    builder.lossFunction(LossFunctions.LossFunction.COSINE_PROXIMITY);

    assertEquals(
        LossFunctions.LossFunction.COSINE_PROXIMITY, builder.buildNeuralNet().getLossFunction());
  }

  @Test
  void testInputs() {
    NeuralNetBuilder builder = new NeuralNetBuilder();
    builder.inputs(4);

    assertEquals(4, builder.buildNeuralNet().getInputs());
  }

  @Test
  void testLayers() {
    NeuralNetBuilder builder = new NeuralNetBuilder();
    ArrayList<Integer> layers = new ArrayList<>(Arrays.asList(3, 6, 3));
    builder.layers(layers);

    assertEquals(layers, builder.buildNeuralNet().getLayers());
  }

  @Test
  void testLearningRate() {
    NeuralNetBuilder builder = new NeuralNetBuilder();
    builder.learningRate(0.01);

    assertEquals(0.01, builder.buildNeuralNet().getLearningRate());
  }

  @Test
  void testSeed() {
    NeuralNetBuilder builder = new NeuralNetBuilder();
    builder.seed(456);

    assertEquals(456, builder.buildNeuralNet().getSeed());
  }
}
