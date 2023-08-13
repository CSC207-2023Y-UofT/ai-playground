package com.playground.playground.controller;

import com.playground.playground.interface_adapter.controller.DataAttributesController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.Assert.assertEquals;

/** 
This class tests DataAttributesController using the TestFx framework. 
*/
class DataAttributesControllerTest extends ApplicationTest {
    private DataAttributesController controller;
    private Slider slider1;
    private Slider slider2;
    private Slider slider3;
    int min;
    int max;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/playground/playground/data-attributes-view.fxml"));
        Scene scene = new Scene(loader.load());
        controller = loader.getController();
        stage.setScene(scene);
        stage.show();

        slider1 = (Slider) scene.lookup("#slider1");
        slider2 = (Slider) scene.lookup("#slider2");
        slider3 = (Slider) scene.lookup("#slider3");
    }

    @Before
    public void setUp(){
        controller = new DataAttributesController();
    }
    /**
     * This tests initializeTestRatio method to ensure the user selected value from the slider is registered
     * correctly for subsequent use in training.
     */
    @Test
    public void testInitializeTestRatio(){
        min = 0;
        max = 100;
        double newValue = min + (int)(Math.random() * ((max-min) + 1));
        interact(() -> {
            slider1.setValue(newValue);
            controller.initializeTestRatio(new MouseEvent(MouseEvent.MOUSE_DRAGGED, 0, 0, 0, 0, null, 0, false, false, false, false,false, false, false, false, false, false, null));
        });
        assertEquals((int) newValue, DataAttributesController.initializeTestRatio);
    }

    /**
     * This tests initializeNoise method to ensure the user selected value from the slider is registered
     * correctly for subsequent use in training.
     */
    @Test
    public void testInitializeNoise(){
        min = 0;
        max = 50;
        double newValue = min + (int)(Math.random() * ((max - min) + 1));
        interact(() -> {
            slider2.setValue(newValue);
            controller.initializeTestRatio(new MouseEvent(MouseEvent.MOUSE_DRAGGED, 0, 0, 0, 0, null, 0, false, false, false, false,false, false, false, false, false, false, null));
        });
        assertEquals((int) newValue, DataAttributesController.initializeNoise);
    }
    /**
     * This tests initializeBatchSize method to ensure the user selected value from the slider is registered
     * correctly for subsequent use in training.
     */
    @Test
    public void testInitializeBatchSize(){
        min = 0;
        max = 30;
        double newValue = min + (int)(Math.random() * ((max - min) + 1));
        interact(() -> {
            slider3.setValue(newValue);
            controller.initializeTestRatio(new MouseEvent(MouseEvent.MOUSE_DRAGGED, 0, 0, 0, 0, null, 0, false, false, false, false,false, false, false, false, false, false, null));
        });
        assertEquals((int) newValue, DataAttributesController.initializeBatchSize);
    }
    /**
     * This tests handleClusterButton method to ensure the user selected value from the button menu is registered
     * correctly for subsequent use in training.
     */
    @Test
    public void testHandleClusterButton(){
        controller.handleCLusterButton(new ActionEvent());
        assertEquals("cluster", DataAttributesController.dataset);
    }

    /**
     * This tests handleRadialButton method to ensure the user selected value from the button menu is registered
     * correctly for subsequent use in training.
     */
    @Test
    public void testHandleRadialButton(){
        controller.handleRadialButton(new ActionEvent());
        assertEquals("circular", DataAttributesController.dataset);
    }

    /**
     * This tests handleSpiralButton method to ensure the user selected value from the button menu is registered
     * correctly for subsequent use in training.
     */
    @Test
    public void testHandleSpiralButton(){
        controller.handleSpiralButton(new ActionEvent());
        assertEquals("spiral", DataAttributesController.dataset);
    }

    /**
     * This tests handleRectangularButton method to ensure the user selected value from the button menu is registered
     * correctly for subsequent use in training.
     */
    @Test
    public void testHandleRectangularButton(){
        controller.handleRectangularButton(new ActionEvent());
        assertEquals("quadrant", DataAttributesController.dataset);
    }
}
