/*******************************************************************************
 *******************************************************************************
 *******************************************************************************
 File: ProcessVisitViewController.java
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.time.LocalDate;

public class ProcessVisitViewController {

    ChocAnSysApp main;
    Stage dialog;

    @FXML private DatePicker datePickerServiceDate;
    @FXML private Label lblServiceFee;
    @FXML private Label lblServiceName;
    @FXML private Label lblCurrentMemberStatus;
    public static LocalDate serviceDate;

    public void setMain(ChocAnSysApp main, Stage dialog){
        this.main = main;
        this.dialog = dialog;

        datePickerServiceDate.setValue(LocalDate.now());
        datePickerServiceDate.setOnAction(event -> {
            serviceDate = datePickerServiceDate.getValue();
            //System.out.println(serviceDate);
        });
    }

    @FXML
    public void validateMemberBtnHandler(){

    }

    @FXML
    public void submitClaimBtnHandler(){

    }

    @FXML
    public void cancelBtnHandler(){
        dialog.close();
    }
}
