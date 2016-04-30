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

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class SearchUpdateMemberViewController {

    private ChocAnSysApp main;
    private Stage dialog;
    private Connection db;
    @FXML private TextField textFieldMemberNumber;
    private Statement stmt;
    private ResultSet rs;



    public void setMain(ChocAnSysApp main, Stage dialog){
        this.main = main;
        this.dialog = dialog;
        db = DBConnection.connect();

    }

    public void lookupBtnHandler(){
        // QUERY THE DB AND STORE INFO TO POPULATE FIELDS
        try{
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


            //PRINT RESULT SET TO VERIFY CORRECT QUERY
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("querying SELECT * FROM XXX");
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue + " " + rsmd.getColumnName(i));
                }
                System.out.println("");
            }
          //END PRINT RESULT SET

            //PRINT MEMBER CONTENTS TO VERIFY
            System.out.println("ID: " + member.getNumber());
            System.out.println("FirstName: " + member.getFirstName());
            System.out.println("LastName: " + member.getLastName());
            System.out.println("Street: " + member.getStreet());
            System.out.println("City: " + member.getCity());
            System.out.println("State: " + member.getState());
            System.out.println("Zip: " + member.getZipCode());
            System.out.println("Status: " + member.getStatus());
            //end print member contents


            main.updateMembersWindow(member);
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
}
