package com.playground.playground.modelling;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.playground.playground.clean_architecture.interface_adapter.ModelTrainingServices;
import org.deeplearning4j.datasets.iterator.INDArrayDataSetIterator;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.primitives.Pair;

public class ModelTrainingServicesTest {

  private List trainingData;
  private List testData;
  private MultiLayerNetwork model;

  public static Pair<INDArray, INDArray> buildDataset(final boolean bitA, final boolean bitB) {
    final double[] input = new double[2];
    final double[] labels = new double[1];

    //  Just some code to compute the labels
    for (int idx = 0; idx < labels.length; ++idx) {
      final boolean result = bitA && bitB;
      input[idx * 2] = bitA ? 1.0 : 0.0;
      input[idx * 2 + 1] = bitB ? 1.0 : 0.0;
      labels[idx] = result ? 1.0 : 0.0;
    }

    return Pair.create(Nd4j.create(input), Nd4j.create(labels));
  }

  @BeforeEach
  public void setUp() {
    // Initialize the data, model, and testData before each test
    trainingData = buildData();
    testData = buildData();
    model = mock(MultiLayerNetwork.class);
  }

  // Example on the kind of data we need, example for a simple "and" operation dataset, we want
  // the same, two or more numbers for the features and 1 number (1 or 0) for label.

  @Test
  public void testModelTrainingServicesConstructor() {
    // Given
    String statsFileName = "test_stats_file";

    // When
    ModelTrainingServices service =
        new ModelTrainingServices(trainingData, model, statsFileName, testData);
    // Then
    assertEquals(trainingData, service.getData());
    assertEquals(testData, service.getTestData());
    assertEquals(model, service.getModel());
    assertEquals(statsFileName, service.getStatsFileName());
  }

  public List<Pair<INDArray, INDArray>> buildData() {
    final ArrayList<Pair<INDArray, INDArray>> result = new ArrayList<>(4);

    for (final boolean bitA : new boolean[] {true, false}) {
      for (final boolean bitB : new boolean[] {true, false}) {
        result.add(buildDataset(bitA, bitB));
      }
    }

    return result;
  }

  public DataSetIterator buildIterator(int batchSize) {
    if (trainingData == null) {
      trainingData = buildData();
      // shuffle the data, so we get a different order between resumed trainings - helps a bit
      // escaping
      // when the network is "stuck"
      Collections.shuffle(trainingData);
    }
    return new INDArrayDataSetIterator(trainingData, batchSize);
  }

  @Test
  public void testTrainModel() {
    // Given
    int epochs = 10;
    int batchSize = 32;
    boolean verbose = false;

    // Create a mock DataSetIterator for training and testing
    DataSetIterator mockTrainingDataset = buildIterator(batchSize);
    DataSetIterator mockTestDataset = buildIterator(batchSize);

    ModelTrainingServices service =
        new ModelTrainingServices(trainingData, model, "test_stats_file", testData);

    // When
    service.trainModel(epochs, batchSize, verbose);

    // Then
    assertTrue(model.score() < 0.5);
  }
}
