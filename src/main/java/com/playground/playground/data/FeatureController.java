package com.playground.playground.data;

import java.util.ArrayList;

public class FeatureController {

  /**
   * Creates a dataset for the training data. It applies all the features given by the user to
   * create a single dataset in the correct format for training.
   *
   * @param dataName Represents which dataset has been chosen by the user. Legit names: 'circular'
   *     'cluster' 'quadrant' 'spiral'
   * @param featureNames List of features that have been selected by the user. Must be: 'squareX'
   *     'squareY' 'XtimesY' 'sinX' 'sinY'
   * @param noise Int represent the noise of data
   * @return dataset in Neural Net configuration containing original x and y values, and all
   *     applicable features
   */
  public static ArrayList<ArrayList<Object>> createTrainingData(
      String dataName, ArrayList<String> featureNames, int noise) {
    ArrayList<ArrayList<Object>> data = getData(dataName, noise);
    ArrayList<ArrayList<Object>> newData = new ArrayList<>();

    for (String featureName : featureNames) {
      FeatureApplier feature = FeatureApplierFactory.getFeature(featureName);
      newData = feature.applyFeature(data);
    }
    return newData;
  }

  /**
   * Generates the required dataset
   *
   * @param dataName Name of the required dataset
   * @param noise amount of noise in the dataset
   * @return A dataset in the data format
   */
  public static ArrayList<ArrayList<Object>> getData(String dataName, int noise) {
    ArrayList<ArrayList<Object>> dataset = new ArrayList<>();

    switch (dataName) {
      case "circular":
        DataProcessor dataProcessorCircular = new DataProcessor(new CircularDatasetGenerator());
        dataset = dataProcessorCircular.process(noise);
        break;
      case "cluster":
        DataProcessor dataProcessorCluster = new DataProcessor(new ClusterDatasetGenerator());
        dataset = dataProcessorCluster.process(noise);
        break;
      case "quadrant":
        DataProcessor dataProcessorQuadrant = new DataProcessor(new QuadrantDatasetGenerator());
        dataset = dataProcessorQuadrant.process(noise);
        break;
      case "spiral":
        DataProcessor dataProcessorSpiral = new DataProcessor(new SpiralDatasetGenerator());
        dataset = dataProcessorSpiral.process(noise);
        break;
      default:
        throw new IllegalArgumentException("Invalid dataset name: " + dataName);
    }
    return dataset;
  }
}
