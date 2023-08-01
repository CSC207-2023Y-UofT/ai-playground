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
    private int seed;
    private int inputs;
    private double learningRate;

    public NeuralNet(ArrayList<Integer> layers, int seed, int inputs, double learningRate) {
        this.layers = layers;
        this.seed = seed;
        this.inputs = inputs;
        this.learningRate = learningRate;
    }

    public MultiLayerNetwork generateModel() {
        MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
            .seed(seed)
            .learningRate(learningRate)
            .updater(new Adam())
            .list();
            
        for(int i = 0; i < layers.size() - 1; i++) {
            if (i == 0) {
                conf.layer(i, new DenseLayer.Builder()
                    .nIn(inputs)
                    .nOut(layers.get(i + 1))
                    .activation(Activation.RELU)
                );
            }
            else{
                conf.layer(i, new DenseLayer.Builder()
                    .nOut(layers.get(i))
                    .activation(Activation.RELU)
                );
            }
        }

        MultiLayerNetwork model = new MultiLayerNetwork(conf.build());
        model.init();
        return model;
    }
}
