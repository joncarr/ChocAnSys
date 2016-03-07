package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddUpdateMemberViewController {

    private ChocAnSysApp main;
    @FXML private TextField textFieldMemberNumber;
    @FXML private TextField textFieldMemberFirstName;
    @FXML private TextField textFieldMemberLastName;
    @FXML private TextField textFieldMemberStreet;
    @FXML private TextField textFieldMemberCity;
    @FXML private TextField textFieldMemberZipCode;
    @FXML private ChoiceBox<String> choiceBoxMemberState;
    @FXML private Label lblMemberStatus;
    @FXML private Label lblFormHeader;


    public void setMain(){
        this.main = main;
    }

    public void confirmBtnHandler(){

    }

    public void cancelBtnHandler(){

    }


}
