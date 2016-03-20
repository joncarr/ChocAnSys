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

/*******************************************************************************
 *******************************************************************************
 *******************************************************************************
 SQLlite Database services column names:
 1: svccode
 2: svcdescription
 3: fee
 4: status
 ********************************************************************************
 ********************************************************************************
 *******************************************************************************/

package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DBConnection;
import model.Provider;
import model.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateServiceViewController {

    //TODO: Rewrite this class to work with Database
    //TODO: Change Status on form to be updatable

    private ChocAnSysApp main;
    Stage dialog;
    Service service;
    @FXML private TextField textFieldServiceCode;
    @FXML private TextField textFieldServiceName;
    @FXML private TextField textFieldServiceFee;
    @FXML private ComboBox<String> comboBoxServiceStatus;
    private PreparedStatement stmt;
    private Connection db;

    public void setMain(ChocAnSysApp main, Stage dialog, Service service){
        this.main = main;
        this.dialog = dialog;
        this.service = service;
        db = DBConnection.connect();
        main.populateStatus(comboBoxServiceStatus);
        fillServiceDetails(service);

    }

    public void confirmBtnHandler(){

        try {
            String sql =    "update services " +
                    "set svccode = ?," +
                    "svcdescription = ?," +
                    "fee = ?," +
                    "status = ? " +
                    "where svccode = " + textFieldServiceCode.getText();

            stmt = db.prepareStatement(sql);
            stmt.setString(1, textFieldServiceCode.getText());
            stmt.setString(2, textFieldServiceName.getText());
            stmt.setString(3, textFieldServiceFee.getText());
            stmt.setString(4, comboBoxServiceStatus.getValue());
            stmt.executeUpdate();
            db.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Update Service");
            alert.setContentText("Service successfully updated.");
            alert.showAndWait();
            dialog.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cancelBtnHandler(){
        dialog.close();

    }

    /*
    Function is called when the user wishes to UPDATE a member, rather than just adding a member
    This function takes the member information that was passed to this controller and pre-populates the text fields
    */
    public void fillServiceDetails(Service service){
        textFieldServiceCode.setText(String.valueOf(service.getCode()));
        textFieldServiceName.setText(service.getName());
        textFieldServiceFee.setText(Float.toString(service.getFee()));
        comboBoxServiceStatus.setValue(service.getStatus());

    }


}
