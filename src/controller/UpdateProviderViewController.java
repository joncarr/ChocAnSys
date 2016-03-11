package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Provider;

public class UpdateProviderViewController {

    //TODO: Rewrite this class to work with Database
    //TODO: Change Status on form to be updateable

    private ChocAnSysApp main;
    Stage dialog;
    Provider provider;
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
        this.provider = provider;

    }

    public void confirmBtnHandler(){
        Provider newMember = new Provider(
                Integer.parseInt(textFieldProviderNumber.getText()),
                textFieldProviderFirstName.getText(),
                textFieldProviderLastName.getText(),
                textFieldProviderStreet.getText(),
                textFieldProviderCity.getText(),
                textFieldProviderState.getText(),
                textFieldProviderZipCode.getText(),
                lblProviderStatus.getText()


        );

    }

    public void cancelBtnHandler(){
        dialog.close();

    }

    /*
    Function is called when the user wishes to UPDATE a member, rather than just adding a member
    This function takes the member information that was passed to this controller and pre-populates the text fields
    */
    public void fillMemberDetails(){
        textFieldProviderNumber.setText(String.valueOf(provider.getNumber()));
        textFieldProviderFirstName.setText(provider.getFirstName());
        textFieldProviderLastName.setText(provider.getLastName());
        textFieldProviderStreet.setText(provider.getStreet());
        textFieldProviderCity.setText(provider.getCity());
        textFieldProviderState.setText(provider.getState());
        textFieldProviderZipCode.setText(provider.getZipCode());
        textFieldProviderState.setText(provider.getStatus());
    }


}
