package com.playground.playground.interface_adapter;

import com.playground.playground.usecase.DataProcessor;
import com.playground.playground.entity.DatasetGenerator;

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

    for (String featureName : featureNames) {
      FeatureApplier feature = FeatureApplierFactory.getFeature(featureName);
      data = feature.applyFeature(data);
    }
    return data;
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

        DatasetGenerator datasetGenerator = DataGeneratorFactory.createDataGenerator(dataName);
        DataProcessor dataProcessor = new DataProcessor(datasetGenerator);
        dataset = dataProcessor.process(noise);

        return dataset;
  }
}
