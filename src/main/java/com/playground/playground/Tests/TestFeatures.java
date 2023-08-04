package com.playground.playground.Tests;
import com.playground.playground.data.*;
import com.playground.playground.data.TransformDatasets;
import java.util.ArrayList;
import java.util.Objects;


public class TestFeatures {
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

        // Create FeatureController instance
        FeatureController controller = new FeatureController();

        // Apply x^2 feature to the data set
        ArrayList<ArrayList<Object>> XsquaredData = new SquareFeatureApplier(0).applyFeature(transformedData);

        // Apply sin(y) feature
        ArrayList<ArrayList<Object>> ySinData = new SinFeatureApplier(1).applyFeature(transformedData);

        // Apply X*Y feature
        ArrayList<ArrayList<Object>> XYData = new MultiplyFeatureApplier().applyFeature(transformedData);

        // Run the tests
        testXsquaredOutput(XsquaredData);
        testCreateTrainingData();

    }


    private static void testXsquaredOutput(ArrayList<ArrayList<Object>> XsquaredData){
        ArrayList<Double> correct = new ArrayList<>();
        correct.add(1.0);
        correct.add(9.0);
        correct.add(25.0);
        correct.add(49.0);

        for(int i = 0; i < correct.size(); i++){
            ArrayList<Object> datapoint = XsquaredData.get(i);
            ArrayList<Double> coords = (ArrayList<Double>) datapoint.get(0);
            Double x_squared = coords.get(2);
            assert Objects.equals(x_squared, correct.get(i));
        }

    }
    private static void testCreateTrainingData() {
        try {
            String dataName = "cluster";
            ArrayList<String> featureNames = new ArrayList<>();
            featureNames.add("squareX");
            featureNames.add("sinY");
            int noise = 10;

            // Call the createTrainingData function
            ArrayList<ArrayList<Object>> trainingData = FeatureController.createTrainingData(dataName, featureNames, noise);

            for(int i = 0; i < 4; i++){
                ArrayList<Object> datapoint = trainingData.get(i);
                ArrayList<Double> coords = (ArrayList<Double>) datapoint.get(0);
                System.out.println("Coordinates of datapoint " + (i+1) + ": " + coords);
            }
        } catch (Exception e) {
            System.out.println("testCreateTrainingData failed: unexpected exception " + e);
        }
    }

}
