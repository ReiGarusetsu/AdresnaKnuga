package com.example.demo1;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;


public class OtherLabs implements Initializable {

    @FXML
    private ImageView photo;

    @FXML
    private Label titleText;

    @FXML
    private Button yesButton;

    Image image = new Image(getClass().getResourceAsStream("Image/second.jpg"));

    @FXML
    private CheckBox firstAns;

    @FXML
    private CheckBox fourAns;

    @FXML
    private CheckBox secAns;

    @FXML
    private CheckBox thdAns;

    @FXML
    private Label ansText;

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
    private Label radioAnswer;

    @FXML
    private Label comboAnswer;

    private ToggleGroup toggleGroup = new ToggleGroup();

    @FXML
    private AnchorPane windowAnchorPane;

    private Stage stage;

    @FXML
    private RadioMenuItem clearText;

    @FXML
    private RadioMenuItem randomText;

    @FXML
    private ToggleGroup toggleContGroup;

    @FXML
    private TextField textField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Label lblDate;

    @FXML
    private AnchorPane ancPane;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private Slider mySlider;

    @FXML
    private Label lblSlider;

    @FXML
    private ImageView imgView;

    int score;

    @FXML
    private AnchorPane anchorPane;

   @FXML
   private Button btnPause;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnReset;

    @FXML
    private MediaView mediaView;

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        file = new File("video.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);

        mediaView.setMediaPlayer(mediaPlayer);

//        mySlider.valueProperty().addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
//                score = (int) mySlider.getValue();
//
//                lblSlider.setText(score + " балів");
//            }
//        });

//        ansText.setText("");
//
//        comboAnswer.setText("");
//
//        chcBox.getItems().addAll("Правильно","Неправильно");
//
//        combOption.getItems().addAll("BorderPane", "AncorePane","VBox", "HBox");
//
//        radioCode.setToggleGroup(toggleGroup);
//        radioHier.setToggleGroup(toggleGroup);
//        radioProp.setToggleGroup(toggleGroup);
//        radioLay.setToggleGroup(toggleGroup);

    }

    @FXML
    void bntReset_method(ActionEvent event) {

        if (mediaPlayer.getStatus() != MediaPlayer.Status.READY){
            mediaPlayer.seek(Duration.ZERO);
            mediaPlayer.play();
        }

    }

    @FXML
    void btnPause_method(ActionEvent event) {
        mediaPlayer.pause();
    }

    @FXML
    void btnPlay_method(ActionEvent event) {
        mediaPlayer.play();
    }


    @FXML
    void fileChooser(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Get the image");

        Stage stage1 = (Stage) ancPane.getScene().getWindow();

        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("image","*.jpg"));

        File file = fileChooser.showOpenDialog(stage1);

        if(file != null){

            URI uri = file.toURI();
            Image image1 = new Image(uri.toString());

            imgView.setImage(image1);

        }
    }

    @FXML
    void setBackground(ActionEvent event) {

        Color myColor = colorPicker.getValue();

        ancPane.setBackground(new Background(new BackgroundFill(myColor,null,null)));

    }

    @FXML
    void selectedDate(ActionEvent event) {

        LocalDate selDate = datePicker.getValue();

        lblDate.setText("Today is " + selDate.format(DateTimeFormatter.ofPattern("dd.MM.yy")));

    }

    @FXML
    void changeLbPt(ActionEvent event) {

        photo.setImage(image);
        titleText.setText("Ви успішно змінили картинку!");
        yesButton.setDisable(true);

    }


    @FXML
    void answerShow(ActionEvent event) {
        String answer = "";
        if (firstAns.isSelected() && secAns.isSelected() && thdAns.isSelected()) {
            answer = "Ваша відповідь правильна";
        } else {
            answer = "Ваша відповідь неправильна";
        }

        this.ansText.setText(answer);
    }

    @FXML
    void choiceAnsShow(ActionEvent event) {

        if (chcBox.getValue() == "Правильно"){
            chcAnsText.setText("Ваша відповідь неправильна");
        } else {
            chcAnsText.setText("Ваша відповідь правильна");
        }
    }

    @FXML
    void showComboAnswer(ActionEvent event) {

        if (combOption.getValue() == "BorderPane") {
            comboAnswer.setText("Ваша відповідь правильна");
        }else {
            comboAnswer.setText("Ваша відповідь неправильна");
        }
    }

    @FXML
    void radioShowAnswer(ActionEvent event) {

        if (this.toggleGroup.getSelectedToggle().equals(radioProp)){
            radioAnswer.setText("Ваша відповідь правильна");
        }else {
            radioAnswer.setText("Ваша відповідь неправильна");
        }
    }

    @FXML
    void actionClose(ActionEvent event) {

        stage = (Stage) windowAnchorPane.getScene().getWindow();
        stage.close();

    }

    @FXML
    void contMenu(ActionEvent event) {

        if (toggleContGroup.getSelectedToggle().equals(this.randomText)){
            textField.setText("Random Text");
        }
        if (toggleContGroup.getSelectedToggle().equals(this.clearText)){
            textField.setText("");
        }

    }

}
