/*******************************************************************************
 *******************************************************************************
 *******************************************************************************
 File: DeleteProviderViewController.java
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DBConnection;
import model.Provider;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;

public class DeleteProviderViewController {


    private ChocAnSysApp main;
    Stage dialog;
    Provider provider;
    @FXML private Label lblProviderNumber;
    @FXML private Label lblProviderFirstName;
    @FXML private Label lblProviderLastName;
    @FXML private Label lblProviderStreet;
    @FXML private Label lblProviderCity;
    @FXML private Label lblProviderZipCode;
    @FXML private Label lblProviderState;
    @FXML private Label lblProviderStatus;
    Connection db;
    PreparedStatement stmt;

    public void setMain(ChocAnSysApp main, Stage dialog, Provider provider){
        this.main = main;
        this.dialog = dialog;
        this.provider = provider;
        fillProviderDetails(provider);
        db = DBConnection.connect();

    }

    public void confirmBtnHandler(){
        try{
            String sql = "delete from providers where id = " + lblProviderNumber.getText();
            stmt = db.prepareStatement(sql);
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            confirm.setHeaderText("Delete Provider");
            confirm.setContentText("Are you sure you want to delete this provider?");
            Optional<ButtonType> result = confirm.showAndWait();
            if(result.get() == ButtonType.OK){
                stmt.execute();
            } else {
                dialog.close();
            }
            db.close();
            dialog.close();

        } catch(Exception e){
            // print errors to error log

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();

            try(FileWriter fw = new FileWriter("ErrorLog.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(exceptionAsString);
            }catch(IOException er){
                er.printStackTrace();
            }
        }
    }

    public void cancelBtnHandler(){
        dialog.close();

    }

    public void fillProviderDetails(Provider provider){
        lblProviderNumber.setText(String.valueOf(provider.getNumber()));
        lblProviderFirstName.setText(provider.getFirstName());
        lblProviderLastName.setText(provider.getLastName());
        lblProviderStreet.setText(provider.getStreet());
        lblProviderCity.setText(provider.getCity());
        lblProviderState.setText(provider.getState());
        lblProviderZipCode.setText(provider.getZipCode());
        lblProviderStatus.setText(provider.getStatus());
    }

}
