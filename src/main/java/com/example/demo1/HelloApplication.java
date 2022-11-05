package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);

        stage.setTitle("Адресна книга");
        stage.setMinHeight(600);
        stage.setMinWidth(600);

        stage.setOnCloseRequest(windowEvent -> {
            close(stage);
        });

        stage.setScene(scene);

        stage.show();
    }

    @FXML
    void close(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Вихід з програми");

        alert.setContentText("Ви впевненні, що хочете вийти із програми? ");

        if (alert.showAndWait().get() == ButtonType.OK)
            stage.close();
            System.out.println("Ви успішно вийшли із програми");
    }

    public static void main(String[] args) {
        launch();
    }
}