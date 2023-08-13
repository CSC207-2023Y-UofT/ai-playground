package com.playground.playground.controller;

import com.playground.playground.interface_adapter.controller.FeaturesHiddenLayersController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;


public class FeaturesHiddenLayersControllerTest extends ApplicationTest {

    private FeaturesHiddenLayersController controller;


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/playground/playground/features-hidden-layers-view.fxml"));
        stage.setScene(new Scene(loader.load()));
        controller = loader.getController();
        stage.show();
    }

    /**
     * This tests toggleButtonSelection method to ensure the user selected value from the feature menu is registered
     * correctly for subsequent use in training.
     */
    @Test
    public void testToggleButtonSelection() {
        Button x1pow2button = lookup("#x1pow2button").queryButton();
        clickOn(x1pow2button);
        assertEquals(new ArrayList<>(Arrays.asList("squareX")), FeaturesHiddenLayersController.getSelectedButtons());
        clickOn(x1pow2button);
        assertEquals(new ArrayList<>(), FeaturesHiddenLayersController.getSelectedButtons());
        clickOn(x1pow2button);
        Button x2pow2button = lookup("#x2pow2button").queryButton();
        clickOn(x2pow2button);
        Button x1x2button = lookup("#x1x2button").queryButton();
        clickOn(x1x2button);
        Button sinx1button = lookup("#sinx1button").queryButton();
        clickOn(sinx1button);
        Button sinx2button = lookup("#sinx2button").queryButton();
        clickOn(sinx2button);

        assertEquals(new ArrayList<>(Arrays.asList("squareX", "squareY", "XtimesY", "sinX", "sinY")), FeaturesHiddenLayersController.getSelectedButtons());
    }

    /**
     * This tests onAddLayerClicked method to verify that the user selected value for hidden layers is registered and displayed
     * properly and correctly for subsequent use in training.
     */
    @Test
    public void testOnAddLayerClicked() {
        assertEquals(1, FeaturesHiddenLayersController.numHiddenLayersAccess);
        clickOn("#addLayer");
        assertEquals(2, FeaturesHiddenLayersController.numHiddenLayersAccess);
    }

    /**
     * This tests onRemoveLayerClicked method to verify that the user selected value for hidden layers is registered and displayed
     * properly and correctly for subsequent use in training.
     */
    @Test
    public void testOnRemoveLayerClicked() {
        assertEquals(1, FeaturesHiddenLayersController.numHiddenLayersAccess);
        clickOn("#removeLayer");
        assertEquals(0, FeaturesHiddenLayersController.numHiddenLayersAccess);
    }

    /**
     * This tests onAddButtonClicked method to verify that the user selected value for neurons is registered and displayed
     * properly and correctly for subsequent use in training.
     */
    @Test
    public void testOnAddButtonClicked() {
        assertEquals(1, FeaturesHiddenLayersController.aButtonsCountsAccess[0]);
        clickOn("#addLayer");
        clickOn("#add1");
        assertEquals(2, FeaturesHiddenLayersController.aButtonsCountsAccess[0]);
    }

    /**
     * This tests onRemoveButtonClicked method to verify that the user selected value for neurons is registered and displayed
     * properly and correctly for subsequent use in training.
     */
    @Test
    public void testOnRemoveButtonClicked() {
        clickOn("#addLayer");
        clickOn("#add1");
        assertEquals(2, FeaturesHiddenLayersController.aButtonsCountsAccess[0]);
        clickOn("#remove1");
        assertEquals(1, FeaturesHiddenLayersController.aButtonsCountsAccess[0]);
    }

}








