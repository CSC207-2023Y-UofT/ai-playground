package com.playground.playground.modelling;

import java.util.ArrayList;
import java.util.Arrays;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.Updater;
import org.deeplearning4j.nn.weights.WeightInit;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.lossfunctions.LossFunctions;

public class NeuralNetBuilder {
  private ArrayList<Integer> layers = new ArrayList<>(Arrays.asList(2, 4, 2));
  private double learningRate = 0.001;
  private int seed = 123;
  private int inputs = 2;
  private OptimizationAlgorithm optimizationAlgorithm =
      OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT;
  private Updater optimizer = Updater.ADAM;
  private Activation activation = Activation.SOFTMAX;
  private WeightInit weightInit = WeightInit.XAVIER;
  private int nOut = 2;
  private LossFunctions.LossFunction lossFunction =
      LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD;

  public NeuralNet buildNeuralNet() {
    return new NeuralNet(
        layers,
        seed,
        inputs,
        learningRate,
        optimizer,
        optimizationAlgorithm,
        activation,
        weightInit,
        nOut,
        lossFunction);
  }

  public NeuralNetBuilder optimizationAlgorithm(OptimizationAlgorithm optimizationAlgorithm) {
    this.optimizationAlgorithm = optimizationAlgorithm;
    return this;
  }

  public NeuralNetBuilder optimizer(Updater optimizer) {
    this.optimizer = optimizer;
    return this;
  }

  public NeuralNetBuilder activation(Activation activation) {
    this.activation = activation;
    return this;
  }

  public NeuralNetBuilder weightInit(WeightInit weightInit) {
    this.weightInit = weightInit;
    return this;
  }

  public NeuralNetBuilder nOut(int nOut) {
    this.nOut = nOut;
    return this;
  }

  public NeuralNetBuilder lossFunction(LossFunctions.LossFunction lossFunction) {
    this.lossFunction = lossFunction;
    return this;
  }

  public NeuralNetBuilder inputs(int inputs) {
    this.inputs = inputs;
    return this;
  }

  public NeuralNetBuilder layers(ArrayList<Integer> layers) {
    this.layers = layers;
    return this;
  }

  public NeuralNetBuilder learningRate(double learningRate) {
    this.learningRate = learningRate;
    return this;
  }

  public NeuralNetBuilder seed(int seed) {
    this.seed = seed;
    return this;
  }
}
