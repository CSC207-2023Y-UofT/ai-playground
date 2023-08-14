package com.playground.playground.data;

import static org.junit.jupiter.api.Assertions.*;

import com.playground.playground.entity.DatasetGenerator;
import com.playground.playground.usecase.datasets.QuadrantDatasetGenerator;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

/**
 * Test class to validate the functionality of QuadrantDatasetGenerator. This test class ensures
 * 100% test coverage of the QuadrantDatasetGenerator class.
 */
public class QuadrantDatasetGeneratorTest {

  /**
   * Test the generate method of QuadrantDatasetGenerator to ensure it generates datasets for
   * quadrants correctly.
   */
  @Test
  public void testGenerate() {
    DatasetGenerator quadrantDatasetGenerator = new QuadrantDatasetGenerator();
    ArrayList<ArrayList<ArrayList<Double>>> quadrantDataset = quadrantDatasetGenerator.generate(10);

    assertNotNull(quadrantDataset);
    assertEquals(2, quadrantDataset.size());

    ArrayList<ArrayList<Double>> quadrant1 = quadrantDataset.get(0);
    ArrayList<ArrayList<Double>> quadrant2 = quadrantDataset.get(1);

    assertFalse(quadrant1.isEmpty());
    assertFalse(quadrant2.isEmpty());

    assertTrue(quadrant1.get(0).size() >= 500);
    assertTrue(quadrant1.get(1).size() >= 500);
    assertTrue(quadrant2.get(0).size() >= 500);
    assertTrue(quadrant2.get(1).size() >= 500);
  }

  /**
   * Test the generateQuadrantDataset method of QuadrantDatasetGenerator with specified parameters.
   * This test case ensures that the generateQuadrantDataset method generates datasets for a
   * quadrant correctly.
   */
  @Test
  public void testGenerateQuadrantDataset() {
    int size = 1000;
    int xSign = 1;
    int ySign = -1;
    int noise = 10;

    ArrayList<ArrayList<Double>> quadrantDataset =
        QuadrantDatasetGenerator.generateQuadrantDataset(size, xSign, ySign, noise);

    assertNotNull(quadrantDataset);
    assertEquals(2, quadrantDataset.size());

    ArrayList<Double> xCoords = quadrantDataset.get(0);
    ArrayList<Double> yCoords = quadrantDataset.get(1);

    assertFalse(xCoords.isEmpty());
    assertFalse(yCoords.isEmpty());

    assertEquals(size + 10 * noise, xCoords.size());
    assertEquals(size + 10 * noise, yCoords.size());
  }
}
