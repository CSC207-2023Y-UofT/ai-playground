package com.playground.playground.modelling;

import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.Updater;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.junit.jupiter.api.Assertions;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.lossfunctions.LossFunctions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class NeuralNetTest {
    private NeuralNet neuralNet;

    @BeforeEach
    void setUp() {
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
        String regularizationType = "L2";
        double regularizationFactor = 0.001;

        neuralNet = new NeuralNet(
                layers, seed, inputs, learningRate, optimizer, optimizationAlgorithm, activation,
                weightInit, nOut, lossFunction, regularization, regularizationType, regularizationFactor
        );
    }

    @Test
    void testGenerateModel() {
        MultiLayerNetwork model = neuralNet.generateModel();
        Assertions.assertNotNull(model);
    }

    @Test
    void testModelSummary() {
        MultiLayerNetwork model = neuralNet.generateModel();
        String summary = neuralNet.modelSummary();
        Assertions.assertNotNull(summary);
        Assertions.assertEquals(model.summary(), summary);
    }
}
