/*******************************************************************************
 *******************************************************************************
 *******************************************************************************
 File: MainMenuViewController.java
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


public class MainMenuViewController {

    private ChocAnSysApp main;


    public void setMain(ChocAnSysApp main){
        this.main = main;
    }

    public void manageMembersBtnHandler(){
        main.manageMembersWindow();
    }

    public void manageProvidersBtnHandler(){
        main.manageProvidersWindow();
    }

    public void manageServicesBtnHandler(){
        main.manageServicesWindow();
    }

    public void viewReportsBtnHandler(){
        main.viewReportsWindow();
    }

    public void processVisitBtnHandler(){
        main.processVisitWindow();
    }

    public void weeklyProcessBtnHandler(){

    }

    public void acmeUpdateBtnHandler(){

    }

    public void systemExitBtnHandler(){
        System.exit(0);
    }

}