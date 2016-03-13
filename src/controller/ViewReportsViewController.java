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

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class ViewReportsViewController {

    ChocAnSysApp main;
    Stage dialog;

    public void setMain(ChocAnSysApp main, Stage dialog){
        this.main = main;
        this.dialog = dialog;
    }

    @FXML
    public void membersReportBtnHandler(){

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
