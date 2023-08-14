package com.playground.playground.interface_adapter.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MlParametersControllerTest {

  private MlParametersController controller;

  @BeforeEach
  public void setUp() {
    controller = new MlParametersController();
  }

  @Test
  public void testHandleProblem() {
    String problem = "Regression";
    String result = controller.handleProblem(problem);
    assertEquals(problem, result);
  }

  @Test
  public void testHandleRegularizationRate() {
    double rate = 0.5;
    double result = controller.handleRegularizationRate(rate);
    assertEquals(rate, result);
  }

  @Test
  public void testHandleRegularization() {
    String regularization = "l2";
    String result = controller.handleRegularization(regularization);
    assertEquals(regularization, result);
  }

  @Test
  public void testHandleActivation() {
    String activation = "ReLU";
    String result = controller.handleActivation(activation);
    assertEquals(activation, result);
  }

  @Test
  public void testHandleLearningRate() {
    double learningRate = 0.01;
    double result = controller.handleLearningRate(learningRate);
    assertEquals(learningRate, result);
  }
}
