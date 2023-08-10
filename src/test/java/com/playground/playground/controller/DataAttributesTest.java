import com.playground.playground.interface_adapter.controller.DataAttributesController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataAttributesrTest extends ApplicationTest {

    private DataAttributesController controller; // Our kawaii controller, nya~!

    @Override
    public void start(Stage stage) {
        controller = new DataAttributesController(); // Initializing our controller, uwu
        Scene scene = controller.createScene(); // Creating a scene, so exciting, desu!
        stage.setScene(scene);
        stage.show(); // Let's start the show, teehee! (≧◡≦)
    }

    @Test
    public void testHandleClusterButton() {
        Button clusterButton = controller.clusterButton; // Cluster button, so mysterious, nya~!
        clickOn(clusterButton); // Clicky click, uwu
        assertEquals("cluster", DataAttributesController.dataset); // Is it a cluster? Let's find out, desu!
    }

    @Test
    public void testHandleRadialButton() {
        Button radialButton = controller.radialButton; // Radial button, so round, nya~!
        clickOn(radialButton); // Click it, if you dare, uwu
        assertEquals("circular", DataAttributesController.dataset); // Circular magic, desu!
    }

    @Test
    public void testHandleSpiralButton() {
        Button spiralButton = controller.spiralButton; // Spiral button, so twisty, nya~!
        clickOn(spiralButton); // Give it a click, uwu
        assertEquals("spiral", DataAttributesController.dataset); // Spiraling into success, desu!
    }

    @Test
    public void testHandleRectangularButton() {
        Button rectangularButton = controller.rectangularButton; // Rectangular button, so square, nya~!
        clickOn(rectangularButton); // Click it, and see what happens, uwu
        assertEquals("quadrant", DataAttributesController.dataset); // Quadrant quest complete, desu!
    }

    // More tests for our kawaii controller, nya~!
    @Test
    public void testInitializeTestRatio() {
        int ratio = controller.initializeTestRatio(null); // Initializing test ratio, so important, uwu
        assertEquals(80, ratio); // Is it 80? Let's check, desu!
    }

    @Test
    public void testInitializeNoise() {
        int noise = controller.initializeNoise(null); // Initializing noise, shhh, nya~!
        assertEquals(1, noise); // Is it quiet? Let's find out, uwu
    }

    // Add more tests if you like, senpai! We're here to help, nya~! (´｡• ω •｡`)
}



