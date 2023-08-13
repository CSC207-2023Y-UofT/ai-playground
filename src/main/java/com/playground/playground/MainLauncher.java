package com.playground.playground;

import com.playground.playground.interface_adapter.controller.MainController;
import com.playground.playground.interface_adapter.controller.MainViewController;
import com.playground.playground.interface_adapter.controller.views.ViewFactory;
import com.playground.playground.interface_adapter.controller.views.ViewFactoryImpl;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/** The MainLauncher class is responsible for launching the AI Playground application. */
public class MainLauncher {

  /**
   * The main entry point of the application.
   *
   * @param args The command-line arguments.
   */
  public static void main(String[] args) {
    // Start JavaFX on the JavaFX Application Thread
    Platform.startup(
        () -> {
          try {
            launchApplication(args);
          } catch (Exception e) {
            e.printStackTrace();
          }
        });
  }

  /**
   * Launches the AI Playground application.
   *
   * @param args The command-line arguments.
   * @throws Exception If an exception occurs during application launch.
   */
  private static void launchApplication(String[] args) throws Exception {
    // Create the ViewFactory
    ViewFactory viewFactory = new ViewFactoryImpl();

    // Load the MainViewController
    FXMLLoader loader = new FXMLLoader(MainLauncher.class.getResource("main-view.fxml"));
    VBox mainView = loader.load(); // Load the main view
    MainViewController mainViewController = loader.getController(); // Get the MainViewController

    // Create the MainController and initialize it
    MainController mainController = new MainController(mainViewController, viewFactory);
    mainController.initialize();

    // Create a new JavaFX Scene with the loaded main view
    Scene scene = new Scene(mainView, 1366, 768);

    // Add the stylesheet to the scene
    scene.getStylesheets().add(MainLauncher.class.getResource("style.css").toExternalForm());

    // Create a new JavaFX Stage (window)
    Stage stage = new Stage();
    stage.setTitle("AI Playground");
    stage.setScene(scene);

    // Show the stage to display the application
    stage.show();
  }

}
