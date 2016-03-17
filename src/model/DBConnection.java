/*******************************************************************************
 *******************************************************************************
 *******************************************************************************
 File: DBConnection.java
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
 Description: Class Definitions for Database connection
 ********************************************************************************
 ********************************************************************************
 *******************************************************************************/


package model;

import javafx.scene.control.Alert;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection connect(){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:ChocAnDb.sqlite");
            System.out.println("Connection to Database was successful.");
            return conn;
        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.toString());
            alert.showAndWait();
            System.exit(1);
            return null;

        }
    }
}
