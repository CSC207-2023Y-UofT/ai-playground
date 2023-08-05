package com.playground.playground.modelling;

import org.deeplearning4j.datasets.iterator.INDArrayDataSetIterator;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.primitives.Pair;

import java.util.List;

public class PrepareData {
    private int batchSize;
    private final List<Pair<INDArray, INDArray>> data;
    private final List<Pair<INDArray, INDArray>> testData;

    public PrepareData(int batchSize, List<Pair<INDArray, INDArray>> data, List<Pair<INDArray, INDArray>> testData) {
        this.data = data;
        this.testData = testData;
        this.batchSize = batchSize;
    }

    public INDArrayDataSetIterator getDataset() {
        INDArrayDataSetIterator dataset = new INDArrayDataSetIterator(data, batchSize);
        return dataset;
    }

    public INDArrayDataSetIterator getTestDataset() {
        INDArrayDataSetIterator testDataset = new INDArrayDataSetIterator(testData, 1);
        return testDataset;
    }
}
