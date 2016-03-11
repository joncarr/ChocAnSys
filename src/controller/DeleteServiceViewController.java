package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Member;
import model.Service;

public class DeleteServiceViewController {

    //TODO: Rewrite this class to work with Database
    //TODO: Change Status on form to be updateable
    //TODO: Add a button to look up the provider you want to delete and prepopulate the fields with query result

    private ChocAnSysApp main;
    Stage dialog;
    //Member member;
    Service service;
    @FXML private TextField textFieldProviderNumber;
    @FXML private TextField textFieldProviderFirstName;
    @FXML private TextField textFieldProviderLastName;
    @FXML private TextField textFieldProviderStreet;
    @FXML private TextField textFieldProviderCity;
    @FXML private TextField textFieldProviderZipCode;
    @FXML private TextField textFieldProviderState;
    @FXML private Label lblProviderStatus;

    public void setMain(ChocAnSysApp main, Stage dialog){
        this.main = main;
        this.dialog = dialog;
        this.service = service;
        //this.member = member;

    }

    public void confirmBtnHandler(){

    }

    public void cancelBtnHandler(){
        dialog.close();

    }

}
