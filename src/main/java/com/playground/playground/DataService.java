package com.playground.playground;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.primitives.Pair;

/**
 * DataService is a class that provides a shared dataset between different controllers. It uses
 * JavaFX properties to allow other classes to observe changes to the dataset.
 */
public class DataService {
  private final ObjectProperty<List<Pair<INDArray, INDArray>>> dataset =
      new SimpleObjectProperty<>();
  private final ObjectProperty<ArrayList<Double>> results = new SimpleObjectProperty<>();
  private final DoubleProperty trainScore = new SimpleDoubleProperty();
  private final DoubleProperty testScore = new SimpleDoubleProperty();
  private static DataService instance;

  // Private constructor to prevent direct instantiation
  private DataService() {}

  // Method to get an instance of the DataService class
  public static synchronized DataService getInstance() {
    if (instance == null) {
      instance = new DataService();
    }
    return instance;
  }

  // Getters and setters for the dataset property
  public List<Pair<INDArray, INDArray>> getDataset() {
    return dataset.get();
  }

  public void setDataset(List<Pair<INDArray, INDArray>> dataset) {
    this.dataset.set(dataset);
  }

  public ObjectProperty<List<Pair<INDArray, INDArray>>> datasetProperty() {
    return dataset;
  }

  // Getters and setters for the results property
  public ArrayList<Double> getResults() {
    return results.get();
  }

  public void setResults(ArrayList<Double> results) {
    this.results.set(results);
  }

  public ObjectProperty<ArrayList<Double>> resultsProperty() {
    return results;
  }

  // Getters, setters, and property methods for the trainScore
  public double getTrainScore() {
    return trainScore.get();
  }

  public void setTrainScore(double trainScore) {
    this.trainScore.set(trainScore);
  }

  public DoubleProperty trainScoreProperty() {
    return trainScore;
  }

  // Getters, setters, and property methods for the testScore
  public double getTestScore() {
    return testScore.get();
  }

  public void setTestScore(double testScore) {
    this.testScore.set(testScore);
  }

  public DoubleProperty testScoreProperty() {
    return testScore;
  }
}
