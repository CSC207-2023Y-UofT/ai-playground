package com.playground.playground.usecase.datasets;

import static org.junit.jupiter.api.Assertions.*;

import com.playground.playground.entity.DatasetGenerator;
import com.playground.playground.usecase.datasets.ClusterDatasetGenerator;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

/**
 * Test class to validate the functionality of ClusterDatasetGenerator. This test class ensures 100%
 * test coverage of the ClusterDatasetGenerator class.
 */
public class ClusterDatasetGeneratorTest {

  /**
   * Test the generate method of ClusterDatasetGenerator to ensure it generates clusters correctly.
   */
  @Test
  public void testGenerate() {
    DatasetGenerator clusterDatasetGenerator = new ClusterDatasetGenerator();
    ArrayList<ArrayList<ArrayList<Double>>> clusterDataset = clusterDatasetGenerator.generate(10);

    assertNotNull(clusterDataset);
    assertEquals(2, clusterDataset.size());

    ArrayList<ArrayList<Double>> cluster1 = clusterDataset.get(0);
    ArrayList<ArrayList<Double>> cluster2 = clusterDataset.get(1);

    assertFalse(cluster1.isEmpty());
    assertFalse(cluster2.isEmpty());

    assertTrue(cluster1.get(0).size() > 400);
    assertTrue(cluster1.get(1).size() > 400);
    assertTrue(cluster2.get(0).size() > 400);
    assertTrue(cluster2.get(1).size() > 400);
  }

  /**
   * Test the generateCluster method of ClusterDatasetGenerator with specified parameters. This test
   * case ensures that the generateCluster method generates clusters correctly with provided
   * parameters.
   */
  @Test
  public void testGenerateCluster() {
    double centerX = 2.0;
    double centerY = 3.0;
    double stdDeviation = 1.5;
    int size = 1000;
    int noise = 10;

    ArrayList<ArrayList<Double>> cluster =
        ClusterDatasetGenerator.generateCluster(centerX, centerY, stdDeviation, size, noise);

    assertNotNull(cluster);
    assertEquals(2, cluster.size());

    ArrayList<Double> xCoords = cluster.get(0);
    ArrayList<Double> yCoords = cluster.get(1);

    assertFalse(xCoords.isEmpty());
    assertFalse(yCoords.isEmpty());

    assertEquals(size + 10 * noise, xCoords.size());
    assertEquals(size + 10 * noise, yCoords.size());
  }
}
