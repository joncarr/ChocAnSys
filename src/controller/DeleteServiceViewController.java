/*******************************************************************************
 * ******************************************************************************
 * ******************************************************************************
 * File: DeleteServiceViewController.java
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
 * SQLlite Database services column names:
 * 1: svccode
 * 2: svcdescription
 * 3: fee
 * 4: status
 * *******************************************************************************
 * *******************************************************************************
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DBConnection;
import model.Member;
import model.Service;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;

public class DeleteServiceViewController {


    private ChocAnSysApp main;
    Stage dialog;
    Service service;
    @FXML
    private Label lblServiceCode;
    @FXML
    private Label lblServiceName;
    @FXML
    private Label lblServiceFee;
    @FXML
    private Label lblServiceStatus;
    private PreparedStatement stmt;
    private Connection db;


    public void setMain(ChocAnSysApp main, Stage dialog, Service service) {
        this.main = main;
        this.dialog = dialog;
        this.service = service;
        db = DBConnection.connect();
        fillServiceDetails(service);


    }

    public void confirmBtnHandler() {
        try {
            String sql = "delete from services where svccode = " + lblServiceCode.getText();
            stmt = db.prepareStatement(sql);
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            confirm.setHeaderText("Delete Service");
            confirm.setContentText("Are you sure you want to delete this service?");
            Optional<ButtonType> result = confirm.showAndWait();
            if (result.get() == ButtonType.OK) {
                stmt.executeUpdate();
            } else {
                dialog.close();
            }
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

    public void fillServiceDetails(Service service) {
        lblServiceCode.setText(String.valueOf(service.getCode()));
        lblServiceName.setText(service.getName());
        lblServiceFee.setText(Float.toString(service.getFee()));
        lblServiceStatus.setText(service.getStatus());

    }

}
