package com.playground.playground.interface_adapter.modelling;

import com.playground.playground.DataService;
import java.util.ArrayList;
import org.deeplearning4j.datasets.iterator.INDArrayDataSetIterator;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** This is the class that facilitates training the model and logging. */
public class ModelTrainingServices {
  private final Logger log = LoggerFactory.getLogger(ModelTrainingServices.class);
  private final INDArrayDataSetIterator data;
  private final INDArrayDataSetIterator testData;
  //  private final INDArrayDataSetIterator copyData;
  private MultiLayerNetwork model;
  private String statsFileName;

  /**
   * Constructor for the ModelTrainingServices class which initializers the datasets and model.
   *
   * @param data The training dataset.
   * @param model The model DAG.
   * @param statsFileName The name of the logging file which will be saved to the disk.
   * @param testData The testing dataset.
   */
  public ModelTrainingServices(
      INDArrayDataSetIterator data,
      //      INDArrayDataSetIterator copyData,
      MultiLayerNetwork model,
      String statsFileName,
      INDArrayDataSetIterator testData) {
    this.data = data;
    //    this.copyData = copyData;
    this.testData = testData;
    this.model = model;
    this.statsFileName = statsFileName;
    //
    //    List<List<Double>> points = new ArrayList<List<Double>>();
    //    for (int i = 0; i < datasets.size(); i++) {
    //      List<Double> point = new ArrayList<Double>();
    //      point.add(datasets.get(i).getKey().datasets().getDouble(0));
    //      point.add(datasets.get(i).getKey().datasets().getDouble(1));
    //      points.add(point);
    //    }
    //    for (int i = 0; i < testData.size(); i++) {
    //      List<Double> point = new ArrayList<Double>();
    //      point.add(testData.get(i).getKey().datasets().getDouble(0));
    //      point.add(testData.get(i).getKey().datasets().getDouble(1));
    //      points.add(point);
    //    }
    //    //   Here is where we initialize the graph in the UI
  }

  /**
   * Train the model set through the constructor and created using the NeuralNet class.
   *
   * @param verbose Should you print to the logger?
   * @return An ArrayList with trainingScore, testingScore and an ArrayList of Predictions.
   */
  public Object[] trainModel(boolean verbose) {

    //    Example on the kind of datasets we need, example for a simple "and" operation dataset, we
    // want
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

    //    File statsFile = new File(statsFileName);
    //    StatsStorage statsStorage = new FileStatsStorage(statsFile);
    ArrayList<Double> predictions = new ArrayList<Double>();

    if (verbose) {
      log.info(model.summary());
      log.info("Training model...");
    }
    //
    //    model.setListeners(new StatsListener(statsStorage), new ScoreIterationListener(1));
    data.reset();
    model.fit(data);

    double trainScore = model.score();

    if (!testData.hasNext()) {
      testData.reset();
    }
    double testScore = model.score(testData.next());

    if (verbose) {
      log.info(String.format("Train Score is %s", trainScore));
      log.info(String.format("Test Score is %s", testScore));
    }
    DataService dataService = DataService.getInstance();
    dataService.setTrainScore(trainScore);
    dataService.setTestScore(testScore);

    System.out.println("Start While");
    //    Evaluation eval = new Evaluation(2);
    System.out.println(data);
    data.reset();
    while (data.hasNext()) {
      DataSet t = data.next();
      INDArray features = t.getFeatureMatrix();
      INDArray predicted = model.output(features);
      System.out.println("Predicted Now:");
      System.out.println(features);
      System.out.println(predicted);

      double[] batchPredictions = predicted.data().asDouble();
      for (int i = 0; i < batchPredictions.length; i++) {
        predictions.add(batchPredictions[i]);
      }
    }
    // System.out.println("Predictions Now:");
    // System.out.println(predictions);
    //    while (testData.hasNext()) {
    //      DataSet t = testData.next();
    //      INDArray features = t.getFeatureMatrix();
    //      INDArray predicted = model.output(features, false);
    //      //        Here is where we make the graph in the UI
    //    }

    if (verbose) {
      log.info("Training completed");
    }

    ArrayList<Double> intList = new ArrayList<Double>(predictions.size());
    for (double i : predictions) {
      intList.add(i);
    }

    Object[] outputs = new Object[4];
    outputs[0] = trainScore;
    outputs[1] = testScore;
    outputs[2] = intList;
    return outputs;
  }

  /**
   * @return The training dataset.
   */
  public INDArrayDataSetIterator getData() {
    return data;
  }

  /**
   * @return The testing dataset.
   */
  public INDArrayDataSetIterator getTestData() {
    return testData;
  }

  /**
   * @return Get the model.
   */
  public MultiLayerNetwork getModel() {
    return model;
  }

  /**
   * @param model The model to set.
   */
  public void setModel(MultiLayerNetwork model) {
    this.model = model;
  }

  /**
   * @return The name of the logging stats file.
   */
  public String getStatsFileName() {
    return statsFileName;
  }

  /**
   * @param statsFileName The stats file name to set.
   */
  public void setStatsFileName(String statsFileName) {
    this.statsFileName = statsFileName;
  }
}
