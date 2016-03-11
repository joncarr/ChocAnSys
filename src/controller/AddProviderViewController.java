package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Member;

public class AddProviderViewController {

    //TODO: Rewrite this class to work with Database


    private ChocAnSysApp main;
    Stage dialog;
    Member member;
    @FXML private TextField textFieldProviderNumber;
    @FXML private TextField textFieldProviderFirstName;
    @FXML private TextField textFieldProviderLastName;
    @FXML private TextField textFieldProviderStreet;
    @FXML private TextField textFieldProviderCity;
    @FXML private TextField textFieldProviderZipCode;
    @FXML private TextField textFieldProviderState;
    @FXML private ComboBox<String> comboBoxProviderStatus;


    public void setMain(ChocAnSysApp main, Stage dialog) {
        this.main = main;
        this.dialog = dialog;

    }

    public void confirmBtnHandler() {
        Member newMember = new Member(
                Integer.parseInt(textFieldProviderNumber.getText()),
                textFieldProviderFirstName.getText(),
                textFieldProviderLastName.getText(),
                textFieldProviderStreet.getText(),
                textFieldProviderCity.getText(),
                textFieldProviderState.getText(),
                textFieldProviderZipCode.getText(),
                comboBoxProviderStatus.getValue()


        );

    }

    public void cancelBtnHandler() {
        dialog.close();
    }
}


