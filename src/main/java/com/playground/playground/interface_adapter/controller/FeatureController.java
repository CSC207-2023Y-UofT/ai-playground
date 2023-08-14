package com.playground.playground.interface_adapter.controller;

import com.playground.playground.entity.DatasetGenerator;
import com.playground.playground.entity.DatasetType;
import com.playground.playground.entity.FeatureApplier;
import com.playground.playground.usecase.datasets.DataGeneratorFactory;
import com.playground.playground.usecase.datasets.DataProcessor;
import com.playground.playground.usecase.features.FeatureApplierFactory;
import java.util.ArrayList;
import java.util.List;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.primitives.Pair;

/**
 * FeatureController is responsible for managing the creation and manipulation of datasets for
 * training purposes. It includes methods for generating specific datasets with noise and applying
 * selected features to the datasets.
 */
public class FeatureController {

  /**
   * Creates a dataset for the training datasets. It applies all the features given by the user to
   * create a single dataset in the INDArray which is the correct format for training.
   *
   * @param dataName Represents which dataset has been chosen by the user.
   * @param featureNames List of features that have been selected by the user.
   * @param noise Int represent the noise of datasets
   * @return dataset in Neural Net configuration containing original x and y values, and all
   *     applicable features
   */
  public static List<Pair<INDArray, INDArray>> createTrainingData(
      String dataName, ArrayList<String> featureNames, int noise) {
    // Get the raw datasets with noise based on the dataName
    ArrayList<ArrayList<Object>> data = getData(dataName, noise);

    // Apply each selected feature to the datasets
    for (String featureName : featureNames) {
      FeatureApplier feature = FeatureApplierFactory.getFeature(featureName);
      data = feature.applyFeature(data);
    }

    // Convert the processed datasets into the appropriate format for training
    List<Pair<INDArray, INDArray>> dataset = new ArrayList<>();
    for (ArrayList<Object> points : data) {
      ArrayList<Double> coords = (ArrayList<Double>) points.get(0);
      double[] target = new double[coords.size()];
      for (int i = 0; i < target.length; i++) {
        target[i] = coords.get(i);
      }
      INDArray coord = Nd4j.create(target);
      final double[] labels = new double[1];
      labels[0] = (double) (Integer) points.get(1);
      INDArray weight = Nd4j.create(labels);
      Pair<INDArray, INDArray> point = Pair.create(coord, weight);
      dataset.add(point);
    }
    return dataset;
  }

  /**
   * Generates the required dataset.
   *
   * @param dataName Name of the required dataset
   * @param noise amount of noise in the dataset
   * @return A dataset in the datasets format
   */
  private static ArrayList<ArrayList<Object>> getData(String dataName, int noise) {
    // Convert the dataName to a DatasetType enum
    DatasetType datasetType = DatasetType.valueOf(dataName.toUpperCase());

    // Create the necessary generator and processor for the dataset
    DatasetGenerator datasetGenerator = DataGeneratorFactory.createDataGenerator(datasetType);
    DataProcessor dataProcessor = new DataProcessor(datasetGenerator);

    // Process the dataset with noise
    return dataProcessor.process(noise);
  }
}
