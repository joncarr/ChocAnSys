/*******************************************************************************
 *******************************************************************************
 *******************************************************************************
 File: AddServiceViewController.java
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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DBConnection;
import model.Member;
import model.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class AddServiceViewController {

    //TODO: Rewrite this class to work with Database


    private ChocAnSysApp main;
    Stage dialog;

    @FXML private TextField textFieldServiceCode;
    @FXML private TextField textFieldServiceName;
    @FXML private TextField textFieldServiceFee;
    @FXML private ComboBox<String> comboBoxServiceStatus;
    PreparedStatement stmt;
    Connection db;



    public void setMain(ChocAnSysApp main, Stage dialog) {
        this.main = main;
        this.dialog = dialog;
        db = DBConnection.connect();
        main.populateStatus(comboBoxServiceStatus);
    }

    public void confirmBtnHandler() {
        Service newService = new Service(
                Integer.parseInt(textFieldServiceCode.getText()),
                textFieldServiceName.getText(),
                Float.parseFloat(textFieldServiceFee.getText()),
                comboBoxServiceStatus.getValue()
        );
        try{
            stmt = db.prepareStatement("insert into services VALUES (?,?,?,?);");
            stmt.setInt(1, newService.getCode());
            stmt.setString(2, newService.getName());
            stmt.setFloat(3, newService.getFee());
            stmt.setString(4, newService.getStatus());

            stmt.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Add New Service");
            alert.setContentText("Service successfully added.");
            alert.showAndWait();
            db.close();
            dialog.close();
        }
        catch(Exception e){
            System.out.println(e);
        }


    }

    public void cancelBtnHandler() {
        dialog.close();
    }
}


