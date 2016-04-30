/*******************************************************************************
 * ******************************************************************************
 * ******************************************************************************
 * File: DeleteMemberViewController.java
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
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.DBConnection;
import model.Member;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;

public class DeleteMemberViewController {


    private ChocAnSysApp main;
    private Stage dialog;
    private Member member;
    private Connection db;
    private PreparedStatement stmt;
    @FXML
    private Label lblMemberNumber;
    @FXML
    private Label lblMemberFirstName;
    @FXML
    private Label lblMemberLastName;
    @FXML
    private Label lblMemberStreet;
    @FXML
    private Label lblMemberCity;
    @FXML
    private Label lblMemberState;
    @FXML
    private Label lblMemberZip;
    @FXML
    private Label lblMemberStatus;

    public void setMain(ChocAnSysApp main, Stage dialog, Member member) {
        this.main = main;
        this.dialog = dialog;
        this.member = member;
        db = DBConnection.connect();
        fillMemberDetails(member);

    }

    public void confirmBtnHandler() {
        try {
            String sql = "delete from members where id = " + lblMemberNumber.getText();
            stmt = db.prepareStatement(sql);
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            confirm.setHeaderText("Delete Member");
            confirm.setContentText("Are you sure you want to delete this member?");
            Optional<ButtonType> result = confirm.showAndWait();
            if (result.get() == ButtonType.OK) {
                stmt.execute();
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

    /*
    Function is called when the user wishes to UPDATE a member, rather than just adding a member
    This function takes the member information that was passed to this controller and pre-populates the text fields
    */
    public void fillMemberDetails(Member member) {
        lblMemberNumber.setText(String.valueOf(member.getNumber()));
        lblMemberFirstName.setText(member.getFirstName());
        lblMemberLastName.setText(member.getLastName());
        lblMemberStreet.setText(member.getStreet());
        lblMemberCity.setText(member.getCity());
        lblMemberState.setText(member.getState());
        lblMemberZip.setText(member.getZipCode());
        lblMemberStatus.setText(member.getStatus());
    }


}
