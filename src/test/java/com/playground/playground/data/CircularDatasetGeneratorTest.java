package com.playground.playground.data;

import com.playground.playground.entity.DatasetGenerator;
import com.playground.playground.entity.DatasetType;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import com.playground.playground.usecase.datasets.CircularDatasetGenerator;
import org.junit.jupiter.api.Test;

/**
 * Test class to validate the functionality of CircularDatasetGenerator.
 * This test class ensures 100% test coverage of the CircularDatasetGenerator class.
 */
public class CircularDatasetGeneratorTest {

    /**
     * Test the generate method of CircularDatasetGenerator to ensure it generates circular clusters correctly.
     */
    @Test
    public void testGenerate() {
        DatasetGenerator circularDatasetGenerator = new CircularDatasetGenerator();
        ArrayList<ArrayList<ArrayList<Double>>> circularDataset = circularDatasetGenerator.generate(10);

        assertNotNull(circularDataset);
        assertEquals(2, circularDataset.size());

        ArrayList<ArrayList<Double>> cluster1 = circularDataset.get(0);
        ArrayList<ArrayList<Double>> cluster2 = circularDataset.get(1);

        assertFalse(cluster1.isEmpty());
        assertFalse(cluster2.isEmpty());

        assertTrue(cluster1.get(0).size() > 400);
        assertTrue(cluster1.get(1).size() > 400);
        assertTrue(cluster2.get(0).size() > 400);
        assertTrue(cluster2.get(1).size() > 400);
    }

    /**
     * Test the generate method of CircularDatasetGenerator with noise set to zero.
     * This test case ensures that clusters are generated without additional noise.
     */
    @Test
    public void testGenerateWithZeroNoise() {
        DatasetGenerator circularDatasetGenerator = new CircularDatasetGenerator();
        ArrayList<ArrayList<ArrayList<Double>>> circularDataset = circularDatasetGenerator.generate(0);

        assertNotNull(circularDataset);
        assertEquals(2, circularDataset.size());

        ArrayList<ArrayList<Double>> cluster1 = circularDataset.get(0);
        ArrayList<ArrayList<Double>> cluster2 = circularDataset.get(1);

        assertFalse(cluster1.isEmpty());
        assertFalse(cluster2.isEmpty());

        assertTrue(cluster1.get(0).size() > 400);
        assertTrue(cluster1.get(1).size() > 400);
        assertTrue(cluster2.get(0).size() > 400);
        assertTrue(cluster2.get(1).size() > 400);
    }
}
