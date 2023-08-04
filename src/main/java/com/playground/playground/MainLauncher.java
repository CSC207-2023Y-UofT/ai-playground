package com.playground.playground;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainLauncher {

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

  private static void launchApplication(String[] args) throws Exception {
    FXMLLoader fxmlLoader = new FXMLLoader(MainLauncher.class.getResource("main-view.fxml"));
    Parent root = fxmlLoader.load();
    Scene scene = new Scene(root, 1366, 768);
    scene.getStylesheets().add(MainLauncher.class.getResource("style.css").toExternalForm());

    Stage stage = new Stage();
    stage.setTitle("Tensorflow Playground");
    stage.setScene(scene);
    stage.show();
  }
}
