package com.playground.playground.controller;

import com.playground.playground.interface_adapter.controller.FeaturesHiddenLayersController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

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
        Button x1pow2button = lookup("#x1pow2button").queryButton();
        clickOn(x1pow2button);
        assertEquals("-fx-background-color: blue;", x1pow2button.getStyle());
        clickOn(x1pow2button);
        assertEquals("", x1pow2button.getStyle());
    }

    @Test
    public void testOnAddLayerClicked() {
        Text numHiddenLayers = lookup("#numHiddenLayers").queryText();
        assertEquals("1", numHiddenLayers.getText());
        clickOn("#addLayer");
        assertEquals("2", numHiddenLayers.getText());
    }


    @Test
    public void testOnRemoveLayerClicked() {
        Text numHiddenLayers = lookup("#numHiddenLayers").queryText();
        assertEquals("1", numHiddenLayers.getText());
        clickOn("#removeLayer");
        assertEquals("0", numHiddenLayers.getText());
    }

    @Test
    public void testOnAddButtonClicked() {
        FxAssert.verifyThat("#neurons1", NodeMatchers.hasChild("1 Neurons"));

        clickOn("#addLayer");
        clickOn("#add1");

        FxAssert.verifyThat("#neurons1", NodeMatchers.hasChild("2 Neurons"));
    }



    @Test
    public void testOnRemoveButtonClicked() {
        clickOn("#addLayer");
        clickOn("#add1");
        FxAssert.verifyThat("#neurons1", NodeMatchers.hasChild("2 Neurons"));

        clickOn("#remove1");

        FxAssert.verifyThat("#neurons1", NodeMatchers.hasChild("1 Neurons"));
    }

}



