package com.playground.playground.usecase.datasets;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

/** Test class to validate the functionality of the SpiralDatasetGenerator class. */
public class SpiralDatasetGeneratorTest {

  /** Test generating a spiral dataset in the clockwise direction. */
  @Test
  public void testGenerateSpiralDatasetClockwise() {
    ArrayList<ArrayList<Double>> spiralDataset =
        SpiralDatasetGenerator.generateSpiralDataset(100, 1, 2);

    assertNotNull(spiralDataset);
    assertEquals(2, spiralDataset.size());

    ArrayList<Double> xCoordinates = spiralDataset.get(0);
    ArrayList<Double> yCoordinates = spiralDataset.get(1);

    assertEquals(120, xCoordinates.size());
    assertEquals(120, yCoordinates.size());
  }

  /** Test generating a spiral dataset in the counterclockwise direction. */
  @Test
  public void testGenerateSpiralDatasetCounterclockwise() {
    ArrayList<ArrayList<Double>> spiralDataset =
        SpiralDatasetGenerator.generateSpiralDataset(100, -1, 2);

    assertNotNull(spiralDataset);
    assertEquals(2, spiralDataset.size());

    ArrayList<Double> xCoordinates = spiralDataset.get(0);
    ArrayList<Double> yCoordinates = spiralDataset.get(1);

    assertEquals(120, xCoordinates.size());
    assertEquals(120, yCoordinates.size());
  }

  /** Test generating a spiral dataset with zero noise. */
  @Test
  public void testGenerateSpiralDatasetWithZeroNoise() {
    ArrayList<ArrayList<Double>> spiralDataset =
        SpiralDatasetGenerator.generateSpiralDataset(100, 1, 0);

    assertNotNull(spiralDataset);
    assertEquals(2, spiralDataset.size());

    ArrayList<Double> xCoordinates = spiralDataset.get(0);
    ArrayList<Double> yCoordinates = spiralDataset.get(1);

    assertEquals(100, xCoordinates.size());
    assertEquals(100, yCoordinates.size());
  }

  /** Test generating a spiral dataset with negative noise. */
  @Test
  public void testGenerateSpiralDatasetWithNegativeNoise() {
    ArrayList<ArrayList<Double>> spiralDataset =
        SpiralDatasetGenerator.generateSpiralDataset(100, 1, -2);

    assertNotNull(spiralDataset);
    assertEquals(2, spiralDataset.size());

    ArrayList<Double> xCoordinates = spiralDataset.get(0);
    ArrayList<Double> yCoordinates = spiralDataset.get(1);

    assertEquals(100, xCoordinates.size());
    assertEquals(100, yCoordinates.size());
  }

  /** Test generating a large spiral dataset. */
  @Test
  public void testGenerateSpiralDatasetWithLargeSize() {
    ArrayList<ArrayList<Double>> spiralDataset =
        SpiralDatasetGenerator.generateSpiralDataset(10000, 1, 2);

    assertNotNull(spiralDataset);
    assertEquals(2, spiralDataset.size());

    ArrayList<Double> xCoordinates = spiralDataset.get(0);
    ArrayList<Double> yCoordinates = spiralDataset.get(1);

    assertEquals(10020, xCoordinates.size());
    assertEquals(10020, yCoordinates.size());
  }

  /** Test generating an empty spiral dataset. */
  @Test
  public void testGenerateSpiralDatasetWithZeroSize() {
    ArrayList<ArrayList<Double>> spiralDataset =
        SpiralDatasetGenerator.generateSpiralDataset(0, 1, 2);

    assertNotNull(spiralDataset);
    assertEquals(2, spiralDataset.size());

    ArrayList<Double> xCoordinates = spiralDataset.get(0);
    ArrayList<Double> yCoordinates = spiralDataset.get(1);

    assertEquals(20, xCoordinates.size());
    assertEquals(20, yCoordinates.size());
  }

  @Test
  public void testGenerate() {
    SpiralDatasetGenerator generator = new SpiralDatasetGenerator();
    ArrayList<ArrayList<ArrayList<Double>>> datasets = generator.generate(2);

    assertNotNull(datasets);
    assertEquals(2, datasets.size());

    ArrayList<ArrayList<Double>> dataset1 = datasets.get(0);
    ArrayList<ArrayList<Double>> dataset2 = datasets.get(1);

    assertNotNull(dataset1);
    assertNotNull(dataset2);

    assertEquals(2, dataset1.size());
    assertEquals(2, dataset2.size());

    ArrayList<Double> xCoordinates1 = dataset1.get(0);
    ArrayList<Double> yCoordinates1 = dataset1.get(1);
    ArrayList<Double> xCoordinates2 = dataset2.get(0);
    ArrayList<Double> yCoordinates2 = dataset2.get(1);

    assertEquals(520, xCoordinates1.size());
    assertEquals(520, yCoordinates1.size());
    assertEquals(520, xCoordinates2.size());
    assertEquals(520, yCoordinates2.size());
  }
}
