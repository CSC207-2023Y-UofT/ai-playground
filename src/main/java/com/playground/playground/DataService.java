package com.playground.playground;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.primitives.Pair;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
/**
 * DataService is a singleton class that provides a centralized place to store and manage
 * data related to the dataset and results. It exposes properties that can be observed
 * by other parts of the application, allowing for reactive updates when the data changes.
 */
public class DataService {
  private final ObjectProperty<List<Pair<INDArray, INDArray>>> dataset = new SimpleObjectProperty<>();
  private final ObjectProperty<ArrayList<Integer>> results = new SimpleObjectProperty<>();

  private static DataService instance;

  // Private constructor to prevent direct instantiation
  private DataService() {}

  /**
   * Returns the single instance of the DataService class, creating it if necessary.
   *
   * @return The singleton instance of DataService.
   */
  public static synchronized DataService getInstance() {
    if (instance == null) {
      instance = new DataService();
    }
    return instance;
  }

  /**
   * Gets the current dataset.
   *
   * @return The dataset as a list of pairs of INDArrays.
   */
  public List<Pair<INDArray, INDArray>> getDataset() {
    return dataset.get();
  }

  /**
   * Sets the dataset.
   *
   * @param dataset The new dataset to set.
   */
  public void setDataset(List<Pair<INDArray, INDArray>> dataset) {
    this.dataset.set(dataset);
  }

  /**
   * Returns the dataset property.
   *
   * @return The dataset property.
   */
  public ObjectProperty<List<Pair<INDArray, INDArray>>> datasetProperty() {
    return dataset;
  }

  /**
   * Gets the current results.
   *
   * @return The results as an ArrayList of integers.
   */
  public ArrayList<Integer> getResults() {
    return results.get();
  }

  /**
   * Sets the results.
   *
   * @param results The new results to set.
   */
  public void setResults(ArrayList<Integer> results) {
    this.results.set(results);
  }

  /**
   * Returns the results property.
   *
   * @return The results property.
   */
  public ObjectProperty<ArrayList<Integer>> resultsProperty() {
    return results;
  }
}
