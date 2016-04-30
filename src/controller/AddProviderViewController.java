/*******************************************************************************
 * ******************************************************************************
 * ******************************************************************************
 * File: AddProviderViewController.java
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
 * SQLlite Database providers column names:
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
 SQLlite Database providers column names:
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
import model.Provider;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class AddProviderViewController {


    private ChocAnSysApp main;
    Stage dialog;
    Provider provider;
    PreparedStatement stmt;
    Connection db;
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


    public void setMain(ChocAnSysApp main, Stage dialog) {
        this.main = main;
        this.dialog = dialog;
        db = DBConnection.connect();
        main.populateState(comboBoxProviderState);
        main.populateStatus(comboBoxProviderStatus);

    }

    @FXML
    public void confirmBtnHandler() {

        Provider newProvider = new Provider(
                Integer.parseInt(textFieldProviderNumber.getText()),
                textFieldProviderFirstName.getText(),
                textFieldProviderLastName.getText(),
                textFieldProviderStreet.getText(),
                textFieldProviderCity.getText(),
                comboBoxProviderState.getValue(),
                textFieldProviderZipCode.getText(),
                comboBoxProviderStatus.getValue()
        );
        try {
            stmt = db.prepareStatement("insert into providers VALUES (?,?,?,?,?,?,?,?,?);");
            stmt.setInt(1, newProvider.getNumber());
            stmt.setString(2, newProvider.getFirstName());
            stmt.setString(3, newProvider.getLastName());
            stmt.setString(4, newProvider.getStreet());
            stmt.setString(5, newProvider.getCity());
            stmt.setString(6, newProvider.getState());
            stmt.setString(7, newProvider.getZipCode());
            stmt.setString(8, newProvider.getStatus());
            stmt.setInt(9, 0);
            stmt.execute();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Add New Provider");
            alert.setContentText("Provider successfully added.");
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

    @FXML
    public void cancelBtnHandler() {
        dialog.close();
    }
}


