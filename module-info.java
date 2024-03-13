module com.example.imagegallery {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.imagegallery to javafx.fxml;
    exports com.example.imagegallery;
}