/*******************************************************************************
 *******************************************************************************
 *******************************************************************************
 File: ManageMembersViewController.java
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

import javafx.stage.Stage;

public class ManageMembersViewController {

    private ChocAnSysApp main;
    private Stage dialog;

    public void setMain(ChocAnSysApp main, Stage dialog){
        this.main = main;
        this.dialog = dialog;
    }

    public void updateMemberHandler(){
        main.updateMembersWindow();
    }

    public void addMemberHandler(){
        main.addMembersWindow();
    }

    public void deleteMemberHandler(){
        main.deleteMembersWindow();
    }

    public void exitMembersHandler(){
        dialog.close();
    }
}
