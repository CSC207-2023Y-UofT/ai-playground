module com.playground.playground {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
                requires org.kordamp.ikonli.javafx;
                
    opens com.playground.playground to javafx.fxml;
    exports com.playground.playground;
}