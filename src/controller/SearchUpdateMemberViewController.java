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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DBConnection;
import model.Member;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class SearchUpdateMemberViewController {

    private ChocAnSysApp main;
    private Stage dialog;
    private Connection db;
    @FXML
    private TextField textFieldMemberNumber;
    private Statement stmt;
    private ResultSet rs;


    public void setMain(ChocAnSysApp main, Stage dialog) {
        this.main = main;
        this.dialog = dialog;
        db = DBConnection.connect();

    }

    public void lookupBtnHandler() {
        // QUERY THE DB AND STORE INFO TO POPULATE FIELDS
        try {
            Member member = new Member();
            stmt = db.createStatement();

            rs = stmt.executeQuery("select * from members where id = " + textFieldMemberNumber.getText() + " ;");
            member.setNumber(rs.getInt("id"));
            member.setFirstName(rs.getString("fname"));
            member.setLastName(rs.getString("lname"));
            member.setStreet(rs.getString("street"));
            member.setCity(rs.getString("city"));
            member.setState(rs.getString("state"));
            member.setZipCode(rs.getString("zip"));
            member.setStatus(rs.getString("status"));

            main.updateMembersWindow(member);
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
