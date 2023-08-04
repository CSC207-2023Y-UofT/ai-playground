package com.playground.playground.data;

import java.util.ArrayList;
import java.util.List;

public class TransformDatasetsTest {
  public static void main(String[] args) {
    // Create a sample dataset for testing
    ArrayList<ArrayList<ArrayList<Double>>> sampleData = new ArrayList<>();

    // First cluster points
    ArrayList<ArrayList<Double>> cluster0 = new ArrayList<>();
    ArrayList<Double> x0 = new ArrayList<>();
    ArrayList<Double> y0 = new ArrayList<>();
    x0.add(1.0);
    y0.add(2.0);
    x0.add(3.0);
    y0.add(4.0);
    cluster0.add(x0);
    cluster0.add(y0);
    sampleData.add(cluster0);

    // Second cluster points
    ArrayList<ArrayList<Double>> cluster1 = new ArrayList<>();
    ArrayList<Double> x1 = new ArrayList<>();
    ArrayList<Double> y1 = new ArrayList<>();
    x1.add(5.0);
    y1.add(6.0);
    x1.add(7.0);
    y1.add(8.0);
    cluster1.add(x1);
    cluster1.add(y1);
    sampleData.add(cluster1);

    // Perform transformation using TransformDatasets class
    ArrayList<ArrayList<Object>> transformedData = TransformDatasets.transform(sampleData);

    // Run the tests
    testTransformedDataSize(transformedData);
    testClusterWeight(transformedData);
  }

  private static void testTransformedDataSize(ArrayList<ArrayList<Object>> transformedData) {
    // Check if the transformed dataset has the correct size
    int expectedSize = 4; // Total number of points in both clusters
    assert transformedData.size() == expectedSize
        : "Expected transformed dataset size: "
            + expectedSize
            + ", but got: "
            + transformedData.size();
  }

  private static void testClusterWeight(ArrayList<ArrayList<Object>> transformedData) {
    // Check if each point in the transformed dataset has the correct cluster weight
    for (int i = 0; i < transformedData.size(); i++) {
      List<Object> point = transformedData.get(i);
      int weight = (int) point.get(1);
      if (i < 2) {
        assert weight == 0 : "Expected weight for cluster 0, but got: " + weight;
      } else {
        assert weight == 1 : "Expected weight for cluster 1, but got: " + weight;
      }
    }
  }
}
