package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Member;

public class AddMemberViewController {

    //TODO: Rewrite this class to work with Database


    private ChocAnSysApp main;
    Stage dialog;
    Member member;
    @FXML private TextField textFieldMemberNumber;
    @FXML private TextField textFieldMemberFirstName;
    @FXML private TextField textFieldMemberLastName;
    @FXML private TextField textFieldMemberStreet;
    @FXML private TextField textFieldMemberCity;
    @FXML private TextField textFieldMemberZipCode;
    @FXML private TextField textFieldMemberState;
    @FXML private ComboBox<String> comboBoxMemberStatus;


    public void setMain(ChocAnSysApp main, Stage dialog) {
        this.main = main;
        this.dialog = dialog;

    }

    public void confirmBtnHandler() {
        Member newMember = new Member(
                Integer.parseInt(textFieldMemberNumber.getText()),
                textFieldMemberFirstName.getText(),
                textFieldMemberLastName.getText(),
                textFieldMemberStreet.getText(),
                textFieldMemberCity.getText(),
                textFieldMemberState.getText(),
                textFieldMemberZipCode.getText(),
                comboBoxMemberStatus.getValue()


        );

    }

    public void cancelBtnHandler() {
        dialog.close();
    }
}


