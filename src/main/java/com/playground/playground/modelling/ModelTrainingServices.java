package com.playground.playground.modelling;

import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.learning.config.Adam;
import org.nd4j.linalg.lossfunctions.LossFunctions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelTrainingServices {
    private static final Logger log = LoggerFactory.getLogger(ModelTrainingServices.class);
    private INDArray data;
    private INDArray labels;
    private MultiLayerNetwork model;
    private int epochs;
    private int batchSize;

    public ModelTrainingServices(INDArray data, INDArray labels, MultiLayerNetwork model) {
        this.data = data;
        this.labels = labels;
        this.model = model;
        this.epochs = epochs;
        this.batchSize = batchSize;
    }
    
    public void trainModel(int epochs, int batchSize, boolean verbose) {
        this.epochs = epochs;
        this.batchSize = batchSize;
        if (verbose) {
            log.info(model.summary());
            model.setListeners(new ScoreIterationListener(100));
            log.info("Training model...");
        }
        for (int i = 0; i < epochs; i++) {
            model.fit(data, labels);
        }
        log.info("Training completed");
    }
}
