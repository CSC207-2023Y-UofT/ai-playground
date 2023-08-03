package com.playground.playground.modelling;

import java.util.ArrayList;

import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.Updater;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.activations.impl.ActivationSoftmax;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.learning.config.Adam;
import org.nd4j.linalg.lossfunctions.LossFunctions;


public class NeuralNet {
    private ArrayList<Integer> layers;
    private int seed;
    private int inputs;
    private double learningRate;
    private MultiLayerNetwork model;

    public NeuralNet(ArrayList<Integer> layers, int seed, int inputs, double learningRate) {
        this.layers = layers;
        this.seed = seed;
        this.inputs = inputs;
        this.learningRate = learningRate;
    }

    public MultiLayerNetwork generateModel() {
        NeuralNetConfiguration.Builder builder = new NeuralNetConfiguration.Builder();
        builder.seed(seed);
        builder.learningRate(learningRate);
        builder.optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT);
        builder.updater(Updater.ADAM);
        NeuralNetConfiguration.ListBuilder conf = builder.list();

        for(int i = 0; i < layers.size() - 1; i++) {
            if (i == 0) {
                conf = conf.layer(i, new DenseLayer.Builder()
                        .nIn(inputs)
                        .nOut(layers.get(i + 1))
                        .activation(Activation.RELU)
                        .weightInit(WeightInit.XAVIER)
                        .build()
                );
            }
            else{
                conf = conf.layer(i, new DenseLayer.Builder()
                    .nOut(layers.get(i))
                    .activation(Activation.RELU)
                    .weightInit(WeightInit.XAVIER)
                    .build()
                );
            }
        }
        conf = conf.layer(layers.size(), new OutputLayer.Builder(LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD)
                .weightInit(WeightInit.XAVIER)
                .nOut(2)
                .build()
        );

        MultiLayerNetwork model = new MultiLayerNetwork(conf
                .pretrain(false)
                .backprop(true)
                .build()
        );
        model.init();
        this.model = model;
        return model;
    }
}
