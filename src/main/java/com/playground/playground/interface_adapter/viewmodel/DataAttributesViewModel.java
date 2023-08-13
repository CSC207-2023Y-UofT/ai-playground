package com.playground.playground.interface_adapter.viewmodel;

import com.playground.playground.interface_adapter.controller.DataAttributesController;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class DataAttributesViewModel {
    public IntegerProperty testRatio = new SimpleIntegerProperty(80);
    public IntegerProperty noise = new SimpleIntegerProperty(1);
    public IntegerProperty batchSize = new SimpleIntegerProperty(20);
    public StringProperty dataset = new SimpleStringProperty("cluster");
    public StringProperty testRatioLabel = new SimpleStringProperty();
    public StringProperty noiseLabel = new SimpleStringProperty();
    public StringProperty batchSizeLabel = new SimpleStringProperty();
    public StringProperty selectedDataset = new SimpleStringProperty("cluster");
    public ObservableList<String> datasets = FXCollections.observableArrayList("cluster", "circular", "spiral", "quadrant");

    public DataAttributesViewModel() {
        testRatio.addListener((observable, oldValue, newValue) -> {
            updateTestRatioLabel();
            DataAttributesController.testRatio = newValue.intValue();
            DataAttributesController.initializeTestRatio = newValue.intValue();
        });
        noise.addListener((observable, oldValue, newValue) -> {
            updateNoiseLabel();
            DataAttributesController.noise = newValue.intValue();
            DataAttributesController.initializeNoise = newValue.intValue();
        });
        batchSize.addListener((observable, oldValue, newValue) -> {
            updateBatchSizeLabel();
            DataAttributesController.initializeBatchSize = newValue.intValue();
            DataAttributesController.batchSize = newValue.intValue();
        });
        selectedDataset.addListener((observable, oldValue, newValue) -> {
            DataAttributesController.dataset = newValue;
        });
        updateTestRatioLabel();
        updateNoiseLabel();
        updateBatchSizeLabel();

        selectedDataset.addListener((observable, oldValue, newValue) -> updateDataset());
    }

    private void updateTestRatioLabel() {
        testRatioLabel.set("Ratio of training to test data: " + testRatio.get() + "%");
    }

    private void updateNoiseLabel() {
        noiseLabel.set("Noise: " + noise.get());
    }

    private void updateBatchSizeLabel() {
        batchSizeLabel.set("Batch size: " + batchSize.get());
    }

    public void setTestRatio(int value) {
        testRatio.set(value);
        DataAttributesController.testRatio = value;
        DataAttributesController.initializeTestRatio = value;
    }

    public void setNoise(int value) {
        noise.set(value);
        DataAttributesController.noise = value;
        DataAttributesController.initializeNoise = value;
    }

    public void setBatchSize(int value) {
        batchSize.set(value);
        System.out.println("batch size" + value);
        DataAttributesController.batchSize = value;
        DataAttributesController.initializeBatchSize = value;
    }

    public void setDataset(String value) {
        dataset.set(value);
    }
    private void updateDataset() {
        dataset.set(selectedDataset.get());
        DataAttributesController.dataset = selectedDataset.get();
    }
    public void selectDataset(String datasetName) {
        selectedDataset.set(datasetName);
    }

}

