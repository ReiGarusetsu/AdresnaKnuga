package com.example.demo1;

import com.example.demo1.collection.CollectionAddressBook;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Button buttonAdd;

    @FXML
    private Button extBtn;

    @FXML
    private Button otherLab;

    private Stage stage;

    @FXML
    private VBox VBoxScene;

    @FXML
    private TableColumn<Person, String> columPhone;

    @FXML
    private TableColumn<Person, String> columPip;

    @FXML
    private TableView<Person> tableView;

    @FXML
    private Label labelCount;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnDelete;

    private CollectionAddressBook collectionAddressBook = new CollectionAddressBook();
    private Stage newStage;
    private Stage secondStage;
    private Parent parent;
    private Second second;
    private FXMLLoader fxmlLoader = new FXMLLoader();

    @FXML
    private TextField textSearch;

    private ObservableList<Person> backupList;


    public void setNewStage(Stage newStage){
        this.newStage = newStage;
    }

    @Override
   public void initialize(URL url, ResourceBundle resourceBundle) {

        columPip.setCellValueFactory(new PropertyValueFactory<>("pip"));
        columPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));

        collectionAddressBook.getPersonList().addListener(new ListChangeListener<Person>() {
            @Override
            public void onChanged(Change<? extends Person> change) {

                updateList();
            }
        });

        collectionAddressBook.fillTestData();

        backupList = FXCollections.observableArrayList();
        backupList.addAll(collectionAddressBook.getPersonList());

        tableView.setItems(collectionAddressBook.getPersonList());


        try {
            fxmlLoader.setLocation(getClass().getResource("Fxml/second.fxml"));
            parent = fxmlLoader.load();
            second = fxmlLoader.getController();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    void actionSearch(ActionEvent event) {

        collectionAddressBook.getPersonList().clear();

        for (Person person: backupList){
            if (person.getPhone().toLowerCase().contains(textSearch.getText().toLowerCase()) ||
                    person.getPip().toLowerCase().contains(textSearch.getText().toLowerCase())) {
                collectionAddressBook.getPersonList().add(person);
            }

        }

    }

    public void updateList(){
        labelCount.setText("Кількість записів: " + collectionAddressBook.getPersonList().size());
    }

    @FXML
    void showDialog(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();

        switch (clickedButton.getId()){
            case "buttonAdd":
                second.setPerson(new Person());
                showWindow();
                collectionAddressBook.save(second.getPerson());
                break;
            case "btnEdit":
                second.setPerson(tableView.getSelectionModel().getSelectedItem());
                showWindow();
                break;
            case "btnDelete":
                break;
        }

    }

    void showWindow(){
        if (secondStage == null){

            secondStage = new Stage();
            Scene scene = new Scene(parent);
            secondStage.setScene(scene);
            secondStage.setTitle("Edit Window");

            secondStage.setResizable(false);
            secondStage.initModality(Modality.WINDOW_MODAL);
            secondStage.initOwner(newStage);
        }

        secondStage.showAndWait();
    }

    @FXML
    void closePrg(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Вихід з програми");

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add((getClass().getResource("Style/design.css")).toExternalForm());


        alert.setContentText("Ви впевненні, що хочете вийти із програми? ");

        if (alert.showAndWait().get() == ButtonType.OK)
            stage = (Stage) VBoxScene.getScene().getWindow();
            stage.close();
            System.out.println("Ви успішно вийшли із програми");
    }

    @FXML
    void nextLab(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Fxml/audio.fxml"));

        Stage stage = new Stage();
        try {
            Scene scene = new Scene(fxmlLoader.load(),800 , 600);
            stage.setScene(scene);
            scene.getStylesheets().add((getClass().getResource("Style/design.css")).toExternalForm());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        stage.setTitle("Інші лабораторні");
        stage.setMinWidth(600);
        stage.setMinHeight(600);
        stage.setResizable(false);
        stage.show();
    }


}