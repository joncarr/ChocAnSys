/*******************************************************************************
 *******************************************************************************
 *******************************************************************************
 File: AddMemberViewController.java
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


