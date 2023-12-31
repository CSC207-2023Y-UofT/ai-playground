package com.playground.playground.usecase.modelling;

import java.util.Collections;
import java.util.List;
import org.deeplearning4j.datasets.iterator.INDArrayDataSetIterator;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.primitives.Pair;

/** This class helps make datasets ready for the model training. */
public class PrepareData {
  private final List<Pair<INDArray, INDArray>> data;
  private final List<Pair<INDArray, INDArray>> testData;
  private final int batchSize;

  /**
   * Default constructor for PrepareData.
   *
   * @param batchSize Batch size for the training datasets.
   * @param data Training Dataset.
   * @param testData Testing Dataset.
   */
  public PrepareData(
      int batchSize, List<Pair<INDArray, INDArray>> data, List<Pair<INDArray, INDArray>> testData) {
    this.data = data;
    this.testData = testData;
    this.batchSize = batchSize;
  }

  /**
   * @return The transformed training dataset
   */
  public INDArrayDataSetIterator getDataset() {
    Collections.shuffle(data);
    INDArrayDataSetIterator dataset = new INDArrayDataSetIterator(data, batchSize);
    return dataset;
  }

  /**
   * @return The transformed testing dataset.
   */
  public INDArrayDataSetIterator getTestDataset() {
    Collections.shuffle(testData);
    INDArrayDataSetIterator testDataset = new INDArrayDataSetIterator(testData, 1);
    return testDataset;
  }
}
