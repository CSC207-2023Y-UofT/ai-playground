package com.playground.playground.modelling;

import java.util.ArrayList;
import java.util.Objects;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.Updater;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.lossfunctions.LossFunctions;

public class NeuralNet {
  private final OptimizationAlgorithm optimizationAlgorithm;
  private final Updater optimizer;
  private final ArrayList<Integer> layers;
  private final int seed;
  private final int inputs;
  private final double learningRate;
  private final Activation activation;
  private final WeightInit weightInit;
  private final int nOut;
  private final LossFunctions.LossFunction lossFunction;
  private final boolean regularization;
  private final String regularizationType;
  private final double regularizationFactor;
  private MultiLayerNetwork model;

  public NeuralNet(
      ArrayList<Integer> layers,
      int seed,
      int inputs,
      double learningRate,
      Updater optimizer,
      OptimizationAlgorithm optimizationAlgorithm,
      Activation activation,
      WeightInit weightInit,
      int nOut,
      LossFunctions.LossFunction lossFunction,
      boolean regularization,
      String regularizationType,
      double regularizationFactor) {
    this.layers = layers;
    this.seed = seed;
    this.inputs = inputs;
    this.learningRate = learningRate;
    this.optimizer = optimizer;
    this.optimizationAlgorithm = optimizationAlgorithm;
    this.activation = activation;
    this.weightInit = weightInit;
    this.nOut = nOut;
    this.lossFunction = lossFunction;
    this.regularization = regularization;
    this.regularizationType = regularizationType;
    this.regularizationFactor = regularizationFactor;
  }

  public MultiLayerNetwork generateModel() {
    NeuralNetConfiguration.Builder builder =
        new NeuralNetConfiguration.Builder()
            .seed(seed)
            .learningRate(learningRate)
            .optimizationAlgo(optimizationAlgorithm)
            .regularization(regularization)
            .updater(optimizer);
    if (Objects.equals(regularizationType, "l2")) {
      builder = builder.l2(regularizationFactor);
    } else {
      builder = builder.l1(regularizationFactor);
    }
    NeuralNetConfiguration.ListBuilder conf = builder.list();

    for (int i = 0; i < layers.size() - 1; i++) {
      if (i == 0) {
        conf =
            conf.layer(
                i,
                new DenseLayer.Builder()
                    .nIn(inputs)
                    .nOut(layers.get(i + 1))
                    .activation(activation)
                    .weightInit(weightInit)
                    .build());
      } else {
        conf =
            conf.layer(
                i,
                new DenseLayer.Builder()
                    .nOut(layers.get(i))
                    .activation(activation)
                    .weightInit(weightInit)
                    .build());
      }
    }
    conf =
        conf.layer(
            layers.size(),
            new OutputLayer.Builder(lossFunction).weightInit(weightInit).nOut(nOut).build());

    MultiLayerNetwork model = new MultiLayerNetwork(conf.pretrain(false).backprop(true).build());
    model.init();
    this.model = model;
    return model;
  }

  public String modelSummary() {
    return model.summary();
  }
}
