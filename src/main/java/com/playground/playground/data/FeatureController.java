package com.playground.playground.data;
import java.util.ArrayList;

public class FeatureController {

        /**
         * The 1st parameter String dataName; represents which dataset has been chosen by the user:
         *  'circular'
         *  'cluster'
         *  'quadrant'
         *  'spiral'
         * The 2nd parameter ArrayList<String> featureName; represents which feature has been just been selected by the user
         * square
         *  'squareX'
         *  'squareY'
         *  'XtimesY'
         *  'sinX'
         *  'sinY'
         * The 3rd parameter Integer noise; represents the noise in the dataset
         */

        public static ArrayList<ArrayList<Object>> createTrainingData(String dataName, ArrayList<String> featureNames,
                                                                              int noise){
            ArrayList<ArrayList<ArrayList<Double>>> data = getData(dataName, noise);
            ArrayList<ArrayList<Object>> newData = TransformDatasets.transform(data);
            for(String feat : featureNames){
                newData = applyFeature(feat, newData);
            }
            return newData;
        }

    /**
     * Each inner ArrayList represents a pair of coordinates (x, y) and the outer ArrayLists represent
     * collections of these coordinate pairs, orange and blue dots.
     */
    public static ArrayList<ArrayList<ArrayList<Double>>> getData(String dataName, int noise) {
        ArrayList<ArrayList<ArrayList<Double>>> dataset = new ArrayList<>();

        switch (dataName) {
            case "circular":
                dataset = GenerateDatasets.generateCircular(noise);
                break;
            case "cluster":
                dataset = GenerateDatasets.generateClusters(noise);
                break;
            case "quadrant":
                dataset = GenerateDatasets.generateQuadrantDatasets(noise);
                break;
            case "spiral":
                dataset = GenerateDatasets.generateSpiralDatasets(noise);
                break;
            default:
                throw new IllegalArgumentException("Invalid dataset name: " + dataName);
        }
        return dataset;
    }


    public static ArrayList<ArrayList<Object>> applyFeature(String featureName,
                                                                       ArrayList<ArrayList<Object>> dataset){
        ArrayList<ArrayList<Object>> newDataset = new ArrayList<>();
            switch (featureName){
                case "squareX":
                    newDataset = Features.squareVal(dataset, 0);
                    break;
                case "squareY":
                    newDataset = Features.squareVal(dataset, 1);
                    break;
                case "XtimesY":
                    newDataset = Features.multiplyVal(dataset);
                    break;
                case "sinX":
                    newDataset = Features.sinVal(dataset, 0);
                    break;
                case "sinY":
                    newDataset = Features.sinVal(dataset, 1);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid dataset name: " + featureName);
            }
            return newDataset;

    }


}

