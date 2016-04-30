/*******************************************************************************
 * ******************************************************************************
 * ******************************************************************************
 * File: UpdateMemberViewController.java
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
 *******************************************************************************/

package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DBConnection;
import model.Member;


import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateMemberViewController {


    private ChocAnSysApp main;
    Stage dialog;
    Member member;
    @FXML
    private TextField getTextFieldMemberNumber;
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
    @FXML
    private Label lblMemberStatus;
    private PreparedStatement stmt;
    private Connection db;


    public void setMain(ChocAnSysApp main, Stage dialog, Member member) {
        this.main = main;
        this.dialog = dialog;
        this.member = member;
        db = DBConnection.connect();
        main.populateStatus(comboBoxMemberStatus);
        main.populateState(comboBoxMemberState);
        fillMemberDetails(member);

    }


    public void confirmBtnHandler() {

        try {
            String sql = "update members " +
                    "set fname = ?," +
                    "lname = ?," +
                    "street = ?," +
                    "city = ?," +
                    "state = ?," +
                    "zip = ?," +
                    "status = ?" +
                    "where id = " + textFieldMemberNumber.getText();

            stmt = db.prepareStatement(sql);
            stmt.setString(1, textFieldMemberFirstName.getText());
            stmt.setString(2, textFieldMemberLastName.getText());
            stmt.setString(3, textFieldMemberStreet.getText());
            stmt.setString(4, textFieldMemberCity.getText());
            stmt.setString(5, comboBoxMemberState.getValue());
            stmt.setString(6, textFieldMemberZipCode.getText());
            stmt.setString(7, comboBoxMemberStatus.getValue());
            stmt.executeUpdate();

            // Added 20 APR by: Luis Lopez
            // write to pdf changes

            // write to acme update by Luis
            try (FileWriter fw = new FileWriter("AcmeUpdate.txt", true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw)) {
                out.println(member.getNumber() + ", " + member.getStatus() + ", "
                        + member.getFirstName() + ", " + member.getLastName());
            } catch (IOException e) {
                e.printStackTrace();
            }

            db.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Update Member");
            alert.setContentText("Member successfully updated.");
            alert.showAndWait();
            dialog.close();
        } catch (SQLException e) {

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

    /*
    Function is called when the user wishes to UPDATE a member, rather than just adding a member
    This function takes the member information that was passed to this controller and pre-populates the text fields
    */
    public void fillMemberDetails(Member member) {
        textFieldMemberNumber.setText(String.valueOf(member.getNumber()));
        textFieldMemberFirstName.setText(member.getFirstName());
        textFieldMemberLastName.setText(member.getLastName());
        textFieldMemberStreet.setText(member.getStreet());
        textFieldMemberCity.setText(member.getCity());
        comboBoxMemberState.setValue(member.getState());
        textFieldMemberZipCode.setText(member.getZipCode());
        comboBoxMemberStatus.setValue(member.getStatus());
    }


}
