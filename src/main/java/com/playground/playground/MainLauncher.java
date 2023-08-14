package com.playground.playground;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    FXMLLoader fxmlLoader = new FXMLLoader(MainLauncher.class.getResource("main-view.fxml"));
    Parent root = fxmlLoader.load();

    // Create a new JavaFX Scene with the loaded FXML content
    Scene scene = new Scene(root, 1366, 768);

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
