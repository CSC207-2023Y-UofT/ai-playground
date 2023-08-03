package usecases;
import java.util.ArrayList;

public class FeatureController {

        /**
         * The 1st parameter String dataName; represents which dataset has been chosen by the user:
         *  'circular'
         *  'cluster'
         *  'quadrant'
         *  'spiral'
         * The 2nd parameter String featureName; represents which feature has been just been selected by the user
         * square
         *  'squareX'
         *  'squareY'
         *  'XtimesY'
         *  'sinX'
         *  'sinY'
         * The 3rd parameter Integer noise; represents the noise in the dataset
         */

        public static ArrayList<ArrayList<ArrayList<Double>>> addTrainingData(String dataName, String featureName,
                                                                              int noise){
            ArrayList<ArrayList<ArrayList<Double>>> data = getData(dataName, noise);
            return applyFeature(featureName, data);
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


    public static ArrayList<ArrayList<ArrayList<Double>>> applyFeature(String featureName,
                                                                       ArrayList<ArrayList<ArrayList<Double>>> dataset){

            ArrayList<ArrayList<ArrayList<Double>>> newDataset = new ArrayList<>();
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

