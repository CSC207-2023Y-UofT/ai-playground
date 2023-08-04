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
    ArrayList<ArrayList<ArrayList<Double>>> data = getData(dataName, noise);
    ArrayList<ArrayList<Object>> newData = TransformDatasets.transform(data);
    for (String feat : featureNames) {
      newData = applyFeature(feat, newData);
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
  public static ArrayList<ArrayList<ArrayList<Double>>> getData(String dataName, int noise) {
    ArrayList<ArrayList<ArrayList<Double>>> dataset = new ArrayList<>();

    switch (dataName) {
      case "circular":
        dataset = GenerateDatasets.generateCircular(noise);
        break;
      case "cluster":
        dataset = GenerateDatasets.generateClusters(noise);
        break;
      case "quadrant":
        dataset = GenerateDatasets.generateQuadrantDatasets(noise);
        break;
      case "spiral":
        dataset = GenerateDatasets.generateSpiralDatasets(noise);
        break;
      default:
        throw new IllegalArgumentException("Invalid dataset name: " + dataName);
    }
    return dataset;
  }

  /**
   * Applies the required feature to the dataset
   *
   * @param featureName The feature to be applied
   * @param dataset A dataset in the Neural Network Format
   * @return The dataset with the correct feature appended to the coordinates list in the Neural
   *     Network formatted data.
   */
  public static ArrayList<ArrayList<Object>> applyFeature(
      String featureName, ArrayList<ArrayList<Object>> dataset) {
    ArrayList<ArrayList<Object>> newDataset = new ArrayList<>();
    switch (featureName) {
      case "squareX":
        newDataset = Features.squareVal(dataset, 0);
        break;
      case "squareY":
        newDataset = Features.squareVal(dataset, 1);
        break;
      case "XtimesY":
        newDataset = Features.multiplyVal(dataset);
        break;
      case "sinX":
        newDataset = Features.sinVal(dataset, 0);
        break;
      case "sinY":
        newDataset = Features.sinVal(dataset, 1);
        break;
      default:
        throw new IllegalArgumentException("Invalid dataset name: " + featureName);
    }
    return newDataset;
  }
}
