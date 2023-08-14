package com.playground.playground.data;

import static org.junit.jupiter.api.Assertions.*;

import com.playground.playground.usecase.datasets.TransformDatasets;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

/** Test class to validate the functionality of the TransformDatasets class. */
public class TransformDatasetsTest {

  /** Test transforming a dataset with points from two clusters. */
  @Test
  public void testTransform() {
    ArrayList<ArrayList<ArrayList<Double>>> inputDataset = new ArrayList<>();

    ArrayList<ArrayList<Double>> cluster0 = new ArrayList<>();
    ArrayList<Double> x0 = new ArrayList<>();
    ArrayList<Double> y0 = new ArrayList<>();
    x0.add(1.0);
    y0.add(2.0);
    cluster0.add(x0);
    cluster0.add(y0);

    ArrayList<ArrayList<Double>> cluster1 = new ArrayList<>();
    ArrayList<Double> x1 = new ArrayList<>();
    ArrayList<Double> y1 = new ArrayList<>();
    x1.add(3.0);
    y1.add(4.0);
    cluster1.add(x1);
    cluster1.add(y1);

    inputDataset.add(cluster0);
    inputDataset.add(cluster1);

    ArrayList<ArrayList<Object>> transformedDataset = TransformDatasets.transform(inputDataset);

    assertNotNull(transformedDataset);
    assertEquals(2, transformedDataset.size());

    ArrayList<Object> point0 = transformedDataset.get(0);
    assertEquals(2, point0.size());
    assertTrue(point0.get(0) instanceof ArrayList);
    assertTrue(point0.get(1) instanceof Integer);

    ArrayList<Object> point1 = transformedDataset.get(1);
    assertEquals(2, point1.size());
    assertTrue(point1.get(0) instanceof ArrayList);
    assertTrue(point1.get(1) instanceof Integer);
  }

  /** Test transforming an empty dataset. */
  @Test
  public void testTransformEmptyDataset() {
    ArrayList<ArrayList<ArrayList<Double>>> emptyDataset = new ArrayList<>();
    ArrayList<ArrayList<Object>> transformedDataset = TransformDatasets.transform(emptyDataset);

    assertNotNull(transformedDataset);
    assertTrue(transformedDataset.isEmpty());
  }

  /** Test transforming a dataset with one empty cluster. */
  @Test
  public void testTransformOneEmptyCluster() {
    ArrayList<ArrayList<ArrayList<Double>>> inputDataset = new ArrayList<>();

    ArrayList<ArrayList<Double>> cluster0 = new ArrayList<>();
    // cluster0 is intentionally left empty

    ArrayList<ArrayList<Double>> cluster1 = new ArrayList<>();
    ArrayList<Double> x1 = new ArrayList<>();
    ArrayList<Double> y1 = new ArrayList<>();
    x1.add(3.0);
    y1.add(4.0);
    cluster1.add(x1);
    cluster1.add(y1);

    inputDataset.add(cluster0);
    inputDataset.add(cluster1);

    ArrayList<ArrayList<Object>> transformedDataset = TransformDatasets.transform(inputDataset);

    assertNotNull(transformedDataset);
    assertEquals(1, transformedDataset.size());

    ArrayList<Object> point1 = transformedDataset.get(0);
    assertEquals(2, point1.size());
    assertTrue(point1.get(0) instanceof ArrayList);
    assertTrue(point1.get(1) instanceof Integer);
  }
}
