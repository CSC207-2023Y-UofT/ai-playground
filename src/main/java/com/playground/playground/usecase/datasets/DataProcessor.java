package com.playground.playground.usecase.datasets;

import com.playground.playground.entity.DatasetGenerator;

import java.util.ArrayList;

/**
 * A data processor that takes a dataset generator as input and processes the generated datasets.
 * The DataProcessor applies a transformation on the generated data using the TransformDatasets class.
 */
public class DataProcessor {

    private final DatasetGenerator datasetGenerator;

    /**
     * Constructs a DataProcessor with the specified dataset generator.
     *
     * @param datasetGenerator The dataset generator to use for generating datasets.
     */
    public DataProcessor(DatasetGenerator datasetGenerator) {
        this.datasetGenerator = datasetGenerator;
    }

    /**
     * Processes the generated datasets by applying a transformation.
     *
     * @param noise The number of random points to add as noise to the datasets.
     * @return An ArrayList containing ArrayLists representing the transformed datasets.
     *         Each inner ArrayList contains two objects: a List containing x and y coordinates
     *         of the data points, and an Integer representing a weight or label for the dataset.
     */
    public ArrayList<ArrayList<Object>> process(int noise) {
        ArrayList<ArrayList<ArrayList<Double>>> generatedData = datasetGenerator.generate(noise);
        return TransformDatasets.transform(generatedData);
    }
}
