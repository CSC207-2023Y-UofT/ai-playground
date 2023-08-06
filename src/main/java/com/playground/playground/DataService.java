package com.playground.playground;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.primitives.Pair;

/**
 * DataService is a class that provides a shared dataset between different controllers. It uses
 * JavaFX properties to allow other classes to observe changes to the dataset.
 */
public class DataService {
  private final ObjectProperty<List<Pair<INDArray, INDArray>>> dataset = new SimpleObjectProperty<>();
  private final ObjectProperty<ArrayList<Integer>> results = new SimpleObjectProperty<>();

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
  public ArrayList<Integer> getResults() {
    return results.get();
  }

  public void setResults(ArrayList<Integer> results) {
    this.results.set(results);
  }

  public ObjectProperty<ArrayList<Integer>> resultsProperty() {
    return results;
  }
}