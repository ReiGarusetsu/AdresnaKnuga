package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Second {

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnOk;

    @FXML
    private TextField textPhone;

    @FXML
    private TextField textPip;

    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
        textPip.setText(person.getPip());
        textPhone.setText(person.getPhone());
    }

    @FXML
    void save(ActionEvent event) {
        person.setPip(textPip.getText());
        person.setPhone(textPhone.getText());
        cancel(event);
    }

    @FXML
    void cancel(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }

}
