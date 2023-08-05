package com.playground.playground.clean_architecture.interface_adapter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import lombok.Setter;
import org.deeplearning4j.api.storage.StatsStorage;
import org.deeplearning4j.datasets.iterator.INDArrayDataSetIterator;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.deeplearning4j.ui.stats.StatsListener;
import org.deeplearning4j.ui.storage.FileStatsStorage;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.primitives.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** This is the class that facilitates training the model and logging. */
public class ModelTrainingServices {
  private final Logger log = LoggerFactory.getLogger(ModelTrainingServices.class);
  @Setter private List<Pair<INDArray, INDArray>> data;
  private List<Pair<INDArray, INDArray>> testData;
  private MultiLayerNetwork model;
  private String statsFileName;
  private INDArrayDataSetIterator dataset;
  private INDArrayDataSetIterator testDataset;

  /**
   * Constructor for the ModelTrainingServices class which initializers the data and model.
   *
   * @param data The training dataset.
   * @param model The model DAG.
   * @param statsFileName The name of the logging file which will be saved to the disk.
   * @param testData The testing dataset.
   */
  public ModelTrainingServices(
      List<Pair<INDArray, INDArray>> data,
      MultiLayerNetwork model,
      String statsFileName,
      List<Pair<INDArray, INDArray>> testData) {
    this.data = data;
    this.testData = testData;
    this.model = model;
    this.statsFileName = statsFileName;

    List<List<Double>> points = new ArrayList<List<Double>>();
    for (int i = 0; i < data.size(); i++) {
      List<Double> point = new ArrayList<Double>();
      point.add(data.get(i).getKey().data().getDouble(0));
      point.add(data.get(i).getKey().data().getDouble(1));
      points.add(point);
    }
    for (int i = 0; i < testData.size(); i++) {
      List<Double> point = new ArrayList<Double>();
      point.add(testData.get(i).getKey().data().getDouble(0));
      point.add(testData.get(i).getKey().data().getDouble(1));
      points.add(point);
    }
    //   Here is where we initialize the graph in the UI
  }

  /**
   * Train the model set through the constructor and created using the NeuralNet class.
   *
   * @param epochs Number of iterations you should train for.
   * @param batchSize The batch size to use while training.
   * @param verbose Should you print to the logger.
   */
  public void trainModel(int epochs, int batchSize, boolean verbose) {

    //    Example on the kind of data we need, example for a simple "and" operation dataset, we want
    // the same, two or more numbers for the features and 1 number (1 or 0) for label.

    //    public static Pair<INDArray, INDArray> buildInstance(final boolean bitA, final boolean
    // bitB) {
    //      final double[] input = new double[2];
    //      final double[] labels = new double[1];
    //      for (int idx = 0; idx < labels.length; ++idx) {
    //        final boolean result = bitA && bitB;
    //        input[idx * 2]     = bitA   ? 1.0 : 0.0;
    //        input[idx * 2 + 1] = bitB   ? 1.0 : 0.0;
    //        labels[idx]        = result ? 1.0 : 0.0;
    //      }
    //      return Pair.create(
    //              Nd4j.create(input),
    //              Nd4j.create(labels)
    //      );
    //    }

    INDArrayDataSetIterator dataset = new INDArrayDataSetIterator(data, batchSize);
    INDArrayDataSetIterator testDataset = new INDArrayDataSetIterator(testData, 1);
    this.dataset = dataset;
    this.testDataset = testDataset;

    File statsFile = new File(statsFileName);
    StatsStorage statsStorage = new FileStatsStorage(statsFile);

    if (verbose) {
      log.info(model.summary());
      log.info("Training model...");
    }
    model.setListeners(new StatsListener(statsStorage), new ScoreIterationListener(1));
    for (int i = 0; i < epochs; i++) {
      model.fit(dataset);
      if (verbose) {
        log.info(String.format("Train Score at iteration %d is %s", i, model.score()));
        log.info(
            String.format("Test Score at iteration %d is %s", i, model.score(testDataset.next())));
      }
      //      Here is where we make the changes to UI for training and test score
      while (dataset.hasNext()) {
        DataSet t = dataset.next();
        INDArray features = t.getFeatureMatrix();
        INDArray predicted = model.output(features, false);
        //        Here is where we make the graph in the UI
      }
      while (testDataset.hasNext()) {
        DataSet t = testDataset.next();
        INDArray features = t.getFeatureMatrix();
        INDArray predicted = model.output(features, false);
        //        Here is where we make the graph in the UI
      }
    }
    if (verbose) {
      log.info("Training completed");
    }
  }

  public List<Pair<INDArray, INDArray>> getData() {
    return data;
  }

  public List<Pair<INDArray, INDArray>> getTestData() {
    return testData;
  }

  public void setTestData(List<Pair<INDArray, INDArray>> testData) {
    this.testData = testData;
  }

  public MultiLayerNetwork getModel() {
    return model;
  }

  public void setModel(MultiLayerNetwork model) {
    this.model = model;
  }

  public String getStatsFileName() {
    return statsFileName;
  }

  public void setStatsFileName(String statsFileName) {
    this.statsFileName = statsFileName;
  }

  public void setTrainingDataset(INDArrayDataSetIterator dataset) {
    this.dataset = dataset;
  }

  public INDArrayDataSetIterator getTrainingDataset() {
    return dataset;
  }

  public void setTestDataset(INDArrayDataSetIterator testDataset) {
    this.testDataset = testDataset;
  }

  public INDArrayDataSetIterator getTestDataset() {
    return testDataset;
  }
}
