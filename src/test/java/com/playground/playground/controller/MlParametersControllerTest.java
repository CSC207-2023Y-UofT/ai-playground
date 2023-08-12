package com.playground.playground.controller;

import com.playground.playground.interface_adapter.controller.MlParametersController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.Assert.assertEquals;

class MlParametersControllerTest extends ApplicationTest {
    private MlParametersController controller;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/playground/playground/ml-parameters-view.fxml"));
        Scene scene = new Scene(loader.load());
        controller = loader.getController();
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void testHandleLearningRate(){
        clickOn("Learning Rate");
        clickOn("0.003");
        assertEquals(0.003, MlParametersController.handleLearningRate, 0.0001);
    }

    @Test
    public void testActivation(){
        clickOn("Activation");
        clickOn("Tanh");
        assertEquals("Tanh", MlParametersController.handleActivation);
    }

    @Test
    public void testRegularization(){
        clickOn("Regularization");
        clickOn("L2");
        assertEquals("l2", MlParametersController.handleRegularization);
    }

    @Test
    public void testHandleRegularizationRate() {
        // Click on the "Regularization Rate" menu to open it
        clickOn("Regularization Rate");

        // Click on the specific menu item with the text "0.001"
        clickOn("0.001");

        // Assert the expected behavior
        assertEquals(0.001, MlParametersController.handleRegularizationRate, 0.0001);
    }

    @Test
    public void testHandleProblem(){
        clickOn("Problem Type");
        clickOn("Regression");
        assertEquals("Regression", MlParametersController.handleProblem);
    }
}


