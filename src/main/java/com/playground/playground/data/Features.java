package com.playground.playground.data;
import java.util.ArrayList;

public class Features {

    /**
     * Helper function to build a 2D array with the squared (or transformed) values and the other values in the
     * correct order (based on the provided axis), and adds it to the dataset.
     *
     * @param axis the axis of the coordinates that were squared (0 = x-axis, 1 = y-axis)
     * @param squaredDataset the 3D dataset that the squaredData is added to
     * @param squaredData the 2D array that contains the squared (or transformed) values and other values
     * @param otherValues the values from the axis that were not squared (or transformed)
     * @param squaredValues the squared (or transformed) values from the specified axis
     */
    private static void buildAxisArray(int axis, ArrayList<ArrayList<ArrayList<Double>>> squaredDataset,
                                       ArrayList<ArrayList<Double>> squaredData, ArrayList<Double> otherValues,
                                       ArrayList<Double> squaredValues) {
        if (axis == 0) {
            squaredData.add(squaredValues);
            squaredData.add(new ArrayList<>(otherValues));
        } else {
            squaredData.add(new ArrayList<>(otherValues));
            squaredData.add(squaredValues);
        }
        squaredDataset.add(squaredData);
    }
    /**
     * Squares the values of either the x or y-axis of a dataset
     *
     * @param dataset the 3D ArrayList dataset provided by GenerateDatasets
     * @param axis the axis of the coordinates to be squared (0 = x-axis, 1 = y-axis)
     *
     * @return a new dataset with the correct axis values squared and the other axis unchanged
     */
    public static ArrayList<ArrayList<ArrayList<Double>>>
    squareVal(ArrayList<ArrayList<ArrayList<Double>>> dataset, int axis) {
        ArrayList<ArrayList<ArrayList<Double>>> squaredDataset = new ArrayList<>();
        for (ArrayList<ArrayList<Double>> data : dataset) {
            ArrayList<ArrayList<Double>> squaredData = new ArrayList<>();
            ArrayList<Double> valuesToSquare = data.get(axis);
            ArrayList<Double> otherValues = data.get(1 - axis);
            ArrayList<Double> squaredValues = new ArrayList<>();
            for (Double value : valuesToSquare) {
                squaredValues.add(value * value);
            }
            buildAxisArray(axis, squaredDataset, squaredData, otherValues, squaredValues);
        }
        return squaredDataset;
        //0 REFERS TO X-AXIS 1 = Y-AXIS
    }

    /**
     * Applies the sin function to the values of either the x or y-axis of a dataset.
     *
     * @param dataset the 3D ArrayList dataset provided by GenerateDatasets
     * @param axis the axis of the coordinates to apply the sin function to (0 = x-axis, 1 = y-axis)
     *
     * @return a new dataset with the sin function applied to the values of the correct axis and the other axis
     * unchanged
     */
    public static ArrayList<ArrayList<ArrayList<Double>>>
    sinVal(ArrayList<ArrayList<ArrayList<Double>>> dataset, int axis) {
        ArrayList<ArrayList<ArrayList<Double>>> resultDataset = new ArrayList<>();
        for (ArrayList<ArrayList<Double>> data : dataset) {
            ArrayList<ArrayList<Double>> transformedData = new ArrayList<>();
            ArrayList<Double> valuesToTransform = data.get(axis);
            ArrayList<Double> otherValues = data.get(1 - axis);
            ArrayList<Double> transformedValues = new ArrayList<>();
            for (Double value : valuesToTransform) {
                transformedValues.add(Math.sin(value));
            }
            buildAxisArray(axis, resultDataset, transformedData, otherValues, transformedValues);
        }
        return resultDataset;
    }

    /**
     * Multiplies the x and y values of each data point in the provided dataset.
     *
     * @param dataset the 3D ArrayList dataset provided by GenerateDatasets
     *
     * @return a new dataset where each original pair of x and y values has been replaced by a single
     *         value which is the result of their multiplication.
     */
    public static ArrayList<ArrayList<ArrayList<Double>>>
    multiplyVal(ArrayList<ArrayList<ArrayList<Double>>> dataset) {
        ArrayList<ArrayList<ArrayList<Double>>> resultDataset = new ArrayList<>();

        for (ArrayList<ArrayList<Double>> data : dataset) {
            ArrayList<Double> xValues = data.get(0);
            ArrayList<Double> yValues = data.get(1);

            ArrayList<ArrayList<Double>> multipliedData = new ArrayList<>();
            ArrayList<Double> multipliedValues = new ArrayList<>();

            for (int i = 0; i < xValues.size(); i++) {
                multipliedValues.add(xValues.get(i) * yValues.get(i));
            }

            multipliedData.add(multipliedValues);
            resultDataset.add(multipliedData);
        }

        return resultDataset;
    }
}
