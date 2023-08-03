package com.playground.playground.modelling;

import java.io.File;
import java.util.List;
import org.deeplearning4j.api.storage.StatsStorage;
import org.deeplearning4j.datasets.iterator.INDArrayDataSetIterator;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.deeplearning4j.ui.stats.StatsListener;
import org.deeplearning4j.ui.storage.FileStatsStorage;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.primitives.Pair;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* This is the class that facilitates training the model and logging.
*/
public class ModelTrainingServices {
  private static final Logger log = LoggerFactory.getLogger(ModelTrainingServices.class);
  private final List<Pair<INDArray, INDArray>> data;
  private final List<Pair<INDArray, INDArray>> testData;
  private final MultiLayerNetwork model;
  private final String statsFileName;

/**
* Constructor for the ModelTrainingServices class which initializers the data and model.
 * @param data
 * @param model
 * @param statsFileName
 * @param testData
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
    for (int i=0; i<data.size(); i++){
      List<Double> point = new ArrayList<Double>();
      point.add(data.get(i).getKey().data().getDouble(0));
      point.add(data.get(i).getKey().data().getDouble(1));
      points.add(point);
    }
    for (int i=0; i<testData.size(); i++){
      List<Double> point = new ArrayList<Double>();
      point.add(testData.get(i).getKey().data().getDouble(0));
      point.add(testData.get(i).getKey().data().getDouble(1));
      points.add(point);
    }
    //   Here is where we initialize the graph in the UI
  }

/**
* Train the model set through the constructor and created using the NeuralNet class.
 * @param epochs
 * @param batchSize
 * @param verbose
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
      //      Here is where we make the changes to UI for training score
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
}
