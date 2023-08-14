package com.playground.playground.usecase.datasets;

import static org.junit.jupiter.api.Assertions.*;

import com.playground.playground.usecase.datasets.SpiralDatasetGenerator;
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
}
