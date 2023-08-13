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
    @Order(1)
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/playground/playground/features-hidden-layers-view.fxml"));
        stage.setScene(new Scene(loader.load()));
        controller = loader.getController();
        stage.show();
    }

    @Test
    @Order(2)
    public void testSingleToggleButtonSelection() {
        //Click on squareX button
        Button x1pow2button = lookup("#x1pow2button").queryButton();
        clickOn(x1pow2button);
        //Check UI component for squareX button
        assertEquals("-fx-background-color: blue;", x1pow2button.getStyle());
        //Check class variable contains squareX
        assertEquals(new ArrayList<>(Arrays.asList("squareX")), FeaturesHiddenLayersController.getSelectedButtons());
    }

    @Test
    @Order(3)
    public void testSingleToggleButtonDeselection(){
        //Click on squareX button twice
        Button x1pow2button = lookup("#x1pow2button").queryButton();
        clickOn(x1pow2button);
        clickOn(x1pow2button);
        //Check UI component for squareX button
        assertEquals("", x1pow2button.getStyle());
        //Check selectedButtons is empty
        assertEquals(new ArrayList<>(), FeaturesHiddenLayersController.getSelectedButtons());
    }

    @Test
    @Order(4)
    public void testToggleButtonAll(){
        // Click on squareX button
        Button x1pow2button = lookup("#x1pow2button").queryButton();
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

        // Check UI components for all buttons
        assertEquals("-fx-background-color: blue;", x1pow2button.getStyle());
        assertEquals("-fx-background-color: blue;", x2pow2button.getStyle());
        assertEquals("-fx-background-color: blue;", x1x2button.getStyle());
        assertEquals("-fx-background-color: blue;", sinx1button.getStyle());
        assertEquals("-fx-background-color: blue;", sinx2button.getStyle());

        // Check selectedButtons contains all buttons
        assertEquals(new ArrayList<>(Arrays.asList("squareX", "squareY", "XtimesY", "sinX", "sinY")), FeaturesHiddenLayersController.getSelectedButtons());
    }



    @Test
    @Order(5)
    public void testOnAddLayerClicked() {
        Text numHiddenLayers = lookup("#numHiddenLayers").queryText();
        assertEquals("1", numHiddenLayers.getText());
        clickOn("#addLayer");
        assertEquals("2", numHiddenLayers.getText());
    }


    @Test
    @Order(6)
    public void testOnRemoveLayerClicked() {
        Text numHiddenLayers = lookup("#numHiddenLayers").queryText();
        assertEquals("1", numHiddenLayers.getText());
        clickOn("#removeLayer");
        assertEquals("0", numHiddenLayers.getText());
    }

    @Test
    @Order(7)
    public void testOnAddButtonClicked() {
        FxAssert.verifyThat("#neurons1", NodeMatchers.hasChild("1 Neurons"));

        clickOn("#addLayer");
        clickOn("#add1");

        FxAssert.verifyThat("#neurons1", NodeMatchers.hasChild("2 Neurons"));
    }



    @Test
    @Order(8)
    public void testOnRemoveButtonClicked() {
        clickOn("#addLayer");
        clickOn("#add1");
        FxAssert.verifyThat("#neurons1", NodeMatchers.hasChild("2 Neurons"));

        clickOn("#remove1");

        FxAssert.verifyThat("#neurons1", NodeMatchers.hasChild("1 Neurons"));
    }

}



