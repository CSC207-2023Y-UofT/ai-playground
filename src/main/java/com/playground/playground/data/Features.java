package com.playground.playground.data;
import scala.Int;

import java.util.ArrayList;

public class Features {

    /**
     * Squares the values of either the x or y-axis of a dataset
     *
     * @param dataset for Example: [ [[x_0, y_0], 0], [[x_1, y_1], 1], [[x_2, y_2], 0], [[x_3, y_3], 1] ]
     * @param axis    the axis of the coordinates to be squared (0 = x-axis, 1 = y-axis) for Example: 0
     * @return a new dataset with the correct axis values squared
     * result Example:
     * [ [[x_0, y_0, x_0^2], 0], [[x_1, y_1, x_1^2], 1], [[x_2, y_2, x_2^2], 0], [[x_3, y_3, x_3^2], 1] ]
     */
    public static ArrayList<ArrayList<Object>>
    squareVal(ArrayList<ArrayList<Object>> dataset, int axis) {
        ArrayList<ArrayList<Object>> newDataset = new ArrayList<>();

        for (ArrayList<Object> datapoint : dataset) {
            ArrayList<Double> coordinates = (ArrayList<Double>) datapoint.get(0);
            Integer state = (Integer) datapoint.get(1);
            Double point = coordinates.get(axis);
            coordinates.add(point * point);
            ArrayList<Object> newDatapoint = new ArrayList<>();
            newDatapoint.add(coordinates);
            newDatapoint.add(state);
            newDataset.add(newDatapoint);
        }
        return newDataset;
    }

    /**
     * Applies the sin function to the values of either the x or y-axis of a dataset.
     *
     * @param dataset the 3D ArrayList dataset provided by GenerateDatasets
     * @param axis    the axis of the coordinates to apply the sin function to (0 = x-axis, 1 = y-axis)
     * @return a new dataset with the sin function applied to the values of the correct axis and the other axis
     * unchanged
     */
    public static ArrayList<ArrayList<Object>>
    sinVal(ArrayList<ArrayList<Object>> dataset, int axis) {
        ArrayList<ArrayList<Object>> newDataset = new ArrayList<>();

        for (ArrayList<Object> datapoint : dataset) {
            ArrayList<Double> coordinates = (ArrayList<Double>) datapoint.get(0);
            Integer state = (Integer) datapoint.get(1);
            Double point = coordinates.get(axis);
            point = Math.sin(point);
            coordinates.add(point);
            ArrayList<Object> newDatapoint = new ArrayList<>();
            newDatapoint.add(coordinates);
            newDatapoint.add(state);
            newDataset.add(newDatapoint);
        }
        return newDataset;
    }

    /**
     * Multiplies the x and y values of each data point in the provided dataset.
     *
     * @param dataset the 3D ArrayList dataset provided by GenerateDatasets
     * @return a new dataset where each original pair of x and y values has been replaced by a single
     * value which is the result of their multiplication.
     */
    public static ArrayList<ArrayList<Object>>
    multiplyVal(ArrayList<ArrayList<Object>> dataset) {
        ArrayList<ArrayList<Object>> newDataset = new ArrayList<>();
        for (ArrayList<Object> datapoint : dataset) {
            ArrayList<Double> coordinates = (ArrayList<Double>) datapoint.get(0);
            Integer state = (Integer) datapoint.get(1);
            Double point = coordinates.get(0) * coordinates.get(1);
            coordinates.add(point);
            ArrayList<Object> newDatapoint = new ArrayList<>();
            newDatapoint.add(coordinates);
            newDatapoint.add(state);
            newDataset.add(newDatapoint);
        }
        return newDataset;
    }

}
