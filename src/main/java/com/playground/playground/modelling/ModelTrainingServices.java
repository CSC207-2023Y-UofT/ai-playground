package com.playground.playground.modelling;

import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelTrainingServices {
    private static final Logger log = LoggerFactory.getLogger(ModelTrainingServices.class);
    private final INDArray data;
    private final INDArray labels;
    private final MultiLayerNetwork model;
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
            model.setListeners(new ScoreIterationListener(10));
            log.info("Training model...");
        }
        for (int i = 0; i < epochs; i++) {
            model.fit(data, labels);
        }
        log.info("Training completed");
    }
}
