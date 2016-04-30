/*******************************************************************************
 * ******************************************************************************
 * ******************************************************************************
 * File: ManageServicesViewController.java
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

import javafx.stage.Stage;

public class ManageServicesViewController {

    private ChocAnSysApp main;
    private Stage dialog;

    public void setMain(ChocAnSysApp main, Stage dialog) {
        this.main = main;
        this.dialog = dialog;
    }

    public void updateServiceHandler() {
        main.searchUpdateServicesWindow();
    }

    public void addServiceHandler() {
        main.addServicesWindow();
    }

    public void deleteServiceHandler() {
        main.searchDeleteServicesWindow();
    }

    public void exitServicesHandler() {
        dialog.close();
    }
}
