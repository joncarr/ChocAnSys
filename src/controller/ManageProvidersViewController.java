/*******************************************************************************
 * ******************************************************************************
 * ******************************************************************************
 * File: ManageProvidersViewController.java
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

public class ManageProvidersViewController {

    private ChocAnSysApp main;
    private Stage dialog;

    public void setMain(ChocAnSysApp main, Stage dialog) {
        this.main = main;
        this.dialog = dialog;
    }

    public void updateProviderHandler() {
        main.searchUpdateProviderWindow();
    }

    public void addProviderHandler() {
        main.addProvidersWindow();
    }

    public void deleteProviderHandler() {
        main.searchDeleteProviderWindow();
    }

    public void exitProvidersHandler() {
        dialog.close();
    }
}
