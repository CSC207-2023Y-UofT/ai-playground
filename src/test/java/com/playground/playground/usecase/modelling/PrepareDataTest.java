package com.playground.playground.usecase.modelling;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.playground.playground.usecase.modelling.PrepareData;
import java.util.ArrayList;
import java.util.List;
import org.deeplearning4j.datasets.iterator.INDArrayDataSetIterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.primitives.Pair;

class PrepareDataTest {

  private PrepareData prepareData;
  private List<Pair<INDArray, INDArray>> trainingData;
  private List<Pair<INDArray, INDArray>> testingData;
  private int batchSize;

  @BeforeEach
  void setUp() {
    // Initialize test datasets before each test
    batchSize = 32;
    trainingData = new ArrayList<>();
    testingData = new ArrayList<>();
    prepareData = new PrepareData(batchSize, trainingData, testingData);
  }

  @Test
  void testGetDataset() {
    // Add some dummy datasets to the training dataset
    INDArray features1 = Nd4j.create(new double[] {1.0, 2.0, 3.0});
    INDArray labels1 = Nd4j.create(new double[] {0.0, 1.0});
    Pair<INDArray, INDArray> dataPair1 = new Pair<>(features1, labels1);
    trainingData.add(dataPair1);

    INDArray features2 = Nd4j.create(new double[] {4.0, 5.0, 6.0});
    INDArray labels2 = Nd4j.create(new double[] {1.0, 0.0});
    Pair<INDArray, INDArray> dataPair2 = new Pair<>(features2, labels2);
    trainingData.add(dataPair2);

    // Get the dataset using the PrepareData class
    INDArrayDataSetIterator dataset = prepareData.getDataset();

    // Assert that the dataset is not null
    assertNotNull(dataset);

    // Assert that the batch size is correct
    assertEquals(batchSize, dataset.batch());
  }

  @Test
  void testGetTestDataset() {
    // Add some dummy datasets to the testing dataset
    INDArray features1 = Nd4j.create(new double[] {1.0, 2.0, 3.0});
    INDArray labels1 = Nd4j.create(new double[] {0.0, 1.0});
    Pair<INDArray, INDArray> dataPair1 = new Pair<>(features1, labels1);
    testingData.add(dataPair1);

    INDArray features2 = Nd4j.create(new double[] {4.0, 5.0, 6.0});
    INDArray labels2 = Nd4j.create(new double[] {1.0, 0.0});
    Pair<INDArray, INDArray> dataPair2 = new Pair<>(features2, labels2);
    testingData.add(dataPair2);

    // Get the testing dataset using the PrepareData class
    INDArrayDataSetIterator testDataset = prepareData.getTestDataset();

    // Assert that the test dataset is not null
    assertNotNull(testDataset);

    // Assert that the batch size is correct (1 in this case)
    assertEquals(1, testDataset.batch());
  }
}
