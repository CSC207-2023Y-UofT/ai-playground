module com.playground.playground {
    requires javafx.controls;
    requires javafx.fxml;
<<<<<<< Updated upstream
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
                requires org.kordamp.ikonli.javafx;
                
=======

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

>>>>>>> Stashed changes
    opens com.playground.playground to javafx.fxml;
    exports com.playground.playground;
}