package com.playground.playground;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import java.net.URL;
import java.util.ResourceBundle;


public class DataAttributesController implements Initializable {
   @FXML
   private Slider slider1;


   @FXML
   private Slider slider2;


   @FXML
   private Slider slider3;


   @FXML
   private Label slider1label;


   @FXML
   private Label slider2label;


   @FXML
   private Label slider3label;
   @FXML
   private Button clusterButton;


   @FXML
   private Button radialButton;


   @FXML
   private Button spiralButton;


   @FXML
   private Button rectangularButton;


   /**
    * Initializer for DataAttributesController.java
    * @param location
    * The location used to resolve relative paths for the root object, or
    * {@code null} if the location is not known.
    *
    * @param resources
    * The resources used to localize the root object, or {@code null} if
    * the root object was not localized.
    */
   public void initialize(URL location, ResourceBundle resources) {


       slider1.valueProperty().addListener((observable, oldValue, newValue) -> {
           updateSlider1Percent(slider1, slider1label);
       });


       slider2.valueProperty().addListener((observable, oldValue, newValue) -> {
           updateSlider2Percent(slider2, slider2label);
       });


       slider3.valueProperty().addListener((observable, oldValue, newValue) -> {
           updateSlider3Percent(slider3, slider3label);
       });


       setButtonFixedSize(clusterButton);
       setButtonFixedSize(radialButton);
       setButtonFixedSize(spiralButton);
       setButtonFixedSize(rectangularButton);
   }


   /**
    * Slider for users to adjust the ratio of training to test data percentage.
    * @param slider allows user to adjust the ratio of training to test data percentage.
    * @param percentLabel displays the percent selected by the user using slider.
    */
   private void updateSlider1Percent(Slider slider, Label percentLabel) {
       double value = slider.getValue();
       double max = slider.getMax();
       double percentage = (value / max) * 100;
       long roundedPercentage = Math.round(percentage);
       percentLabel.setText("Ratio of training to test data: " + roundedPercentage + "%");
   }


   /**
    * Slider for users to adjust the noise.
    * @param slider allows user to adjust the noise.
    * @param numberLabel displays the noise value selected by the using the slider.
    */
   private void updateSlider2Percent(Slider slider, Label numberLabel) {
       int value = (int) slider.getValue();
       String stringVal = String.format("%d", value);
       numberLabel.setText("Noise: " + stringVal);
   }


   /**
    * Slider for users to adjust the batch size.
    * @param slider allows user to adjust the batch size.
    * @param numberLabel displays the batch size value selected by the using the slider.
    */
   private void updateSlider3Percent(Slider slider, Label numberLabel) {
       int value = (int) slider.getValue();
       String stringVal = String.format("%d", value);
       numberLabel.setText("Batch size: " + stringVal);
   }


   private void setButtonFixedSize(Button button) {
       button.setPrefSize(70, 50);
   }
}

