/*******************************************************************************
 *******************************************************************************
 *******************************************************************************
 File: AddServiceViewController.java
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Member;

public class AddServiceViewController {

    //TODO: Rewrite this class to work with Database


    private ChocAnSysApp main;
    Stage dialog;



    public void setMain(ChocAnSysApp main, Stage dialog) {
        this.main = main;
        this.dialog = dialog;

    }

    public void confirmBtnHandler() {

    }

    public void cancelBtnHandler() {
        dialog.close();
    }
}


