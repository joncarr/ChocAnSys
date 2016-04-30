/*******************************************************************************
 * ******************************************************************************
 * ******************************************************************************
 * File: UpdateProviderViewController.java
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
import model.Provider;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateProviderViewController {

    //TODO: Rewrite this class to work with Database
    //TODO: Change Status on form to be updateable

    private ChocAnSysApp main;
    Stage dialog;
    Provider provider;
    @FXML
    private TextField textFieldProviderNumber;
    @FXML
    private TextField textFieldProviderFirstName;
    @FXML
    private TextField textFieldProviderLastName;
    @FXML
    private TextField textFieldProviderStreet;
    @FXML
    private TextField textFieldProviderCity;
    @FXML
    private TextField textFieldProviderZipCode;
    @FXML
    private ComboBox<String> comboBoxProviderState;
    @FXML
    private ComboBox<String> comboBoxProviderStatus;
    PreparedStatement stmt;
    Connection db;

    public void setMain(ChocAnSysApp main, Stage dialog, Provider provider) {
        this.main = main;
        this.dialog = dialog;
        this.provider = provider;
        db = DBConnection.connect();
        main.populateStatus(comboBoxProviderStatus);
        main.populateState(comboBoxProviderState);
        fillProviderDetails(provider);

    }

    public void confirmBtnHandler() {

        try {
            String sql = "update providers " +
                    "set fname = ?," +
                    "lname = ?," +
                    "street = ?," +
                    "city = ?," +
                    "state = ?," +
                    "zip = ?," +
                    "status = ?" +
                    "where id = " + textFieldProviderNumber.getText();

            stmt = db.prepareStatement(sql);
            stmt.setString(1, textFieldProviderFirstName.getText());
            stmt.setString(2, textFieldProviderLastName.getText());
            stmt.setString(3, textFieldProviderStreet.getText());
            stmt.setString(4, textFieldProviderCity.getText());
            stmt.setString(5, comboBoxProviderState.getValue());
            stmt.setString(6, textFieldProviderZipCode.getText());
            stmt.setString(7, comboBoxProviderStatus.getValue());
            stmt.executeUpdate();
            db.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Update Provider");
            alert.setContentText("Provider successfully updated.");
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
    public void fillProviderDetails(Provider provider) {
        textFieldProviderNumber.setText(String.valueOf(provider.getNumber()));
        textFieldProviderFirstName.setText(provider.getFirstName());
        textFieldProviderLastName.setText(provider.getLastName());
        textFieldProviderStreet.setText(provider.getStreet());
        textFieldProviderCity.setText(provider.getCity());
        comboBoxProviderState.setValue(provider.getState());
        textFieldProviderZipCode.setText(provider.getZipCode());
        comboBoxProviderStatus.setValue(provider.getStatus());
    }


}
