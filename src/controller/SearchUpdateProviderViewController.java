/*******************************************************************************
 *******************************************************************************
 *******************************************************************************
 File: AddMemberViewController.java
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
import model.Provider;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class SearchUpdateProviderViewController {

    private ChocAnSysApp main;
    private Stage dialog;
    private Connection db;
    @FXML private TextField textFieldProviderNumber;
    private Statement stmt;
    private ResultSet rs2;



    public void setMain(ChocAnSysApp main, Stage dialog){
        this.main = main;
        this.dialog = dialog;
        db = DBConnection.connect();

    }

    public void lookupBtnHandler(){
        // QUERY THE DB AND STORE INFO TO POPULATE FIELDS
        try{
            Provider provider = new Provider();
            stmt = db.createStatement();
            rs2 = stmt.executeQuery("select * from providers where id = " + textFieldProviderNumber.getText() + " ;");
            provider.setNumber(rs2.getInt("id"));
            provider.setFirstName(rs2.getString("fname"));
            provider.setLastName(rs2.getString("lname"));
            provider.setStreet(rs2.getString("street"));
            provider.setCity(rs2.getString("city"));
            provider.setState(rs2.getString("state"));
            provider.setZipCode(rs2.getString("zip"));
            provider.setStatus(rs2.getString("status"));


            //PRINT RESULT SET TO VERIFY CORRECT QUERY
//            ResultSetMetaData rsmd = rs2.getMetaData();
//            System.out.println("querying SELECT * FROM XXX");
//            int columnsNumber = rsmd.getColumnCount();
//            while (rs2.next()) {
//                for (int i = 1; i <= columnsNumber; i++) {
//                    if (i > 1) System.out.print(",  ");
//                    String columnValue = rs2.getString(i);
//                    System.out.print(columnValue + " " + rsmd.getColumnName(i));
//                }
//                System.out.println("");
//            }
          //END PRINT RESULT SET

//            //PRINT MEMBER CONTENTS TO VERIFY
//            System.out.println("ID: " + provider.getNumber());
//            System.out.println("FirstName: " + provider.getFirstName());
//            System.out.println("LastName: " + provider.getLastName());
//            System.out.println("Street: " + provider.getStreet());
//            System.out.println("City: " + provider.getCity());
//            System.out.println("State: " + provider.getState());
//            System.out.println("Zip: " + provider.getZipCode());
//            System.out.println("Status: " + provider.getStatus());
//            //end print member contents

            main.updateProvidersWindow(provider);
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
}
