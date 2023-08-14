package com.playground.playground.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataAttributesControllerTest {

    private DataAttributesController controller;

    @BeforeEach
    public void setUp(){
        controller = new DataAttributesController();
    }
    @Test
    public void testSetSlider1Percent(){
        double value = 30;
        double max = 100;
        long expected = 30;
        long actual = controller.setSlider1Percent(value, max);
        assertEquals(expected, actual);
        assertEquals(expected, DataAttributesController.initializeTestRatio);
    }

    @Test
    public void testSetSlider2Percent(){
        int value = 11;
        String expected = "11";
        String actual = controller.setSlider2Percent(value);
        assertEquals(expected, actual);
        assertEquals(value, DataAttributesController.initializeNoise);
    }

    @Test
    public void testSetSlider3Percent() {
        int value = 17;
        String expected = "17";
        String actual = controller.setSlider3Percent(value);
        assertEquals(expected, actual);
        assertEquals(value, DataAttributesController.initializeBatchSize);
    }

    @Test
    public void testInitializeTestRatio() {
        int newRatio = 63;
        int actual = controller.initializeTestRatio(newRatio);
        assertEquals(newRatio, actual);
        assertEquals(newRatio, DataAttributesController.initializeTestRatio);
    }

    @Test
    public void testInitializeNoise() {
        int newNoise = 7;
        int actual = controller.initializeNoise(newNoise);
        assertEquals(newNoise, actual);
        assertEquals(newNoise, DataAttributesController.initializeNoise);
    }

    @Test
    public void testInitializeBatchSize() {
        int newBatchSize = 27;
        int actual = controller.initializeBatchSize(newBatchSize);
        assertEquals(newBatchSize, actual);
        assertEquals(newBatchSize, DataAttributesController.initializeBatchSize);
    }
}


