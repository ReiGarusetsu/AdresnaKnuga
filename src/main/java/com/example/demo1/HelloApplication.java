package com.example.demo1;

import com.example.demo1.collection.CollectionAddressBook;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Fxml/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);

        stage.setTitle("Адресна книга");
        stage.setMinHeight(600);
        stage.setMinWidth(600);

        HelloController controller = fxmlLoader.getController();
        controller.setNewStage(stage);

        scene.getStylesheets().add((getClass().getResource("Style/design.css")).toExternalForm());

        stage.setOnCloseRequest(windowEvent -> {
            close(stage);
        });

        stage.setScene(scene);

        stage.show();
        test();
    }

    public void test(){
        CollectionAddressBook collectionAddressBook = new CollectionAddressBook();
        collectionAddressBook.fillTestData();
        collectionAddressBook.print();

    }

    @FXML
    void close(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Вихід з програми");

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add((getClass().getResource("Style/design.css")).toExternalForm());

        alert.setContentText("Ви впевненні, що хочете вийти із програми? ");

        if (alert.showAndWait().get() == ButtonType.OK)
            stage.close();
            System.out.println("Ви успішно вийшли із програми");
    }

    public static void main(String[] args) {
        launch();
    }
}