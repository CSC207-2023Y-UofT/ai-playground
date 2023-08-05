package com.playground.playground;

import java.util.ArrayList;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * DataService is a class that provides a shared dataset between different controllers. It uses
 * JavaFX properties to allow other classes to observe changes to the dataset.
 */
public class DataService {
  private final ObjectProperty<ArrayList<ArrayList<ArrayList<Double>>>> dataset =
      new SimpleObjectProperty<>();

  private static DataService instance;

  // Private constructor to prevent direct instantiation
  private DataService() {}

  /**
   * Method to get an instance of the DataService class. If the instance does not exist, it is
   * created.
   *
   * @return the instance of the DataService class
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
   * @return the current dataset
   */
  public ArrayList<ArrayList<ArrayList<Double>>> getDataset() {
    return dataset.get();
  }

  /**
   * Sets the dataset to a new value.
   *
   * @param dataset the new dataset
   */
  public void setDataset(ArrayList<ArrayList<ArrayList<Double>>> dataset) {
    this.dataset.set(dataset);
  }

  /**
   * Gets the dataset property.
   *
   * <p>This method is used to add listeners to the dataset property, so that other classes can be
   * notified when the dataset changes.
   *
   * @return the dataset property
   */
  public ObjectProperty<ArrayList<ArrayList<ArrayList<Double>>>> datasetProperty() {
    return dataset;
  }
}
