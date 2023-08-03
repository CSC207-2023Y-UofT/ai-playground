package com.playground.playground.modelling;

import java.util.ArrayList;
import java.util.Arrays;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.Updater;
import org.deeplearning4j.nn.weights.WeightInit;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.lossfunctions.LossFunctions;

/**
* The NeuralNetBuilder class helps create the NeuralNet class in the builder design.
*/
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
  private boolean regularization = true;
  private String regularizationType = "l2";
  private double regularizationFactor = 0.0005;

/**
* Create the NeuralNet class object in accordance to other methods called or defaults.
 * @return An object of NeuralNet class.
*/
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
        lossFunction,
        regularization,
        regularizationType,
        regularizationFactor);
  }

/**
* Set regularization type, either one of "l1" or "l2", defaults to "l2".
 * @param regularizationType
 * @return NeuralNetBuilder object
*/
  public NeuralNetBuilder regularizationType(String regularizationType) {
    this.regularizationType = regularizationType;
    return this;
  }

/**
* Set the regularization factor, defaults to 5e-4.
 * @param regularizationFactor
 * @return NeuralNetBuilder object
*/
  public NeuralNetBuilder regularizationFactor(double regularizationFactor) {
    this.regularizationFactor = regularizationFactor;
    return this;
  }

/**
* Set the optimization algorithm, defaults to SGD.
 * @param optimizationAlgorithm
 * @return NeuralNetBuilder object
*/
  public NeuralNetBuilder optimizationAlgorithm(OptimizationAlgorithm optimizationAlgorithm) {
    this.optimizationAlgorithm = optimizationAlgorithm;
    return this;
  }

/**
* Should you use regularization?, defaults to true.
 * @param regularization
 * @return NeuralNetBuilder object
*/
  public NeuralNetBuilder regularization(boolean regularization) {
    this.regularization = regularization;
    return this;
  }

/**
* Set the optimizer, defaults to Adam.
 * @param optimizer
 * @return NeuralNetBuilder object
*/
  public NeuralNetBuilder optimizer(Updater optimizer) {
    this.optimizer = optimizer;
    return this;
  }

/**
* Set activation function for all except the output layer, defaults to ReLU.
 * @param activation
 * @return NeuralNetBuilder object
*/
  public NeuralNetBuilder activation(Activation activation) {
    this.activation = activation;
    return this;
  }

/**
* Set weight initialization startegy, defaults to Xavier.
 * @param weightInit
 * @return NeuralNetBuilder object
*/
  public NeuralNetBuilder weightInit(WeightInit weightInit) {
    this.weightInit = weightInit;
    return this;
  }

/**
* Set the number of outputs, defaults to 2.
 * @param nOut
 * @return NeuralNetBuilder object
*/
  public NeuralNetBuilder nOut(int nOut) {
    this.nOut = nOut;
    return this;
  }

/**
* Set loss function, defaults to negative log likelihood.
 * @param lossFunction
 * @return NeuralNetBuilder object
*/
  public NeuralNetBuilder lossFunction(LossFunctions.LossFunction lossFunction) {
    this.lossFunction = lossFunction;
    return this;
  }

/**
* Set the number of inputs, defaults to 2.
 * @param inputs
 * @return NeuralNetBuilder object
*/
  public NeuralNetBuilder inputs(int inputs) {
    this.inputs = inputs;
    return this;
  }

/**
* A list of numbers showing the number of nodes ine ach layer, excluding the last layer but including the first layer in this list, defaults to [2,4,2].
 * @param layers
 * @return NeuralNetBuilder object
*/
  public NeuralNetBuilder layers(ArrayList<Integer> layers) {
    this.layers = layers;
    return this;
  }

/**
* Set learning rate, defaults to 1e-3.
 * @param learningRate
 * @return NeuralNetBuilder object
*/
  public NeuralNetBuilder learningRate(double learningRate) {
    this.learningRate = learningRate;
    return this;
  }

/**
* Set seed for the experiments, defaults to 123 (ideally choose 3047).
 * @param seed
 * @return NeuralNetBuilder object
*/
  public NeuralNetBuilder seed(int seed) {
    this.seed = seed;
    return this;
  }
}
