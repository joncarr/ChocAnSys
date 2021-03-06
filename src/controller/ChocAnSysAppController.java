/*******************************************************************************
 * ******************************************************************************
 * ******************************************************************************
 * File: ChocAnSysAppController.java
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

import javafx.fxml.FXML;

public class ChocAnSysAppController {

    private ChocAnSysApp main;


    public void setMain(ChocAnSysApp main) {
        this.main = main;
    }


    @FXML
    public void exitButtonClicked() {
        System.exit(0);
    }

    @FXML
    public void processBtnHandler() {
        main.systemSettingWindow();
    }


}
