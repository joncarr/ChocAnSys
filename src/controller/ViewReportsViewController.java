
/*******************************************************************************
 *******************************************************************************
 *******************************************************************************
 File: ViewReportsViewController.java
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

import com.pdfjet.*;
import javafx.fxml.FXML;
import javafx.stage.Stage;


import java.io.*;



public class ViewReportsViewController {

    ChocAnSysApp main;
    Stage dialog;
    String eol = System.getProperty("line.separator");
    public void setMain(ChocAnSysApp main, Stage dialog){
        this.main = main;
        this.dialog = dialog;
    }

    @FXML
    public void membersReportBtnHandler(){
        // PDF writer in work
        try {
            FileOutputStream fos = new FileOutputStream("TestExample.pdf");
            try {
                PDF pdf = new PDF(fos);

            }catch(Exception e) {
            // error
            }

        }catch(IOException e) {
        // error
        }

        /*
        Writer memberReport = null;
        try{

            memberReport = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Member_Report.txt"), "utf-8"));
            memberReport.write("         1         2         3         4         5         6         7         8" + eol);

            memberReport.write("12345678901234567890123456789012345678901234567890123456789012345678901234567890" + eol);
            memberReport.write("Test\t\nTest\nTest" + eol);


        } catch(IOException e){
            e.printStackTrace();
        } finally{
            try{memberReport.close();}
            catch(Exception e){}
        }

    try {
        Runtime.getRuntime().exec("notepad Member_Report.txt");
    }
    catch(IOException e){
        e.printStackTrace();


    }*/



    }

    @FXML
    public void providerReportBtnHandler(){

    }

    @FXML
    public void managersReportBtnHandler(){

    }

    @FXML
    public void eftDataBtnHandler(){

    }

    @FXML
    public void acmeUpdateBtnHandler(){

    }

    @FXML
    public void errorLogBtnHandler(){

    }

    @FXML
    public void backToMainMenuBtnHandler(){
        dialog.close();
    }
}
