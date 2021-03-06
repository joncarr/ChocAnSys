/*******************************************************************************
 * ******************************************************************************
 * ******************************************************************************
 * File: SearchUpdateServicesViewController.java
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
 * Description: Controller class for searching for services to update
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DBConnection;
import model.Service;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class SearchUpdateServicesViewController {

    private ChocAnSysApp main;
    private Stage dialog;
    private Connection db;
    @FXML
    private TextField textFieldServiceCode;
    private Statement stmt;
    private ResultSet rs2;


    public void setMain(ChocAnSysApp main, Stage dialog) {
        this.main = main;
        this.dialog = dialog;
        db = DBConnection.connect();

    }

    public void lookupBtnHandler() {
        // QUERY THE DB AND STORE INFO TO POPULATE FIELDS
        try {
            Service service = new Service();
            stmt = db.createStatement();
            rs2 = stmt.executeQuery("select * from services where svccode = " + textFieldServiceCode.getText() + " ;");
            service.setCode(rs2.getInt("svccode"));
            service.setName(rs2.getString("svcdescription"));
            service.setFee(rs2.getFloat("fee"));
            service.setStatus(rs2.getString("status"));

            main.updateServicesWindow(service);
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
