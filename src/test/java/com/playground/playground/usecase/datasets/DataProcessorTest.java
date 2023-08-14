package com.playground.playground.usecase.datasets;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.playground.playground.entity.DatasetGenerator;
import com.playground.playground.usecase.datasets.DataProcessor;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

/** Test class to validate the functionality of the {@link DataProcessor} class. */
class DataProcessorTest {

  /** Test the {@link DataProcessor#process(int)} method. */
  @Test
  void testProcess() {
    // Create a mock DatasetGenerator
    DatasetGenerator datasetGenerator = mock(DatasetGenerator.class);

    // Create a mock generated dataset
    ArrayList<ArrayList<ArrayList<Double>>> mockGeneratedData = new ArrayList<>();
    when(datasetGenerator.generate(anyInt())).thenReturn(mockGeneratedData);

    // Create a DataProcessor instance with the mock DatasetGenerator
    DataProcessor dataProcessor = new DataProcessor(datasetGenerator);

    // Call the process method and ensure it returns the mockGeneratedData
    int noise = 5;
    ArrayList<ArrayList<Object>> result = dataProcessor.process(noise);
    assertNotNull(result);
    assertEquals(mockGeneratedData, result);

    // Verify that the generate method was called with the correct argument
    verify(datasetGenerator).generate(noise);
  }
}
