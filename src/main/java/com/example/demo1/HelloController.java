package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController{

    @FXML
    private Button buttonAdd;

    @FXML
    private Button extBtn;

    @FXML
    private Button otherLab;

    @FXML
    private ImageView photo;

    @FXML
    private Label titleText;

    @FXML
    private Button yesButton;

    @FXML
    private Label ansText;

    @FXML
    private Button answerBtn;

    @FXML
    private CheckBox firstAns;

    @FXML
    private CheckBox fourAns;

    @FXML
    private CheckBox secAns;

    @FXML
    private CheckBox thdAns;

    @FXML
    private Button ansChoiceBtn;

    @FXML
    private Label chcAnsText;

    @FXML
    private ChoiceBox<String> chcBox;

    @FXML
    private ComboBox<String> combOption;

    @FXML
    private RadioButton radioCode;

    @FXML
    private RadioButton radioHier;

    @FXML
    private RadioButton radioLay;

    @FXML
    private RadioButton radioProp;

    @FXML
    private Label comboAnswer;

    private Stage stage;

    @FXML
    private VBox VBoxScene;

    Image image = new Image(getClass().getResourceAsStream("second.jpg"));

    @FXML
    void showDialog(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("second.fxml"));

        Stage stage = new Stage();
        try {
            Scene scene = new Scene(fxmlLoader.load(),600 , 170);
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        stage.setTitle("Редагування");
        stage.setMinWidth(600);
        stage.setMinHeight(170);
        stage.setResizable(false);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(buttonAdd.getScene().getWindow());
        stage.show();

    }

    @FXML
    void closePrg(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Вихід з програми");

        alert.setContentText("Ви впевненні, що хочете вийти із програми? ");

        if (alert.showAndWait().get() == ButtonType.OK)
            stage = (Stage) VBoxScene.getScene().getWindow();
            stage.close();
            System.out.println("Ви успішно вийшли із програми");
    }

    @FXML
    void nextLab(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("otherLab_1.fxml"));

        Stage stage = new Stage();
        try {
            Scene scene = new Scene(fxmlLoader.load(),600 , 600);
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        stage.setTitle("Інші лабораторні");
        stage.setMinWidth(600);
        stage.setMinHeight(600);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void changeLbPt(ActionEvent event) {

        photo.setImage(image);
        titleText.setText("Ви успішно змінили картинку!");
        yesButton.setDisable(true);

    }

    //@FXML
   // void answerShow(ActionEvent event) {
   //     String answer = "";
   //     if (firstAns.isSelected() && secAns.isSelected() && thdAns.isSelected()) {
   //         answer = "Ваша відповідь правильна";
   //     }
   //     if (fourAns.isSelected()) {
   //         answer = "Ваша відповідь неправильна";
   //     }

   //     this.ansText.setText(answer);
   // }

   // @FXML
   // void choiceAnsShow(ActionEvent event) {

   //     chcBox.getItems().addAll("Правильно","Неправильно");

   //     if (chcBox.getValue() == "Правильно"){
   //         chcAnsText.setText("Ваша відповідь неправильна");
   //     } else {
   //         chcAnsText.setText("Ваша відповідь правильна");
   //     }
   // }

   // @FXML
   // void showComboAnswer(ActionEvent event) {
   //     combOption.getItems().addAll("BorderPane", "AncorePane","VBox", "HBox");

   //     comboAnswer.setText("");
   // }

}