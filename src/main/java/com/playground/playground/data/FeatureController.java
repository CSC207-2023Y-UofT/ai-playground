package com.playground.playground.data;

import java.util.ArrayList;
import com.google.common.primitives.Doubles;
import org.apache.commons.lang.ArrayUtils;
import org.nd4j.linalg.api.buffer.DataBuffer;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.primitives.Pair;

import java.util.Arrays;
import java.util.List;

public class FeatureController {

  /**
   * Creates a dataset for the training data. It applies all the features given by the user to
   * create a single dataset in the correct format for training.
   *
   * @param dataName Represents which dataset has been chosen by the user.
   * PRECONDITION data name must be one of the following: "circular", "cluster", "quadrant", "spiral"
   * @param featureNames List of features that have been selected by the user.  PRECONDITION feature name either empty
   *                     list or a list containing one or more of the following: "squareX", "squareY", "XtimesY",
   *                     "sinX", "sinY"
   * @param noise Int represent the noise of data
   * @return dataset in Neural Net configuration containing original x and y values, and all
   *     applicable features
   */
  public static List<Pair<INDArray, INDArray>> createTrainingData(
      String dataName, ArrayList<String> featureNames, int noise) {
    ArrayList<ArrayList<Object>> data = getData(dataName, noise);

    for (String featureName : featureNames) {
      FeatureApplier feature = FeatureApplierFactory.getFeature(featureName);
      data = feature.applyFeature(data);
    }

    List<Pair<INDArray, INDArray>> dataset = new ArrayList<Pair<INDArray, INDArray>>();
    for (ArrayList<Object> points : data) {
//      double[] coords;
      ArrayList<Double> coords = (ArrayList<Double>) points.get(0);
//      double[] arr = points.get(0).stream().mapToDouble(Double::doubleValue).toArray(); //via method reference
      double[] target = new double[coords.size()];
      for (int i = 0; i < target.length; i++) {
//        target[i] = doubles.get(i).doubleValue();  // java 1.4 style
        // or:
        target[i] = coords.get(i);                // java 1.5+ style (outboxing)
      }
      //      int size = coords.size();
      //      final double[] doubleArray = new double[size];
      //      for (int i = 0; i < size; i++) {
      //        doubleArray[i] = coords.get(i);
      //      }
//      System.out.println(Arrays.toString(target));
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
