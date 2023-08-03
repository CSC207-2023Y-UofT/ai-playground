package com.playground.playground.modelling;

import java.io.File;
import org.deeplearning4j.api.storage.StatsStorage;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.deeplearning4j.ui.stats.StatsListener;
import org.deeplearning4j.ui.storage.FileStatsStorage;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelTrainingServices {
  private static final Logger log = LoggerFactory.getLogger(ModelTrainingServices.class);
  private final INDArray data;
  private final INDArray testData;
  private final INDArray labels;
  private final MultiLayerNetwork model;
  private final String statsFileName;
  private int epochs;
  private int batchSize;

  public ModelTrainingServices(INDArray data, INDArray labels, MultiLayerNetwork model, String statsFileName, INDArray testData) {
    this.data = data;
    this.testData = testData;
    this.labels = labels;
    this.model = model;
    this.epochs = epochs;
    this.batchSize = batchSize;
    this.statsFileName = statsFileName;
  }

  public void trainModel(int epochs, int batchSize, boolean verbose) {
    this.epochs = epochs;
    this.batchSize = batchSize;
    File statsFile = new File(statsFileName);
    StatsStorage statsStorage = new FileStatsStorage(statsFile);
    if (verbose) {
      log.info(model.summary());
      log.info("Training model...");
    }
    model.setListeners(new StatsListener(statsStorage), new ScoreIterationListener(1));
    for (int i = 0; i < epochs; i++) {
      model.fit(data, labels);
      if (verbose) {
        log.info(String.format("Score at iteration %d is %s", i, model.score()));
      }
//      Here is where we make the changes to UI for training score
    }
    if (verbose) {
      log.info("Training completed");
    }
  }
}
