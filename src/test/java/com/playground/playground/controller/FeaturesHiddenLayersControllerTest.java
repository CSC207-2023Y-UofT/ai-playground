package com.playground.playground.controller;

import com.playground.playground.interface_adapter.controller.FeaturesHiddenLayersController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

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

    @Test
    public void testToggleButtonSelection() {
        //Click on squareX button
        Button x1pow2button = lookup("#x1pow2button").queryButton();
        clickOn(x1pow2button);
        //Check class variable contains squareX
        assertEquals(new ArrayList<>(Arrays.asList("squareX")), FeaturesHiddenLayersController.getSelectedButtons());
        //Click on squareX button
        clickOn(x1pow2button);
        //Check selectedButtons is empty
        assertEquals(new ArrayList<>(), FeaturesHiddenLayersController.getSelectedButtons());
        // Click on squareX button
        clickOn(x1pow2button);
        // Click on squareY button
        Button x2pow2button = lookup("#x2pow2button").queryButton();
        clickOn(x2pow2button);
        // Click on x1x2 button
        Button x1x2button = lookup("#x1x2button").queryButton();
        clickOn(x1x2button);
        // Click on sinx1 button
        Button sinx1button = lookup("#sinx1button").queryButton();
        clickOn(sinx1button);
        // Click on sinx2 button
        Button sinx2button = lookup("#sinx2button").queryButton();
        clickOn(sinx2button);

        // Check selectedButtons contains all buttons
        assertEquals(new ArrayList<>(Arrays.asList("squareX", "squareY", "XtimesY", "sinX", "sinY")), FeaturesHiddenLayersController.getSelectedButtons());
    }


    @Test
    public void testOnAddLayerClicked() {
        assertEquals(1, FeaturesHiddenLayersController.numHiddenLayersAccess);
        clickOn("#addLayer");
        assertEquals(2, FeaturesHiddenLayersController.numHiddenLayersAccess);
    }

    @Test
    public void testOnRemoveLayerClicked() {
        assertEquals(1, FeaturesHiddenLayersController.numHiddenLayersAccess);
        clickOn("#removeLayer");
        assertEquals(0, FeaturesHiddenLayersController.numHiddenLayersAccess);
    }

    @Test
    public void testOnAddButtonClicked() {
        assertEquals(1, FeaturesHiddenLayersController.aButtonsCountsAccess[0]);
        clickOn("#addLayer");
        clickOn("#add1");
        assertEquals(2, FeaturesHiddenLayersController.aButtonsCountsAccess[0]);
    }

    @Test
    public void testOnRemoveButtonClicked() {
        clickOn("#addLayer");
        clickOn("#add1");
        assertEquals(2, FeaturesHiddenLayersController.aButtonsCountsAccess[0]);
        clickOn("#remove1");
        assertEquals(1, FeaturesHiddenLayersController.aButtonsCountsAccess[0]);
    }

}



