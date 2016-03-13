/*******************************************************************************
 *******************************************************************************
 *******************************************************************************
 File: UpdateMemberViewController.java
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Member;

public class UpdateMemberViewController {

    //TODO: Rewrite this class to work with Database
    //TODO: Change Status on form to be updateable

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
    @FXML private Label lblMemberStatus;

    public void setMain(ChocAnSysApp main, Stage dialog){
        this.main = main;
        this.dialog = dialog;
        this.member = member;

    }

    public void confirmBtnHandler(){
        Member newMember = new Member(
                Integer.parseInt(textFieldMemberNumber.getText()),
                textFieldMemberFirstName.getText(),
                textFieldMemberLastName.getText(),
                textFieldMemberStreet.getText(),
                textFieldMemberCity.getText(),
                textFieldMemberState.getText(),
                textFieldMemberZipCode.getText(),
                lblMemberStatus.getText()


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
        textFieldMemberNumber.setText(String.valueOf(member.getNumber()));
        textFieldMemberFirstName.setText(member.getFirstName());
        textFieldMemberLastName.setText(member.getLastName());
        textFieldMemberStreet.setText(member.getStreet());
        textFieldMemberCity.setText(member.getCity());
        textFieldMemberState.setText(member.getState());
        textFieldMemberZipCode.setText(member.getZipCode());
        lblMemberStatus.setText(member.getStatus());
    }


}
