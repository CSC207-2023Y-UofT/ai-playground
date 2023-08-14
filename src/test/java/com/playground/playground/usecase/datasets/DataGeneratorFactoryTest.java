package com.playground.playground.usecase.datasets;

import static org.junit.jupiter.api.Assertions.*;

import com.playground.playground.entity.DatasetGenerator;
import com.playground.playground.entity.DatasetType;
import org.junit.jupiter.api.Test;

/** Test class for the DataGeneratorFactory class. */
public class DataGeneratorFactoryTest {

  @Test
  public void testCreateDataGeneratorCircular() {
    DatasetGenerator generator = DataGeneratorFactory.createDataGenerator(DatasetType.CIRCULAR);
    assertTrue(generator instanceof CircularDatasetGenerator);
  }

  @Test
  public void testCreateDataGeneratorCluster() {
    DatasetGenerator generator = DataGeneratorFactory.createDataGenerator(DatasetType.CLUSTER);
    assertTrue(generator instanceof ClusterDatasetGenerator);
  }

  @Test
  public void testCreateDataGeneratorQuadrant() {
    DatasetGenerator generator = DataGeneratorFactory.createDataGenerator(DatasetType.QUADRANT);
    assertTrue(generator instanceof QuadrantDatasetGenerator);
  }

  @Test
  public void testCreateDataGeneratorSpiral() {
    DatasetGenerator generator = DataGeneratorFactory.createDataGenerator(DatasetType.SPIRAL);
    assertTrue(generator instanceof SpiralDatasetGenerator);
  }

  @Test
  public void testCreateDataGeneratorInvalid() {
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          DataGeneratorFactory.createDataGenerator(null);
        },
        "Expected IllegalArgumentException for invalid dataset type");
  }
  @Test
  public void testCreateDataGeneratorInvalidType() {
    assertThrows(
            IllegalArgumentException.class,
            () -> {
              DataGeneratorFactory.createDataGenerator(null);
            },
            "Expected IllegalArgumentException for null dataset type");
  }

  @Test
  public void testCreateDataGeneratorUnknownType() {
    assertThrows(
            IllegalArgumentException.class,
            () -> {
              DataGeneratorFactory.createDataGenerator(DatasetType.UNKNOWN);
            },
            "Expected IllegalArgumentException for unknown dataset type");
  }
}
