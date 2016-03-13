/*******************************************************************************
 *******************************************************************************
 *******************************************************************************
 File: AddProviderViewController.java
 Project: IntelliJ IDEA 15.0
 Assignment: Chocoholics Anonymous System
 University: McMurry University
 Course: COSC–4360 Spring 2016
 Instructor: Mr. Brozovic
 Programmer: Jon Carr
 Date: January 13, 2016
 Update by: Additional coder’s name
 Updated: Date code was updated
 Compiler: NetBeans IDE Java SE
 Description: Class Definitions for Provider class
 ********************************************************************************
 ********************************************************************************
 *******************************************************************************/

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


