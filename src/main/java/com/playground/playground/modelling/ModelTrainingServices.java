package com.playground.playground.modelling;

import java.io.File;
import java.util.ArrayList;

import com.rits.cloning.Cloner;
import org.deeplearning4j.api.storage.StatsStorage;
import org.deeplearning4j.datasets.iterator.INDArrayDataSetIterator;
import org.deeplearning4j.eval.Evaluation;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.deeplearning4j.ui.stats.StatsListener;
import org.deeplearning4j.ui.storage.FileStatsStorage;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.util.NDArrayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** This is the class that facilitates training the model and logging. */
public class ModelTrainingServices {
  private final Logger log = LoggerFactory.getLogger(ModelTrainingServices.class);
  private final INDArrayDataSetIterator data;
  private final INDArrayDataSetIterator testData;
  private final INDArrayDataSetIterator copyData;
  private MultiLayerNetwork model;
  private String statsFileName;

  /**
   * Constructor for the ModelTrainingServices class which initializers the data and model.
   *
   * @param data The training dataset.
   * @param model The model DAG.
   * @param statsFileName The name of the logging file which will be saved to the disk.
   * @param testData The testing dataset.
   */
  public ModelTrainingServices(
      INDArrayDataSetIterator data,
      INDArrayDataSetIterator copyData,
      MultiLayerNetwork model,
      String statsFileName,
      INDArrayDataSetIterator testData) {
    this.data = data;
    this.copyData = copyData;
    this.testData = testData;
    this.model = model;
    this.statsFileName = statsFileName;
    //
    //    List<List<Double>> points = new ArrayList<List<Double>>();
    //    for (int i = 0; i < data.size(); i++) {
    //      List<Double> point = new ArrayList<Double>();
    //      point.add(data.get(i).getKey().data().getDouble(0));
    //      point.add(data.get(i).getKey().data().getDouble(1));
    //      points.add(point);
    //    }
    //    for (int i = 0; i < testData.size(); i++) {
    //      List<Double> point = new ArrayList<Double>();
    //      point.add(testData.get(i).getKey().data().getDouble(0));
    //      point.add(testData.get(i).getKey().data().getDouble(1));
    //      points.add(point);
    //    }
    //    //   Here is where we initialize the graph in the UI
  }

  /**
   * Train the model set through the constructor and created using the NeuralNet class.
   *
   * @param verbose Should you print to the logger.
   * @return
   */
  public Object[] trainModel(boolean verbose) {

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

    File statsFile = new File(statsFileName);
    StatsStorage statsStorage = new FileStatsStorage(statsFile);
    ArrayList<Integer> predictions = new ArrayList<Integer>();

    if (verbose) {
      log.info(model.summary());
      log.info("Training model...");
    }

    model.setListeners(new StatsListener(statsStorage), new ScoreIterationListener(1));

    model.fit(data);


    double trainScore = model.score();
    double testScore = model.score(testData.next());

    if (verbose) {
      log.info(String.format("Train Score is %s", trainScore));
      log.info(String.format("Test Score is %s", testScore));
    }

    System.out.println("Start While");
//    Evaluation eval = new Evaluation(2);
    System.out.println(data);
    while (copyData.hasNext()) {
      DataSet t = copyData.next();
      INDArray features = t.getFeatureMatrix();
      INDArray predicted = model.output(features, false);
      System.out.println("Predicted Now:");
      System.out.println(predicted);

      int[] batchPredictions = NDArrayUtil.toInts(predicted);
      for (int i = 0; i<batchPredictions.length; i++) {
        predictions.add(batchPredictions[i]);
      }
    }
    System.out.println("Predictions Now:");
    System.out.println(predictions);
//    while (testData.hasNext()) {
//      DataSet t = testData.next();
//      INDArray features = t.getFeatureMatrix();
//      INDArray predicted = model.output(features, false);
//      //        Here is where we make the graph in the UI
//    }

    if (verbose) {
      log.info("Training completed");
    }

    ArrayList<Integer> intList = new ArrayList<Integer>(predictions.size());
    for (int i : predictions)
    {
      intList.add(i);
    }

    Object[] outputs = new Object[3];
    outputs[0] = trainScore;
    outputs[1] = testScore;
    outputs[2] = intList;
    return outputs;
  }

  public INDArrayDataSetIterator getData() {
    return data;
  }

  public INDArrayDataSetIterator getTestData() {
    return testData;
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
}
