import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GenerateDatasetsTest {

    @Test
    public void testGenerateCircular() {
        int noise = 5;
        ArrayList<ArrayList<ArrayList<Double>>> dataset = GenerateDatasets.generateCircular(noise);

        // Ensure dataset contains two clusters
        Assertions.assertEquals(2, dataset.size());

        // Ensure each cluster contains two ArrayLists for x and y coordinates
        for (ArrayList<ArrayList<Double>> cluster : dataset) {
            Assertions.assertEquals(2, cluster.size());
            Assertions.assertEquals(1000 + noise * 10, cluster.get(0).size()); // 1000 points + noise
            Assertions.assertEquals(1000 + noise * 10, cluster.get(1).size()); // 1000 points + noise
        }
    }

    @Test
    public void testGenerateClusters() {
        int noise = 5;
        ArrayList<ArrayList<ArrayList<Double>>> clusters = GenerateDatasets.generateClusters(noise);

        // Ensure clusters contain two ArrayLists for x and y coordinates
        for (ArrayList<ArrayList<Double>> cluster : clusters) {
            Assertions.assertEquals(2, cluster.size());
            Assertions.assertEquals(1000 + noise * 10, cluster.get(0).size()); // 1000 points + noise
            Assertions.assertEquals(1000 + noise * 10, cluster.get(1).size()); // 1000 points + noise
        }

        // Ensure the first and second clusters have different center coordinates
        ArrayList<ArrayList<Double>> cluster1 = clusters.get(0);
        ArrayList<ArrayList<Double>> cluster2 = clusters.get(1);
        Assertions.assertNotEquals(cluster1.get(0).get(0), cluster2.get(0).get(0)); // X coordinate
        Assertions.assertNotEquals(cluster1.get(1).get(0), cluster2.get(1).get(0)); // Y coordinate
    }

    @Test
    public void testGenerateQuadrantDatasets() {
        int noise = 5;
        ArrayList<ArrayList<ArrayList<Double>>> datasets = GenerateDatasets.generateQuadrantDatasets(noise);

        // Ensure datasets contain two quadrants
        Assertions.assertEquals(2, datasets.size());

        // Ensure each quadrant dataset contains two ArrayLists for x and y coordinates
        for (ArrayList<ArrayList<Double>> quadrant : datasets) {
            Assertions.assertEquals(2, quadrant.size());
            Assertions.assertEquals(500 + noise * 10, quadrant.get(0).size()); // 500 points + noise
            Assertions.assertEquals(500 + noise * 10, quadrant.get(1).size()); // 500 points + noise
        }
    }

    @Test
    public void testGenerateSpiralDatasets() {
        int noise = 5;
        ArrayList<ArrayList<ArrayList<Double>>> datasets = GenerateDatasets.generateSpiralDatasets(noise);

        // Ensure datasets contain two spiral patterns
        Assertions.assertEquals(2, datasets.size());

        // Ensure each spiral dataset contains two ArrayLists for x and y coordinates
        for (ArrayList<ArrayList<Double>> spiral : datasets) {
            Assertions.assertEquals(2, spiral.size());
            Assertions.assertEquals(500 + noise * 10, spiral.get(0).size()); // 500 points + noise
            Assertions.assertEquals(500 + noise * 10, spiral.get(1).size()); // 500 points + noise
        }
    }

    @Test
    public void testGenerateCircularWithZeroNoise() {
        int noise = 0;
        ArrayList<ArrayList<ArrayList<Double>>> dataset = GenerateDatasets.generateCircular(noise);

        // Ensure dataset contains two clusters
        Assertions.assertEquals(2, dataset.size());

        // Ensure each cluster contains exactly 1000 points (no noise)
        for (ArrayList<ArrayList<Double>> cluster : dataset) {
            Assertions.assertEquals(2, cluster.size());
            Assertions.assertEquals(1000, cluster.get(0).size());
            Assertions.assertEquals(1000, cluster.get(1).size());
        }
    }
}
