package com.playground.playground.interface_adapter.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

class FeaturesHiddenLayersControllerTest {

    private FeaturesHiddenLayersController controller;

    @BeforeEach
    void setUp() {
        controller = new FeaturesHiddenLayersController();
    }

    @Test
    void testSetNumHiddenLayers() {
        controller.setNumHiddenLayers(3);
        assertEquals(3, FeaturesHiddenLayersController.numHiddenLayersAccess);
    }

    @Test
    void testSetLayersNeurons() {
        FeaturesHiddenLayersController.aButtonsCountsAccess = new int[]{3, 4, 5};
        FeaturesHiddenLayersController.numHiddenLayersAccess = 3;

        FeaturesHiddenLayersController.setLayersNeurons();

        assertEquals(3, FeaturesHiddenLayersController.layersNeurons.size());
        assertEquals(3, FeaturesHiddenLayersController.layersNeurons.get(0));
        assertEquals(4, FeaturesHiddenLayersController.layersNeurons.get(1));
        assertEquals(5, FeaturesHiddenLayersController.layersNeurons.get(2));
    }
}
