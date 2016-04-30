/*******************************************************************************
 * ******************************************************************************
 * ******************************************************************************
 * File: AddMemberViewController.java
 * Project: IntelliJ IDEA 15.0
 * Assignment: Chocoholics Anonymous System
 * University: McMurry University
 * Course: COSC–4360 Spring 2016
 * Instructor: Mr. Brozovic
 * Programmer: Jon Carr
 * Date: January 13, 2016
 * Update by: Additional coder’s name
 * Updated: Date code was updated
 * Compiler: NetBeans IDE Java SE
 * Description: Class Definitions for Provider class
 * *******************************************************************************
 * *******************************************************************************
 * <p>
 * ******************************************************************************
 * ******************************************************************************
 * SQLlite Database column names:
 * 1: id
 * 2: fname
 * 3: lname
 * 4: street
 * 5: city
 * 6: state
 * 7: zip
 * 8: status
 * 9: totalvisits
 * *******************************************************************************
 * *******************************************************************************
 *******************************************************************************/

/*******************************************************************************
 *******************************************************************************
 *******************************************************************************
 SQLlite Database column names:
 1: id
 2: fname
 3: lname
 4: street
 5: city
 6: state
 7: zip
 8: status
 9: totalvisits
 ********************************************************************************
 ********************************************************************************
 *******************************************************************************/


package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DBConnection;
import model.Member;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class AddMemberViewController {

    private ChocAnSysApp main;
    private Connection db;
    private PreparedStatement stmt;


    Stage dialog;
    Member member;
    @FXML
    private TextField textFieldMemberNumber;
    @FXML
    private TextField textFieldMemberFirstName;
    @FXML
    private TextField textFieldMemberLastName;
    @FXML
    private TextField textFieldMemberStreet;
    @FXML
    private TextField textFieldMemberCity;
    @FXML
    private TextField textFieldMemberZipCode;
    @FXML
    private ComboBox<String> comboBoxMemberState;
    @FXML
    private ComboBox<String> comboBoxMemberStatus;


    public void setMain(ChocAnSysApp main, Stage dialog) {
        this.main = main;
        this.dialog = dialog;
        db = DBConnection.connect();
        main.populateState(comboBoxMemberState);
        main.populateStatus(comboBoxMemberStatus);
    }

    public void confirmBtnHandler() {
        Member newMember = new Member(
                Integer.parseInt(textFieldMemberNumber.getText()),
                textFieldMemberFirstName.getText(),
                textFieldMemberLastName.getText(),
                textFieldMemberStreet.getText(),
                textFieldMemberCity.getText(),
                comboBoxMemberState.getValue(),
                textFieldMemberZipCode.getText(),
                comboBoxMemberStatus.getValue()
        );


        try {
            stmt = db.prepareStatement("insert into members VALUES (?,?,?,?,?,?,?,?,?);");
            stmt.setInt(1, newMember.getNumber());
            stmt.setString(2, newMember.getFirstName());
            stmt.setString(3, newMember.getLastName());
            stmt.setString(4, newMember.getStreet());
            stmt.setString(5, newMember.getCity());
            stmt.setString(6, newMember.getState());
            stmt.setString(7, newMember.getZipCode());
            stmt.setString(8, newMember.getStatus());
            stmt.setInt(9, 0);
            stmt.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Add New Member");
            alert.setContentText("Member successfully added.");
            alert.showAndWait();
            db.close();
            dialog.close();
        } catch (Exception e) {
            // print errors to error log

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();

            try (FileWriter fw = new FileWriter("ErrorLog.txt", true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw)) {
                out.println(exceptionAsString);
            } catch (IOException er) {
                er.printStackTrace();
            }

        }
    }

    public void cancelBtnHandler() {
        dialog.close();
    }


}


