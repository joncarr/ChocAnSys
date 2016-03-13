/*******************************************************************************
 *******************************************************************************
 *******************************************************************************
 File: UpdateServiceViewController.java
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Provider;
import model.Service;

public class UpdateServiceViewController {

    //TODO: Rewrite this class to work with Database
    //TODO: Change Status on form to be updateable

    private ChocAnSysApp main;
    Stage dialog;
    Service service;
    @FXML private TextField textFieldCode;
    @FXML private TextField textFieldServiceName;
    @FXML private TextField textFieldFee;
    @FXML private ComboBox<String> comboBoxStatus;

    public void setMain(ChocAnSysApp main, Stage dialog){
        this.main = main;
        this.dialog = dialog;
        this.service = service;

    }

    public void confirmBtnHandler(){
        Service newService = new Service(
                //TODO : Write Service Constructor
        );

    }

    public void cancelBtnHandler(){
        dialog.close();

    }

    /*
    Function is called when the user wishes to UPDATE a member, rather than just adding a member
    This function takes the member information that was passed to this controller and pre-populates the text fields
    */
    public void fillServiceDetails(){
        textFieldCode.setText(String.valueOf(service.getCode()));
        textFieldServiceName.setText(service.getName());
        textFieldFee.setText(Float.toString(service.getFee()));
        comboBoxStatus.setValue(service.getStatus());

    }


}
