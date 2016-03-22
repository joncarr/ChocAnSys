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
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.util.Date;
import javafx.scene.paint.Color;
import javafx.scene.control.Alert;

import model.DBConnection;
import model.Member;
import model.ProcessVisitTrans;
import model.Visit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import java.time.LocalDate;

public class ProcessVisitViewController {

    ChocAnSysApp main;
    Stage dialog;
    private Connection db;
    @FXML private TextField textFieldMemberNumber;
    private Statement stmt;
    private ResultSet rs;




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


    public void validateMemberBtnHandler(){
        db = DBConnection.connect();
        Member member = new Member();

        try{

            stmt = db.createStatement();
            rs = stmt.executeQuery("select * from members where id = " + textFieldMemberNumber.getText() + " ;");
            member.setStatus(rs.getString("status"));
            lblCurrentMemberStatus.setTextFill(Color.web("#000000"));
            lblCurrentMemberStatus.setText(member.getStatus());

        }catch( Exception e){
            lblCurrentMemberStatus.setTextFill(Color.web("#FF0000"));

            lblCurrentMemberStatus.setText("Number Not Found");
            e.printStackTrace();
        }



    }

    @FXML
    public void submitClaimBtnHandler(){

            if ( lblCurrentMemberStatus.getText().equals("Number Not Found") ) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Process Visit");
                alert.setContentText("Enter in valid, active member!");
                alert.showAndWait();
            }
    }

    @FXML
    public void cancelBtnHandler(){
        dialog.close();
    }
}
