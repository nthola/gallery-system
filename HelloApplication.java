package com.example.imagegallery;
/*
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}*/

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private final ObservableList<Image> images = FXCollections.observableArrayList(
            new Image("https://unsplash.com/photos/n8tNt7CrKJc"), // Replace with actual image URL
            new Image("https://unsplash.com/photos/y991C_hOakQ"), // Replace with actual image URL
            new Image("https://unsplash.com/photos/9uzJMEPOT00") // Replace with actual image preview URL
    );

    private ImageView fullViewImage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        fullViewImage = new ImageView();

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        int colIndex = 0;
        int rowIndex = 0;

        for (Image image : images) {
            ImageView thumbnail = new ImageView(image);
            thumbnail.setFitWidth(150);
            thumbnail.setFitHeight(100);
            thumbnail.setOnMouseClicked(event -> fullViewImage.setImage(image));
            gridPane.add(thumbnail, colIndex, rowIndex);

            colIndex++;
            if (colIndex == 3) {
                colIndex = 0;
                rowIndex++;
            }
        }

        ScrollPane scrollPane = new ScrollPane(gridPane);

        VBox mainLayout = new VBox(10);
        mainLayout.getChildren().addAll(scrollPane, fullViewImage);

        Scene scene = new Scene(mainLayout, 800, 600);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Image Gallery");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
