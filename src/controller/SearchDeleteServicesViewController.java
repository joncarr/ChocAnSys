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
import model.Service;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchDeleteServicesViewController {

    private ChocAnSysApp main;
    private Stage dialog;
    private Connection db;
    @FXML
    private TextField textFieldServiceCode;
    private Statement stmt;
    private ResultSet rs;


    public void setMain(ChocAnSysApp main, Stage dialog) {
        this.main = main;
        this.dialog = dialog;
        db = DBConnection.connect();

    }

    @FXML
    public void lookupBtnHandler() {
        // QUERY THE DB AND STORE INFO TO POPULATE FIELDS
        try {
            Service service = new Service();
            stmt = db.createStatement();
            rs = stmt.executeQuery("select * from services where svccode = " + textFieldServiceCode.getText() + " ;");
            service.setCode(rs.getInt("svccode"));
            service.setName(rs.getString("svcdescription"));
            service.setFee(rs.getFloat("fee"));
            service.setStatus(rs.getString("status"));

            main.deleteServicesWindow(service);
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
