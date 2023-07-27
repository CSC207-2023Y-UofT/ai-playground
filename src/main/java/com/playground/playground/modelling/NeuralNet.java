package com.playground.playground.modelling;

import java.util.ArrayList;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.learning.config.Adam;
import org.nd4j.linalg.lossfunctions.LossFunctions;

public class NeuralNet {
    private ArrayList<Integer> layers;
    private GradientUpdater optimizer;
    private int seed;
    private int inputs;

    public NeuralNet(ArrayList<Integer> layers, GradientUpdater optimizer, int seed, int inputs) {
        this.layers = layers;
        this.optimizer = optimizer;
        this.seed = seed;
        this.inputs = inputs;
    }

    public generateModel() {
        MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
            .seed(seed)
            .updater(optimizer)
            .list()
            
        for(int i = 0; i < layers.size() - 1; i++) {
            if i == 0 {
                conf.layer(i, new DenseLayer.Builder()
                    .nIn(inputs)
                    .nOut(layers.get(i + 1))
                    .activation(Activation.RELU)
                    .build()
                )
            }
            else{
                conf.layer(i, new DenseLayer.Builder()
                    .nOut(layers.get(i))
                    .activation(Activation.RELU)
                    .build()
                )
            }
        }

        MultiLayerNetwork model = new MultiLayerNetwork(conf);
        model.init();
        return model;
    }
}

public class NeuralNetBuilder {
    private ArrayList<Integer> layers = new ArrayList<Integer>();
    layers.add(2);
    layers.add(4);
    layers.add(2);
    private GradientUpdater optimizer = new Adam();
    private int seed = 123;
    private int inputs = 2;

    public NeuralNet buildNeuralNet() {
        return new NeuralNet(layers, optimizer, seed, inputs);
    }

    public NeuralNetBuilder inputs(int inputs) {
        this.inputs = inputs;
        return this;
    }

    public NeuralNetBuilder layers(ArrayList<Integer> layers) {
        this.layers = layers;
        return this;
    }

    public NeuralNetBuilder optimizer(GradientUpdater optimizer) {
        this.optimizer = optimizer;
        return this;
    }

    public NeuralNetBuilder seed(int seed) {
        this.seed = seed;
        return this;
    }
}