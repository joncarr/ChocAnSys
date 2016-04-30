/*******************************************************************************
 * ******************************************************************************
 * ******************************************************************************
 * File: MainMenuViewController.java
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


import javafx.scene.control.Alert;

import java.awt.*;
import java.io.*;

public class MainMenuViewController {

    private ChocAnSysApp main;


    public void setMain(ChocAnSysApp main) {
        this.main = main;
    }

    public void manageMembersBtnHandler() {
        main.manageMembersWindow();
    }

    public void manageProvidersBtnHandler() {
        main.manageProvidersWindow();
    }

    public void manageServicesBtnHandler() {
        main.manageServicesWindow();
    }

    public void viewReportsBtnHandler() {
        main.viewReportsWindow();
    }

    public void processVisitBtnHandler() {
        main.processVisitWindow();
    }

    public void weeklyProcessBtnHandler() {

        try {
            Desktop.getDesktop().open(new File(SystemSettingViewController.workingDirectory + "\\" + "AcmeUpdate.txt"));
        } catch (IOException e) {
            // print errors to error log

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();

            try (FileWriter fw = new FileWriter("ErrorLog.txt", true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw)) {
                out.println(exceptionAsString);
            } catch (IOException er) {
                er.printStackTrace();
            }
        }

        try {
            Desktop.getDesktop().open(new File(SystemSettingViewController.workingDirectory + "\\" + "EFTDataReport.pdf"));
        } catch (IOException e) {
            // print errors to error log

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();

            try (FileWriter fw = new FileWriter("ErrorLog.txt", true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw)) {
                out.println(exceptionAsString);
            } catch (IOException er) {
                er.printStackTrace();
            }
        }

        try {
            Desktop.getDesktop().open(new File(SystemSettingViewController.workingDirectory + "\\" + "ManagerReport.pdf"));

        } catch (Exception e) {
            // print errors to error log

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();

            try (FileWriter fw = new FileWriter("ErrorLog.txt", true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw)) {
                out.println(exceptionAsString);
            } catch (IOException er) {
                er.printStackTrace();
            }
        }


    }

    public void acmeUpdateBtnHandler() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("ACME Update");
        alert.setContentText("ACME Updates pushed successfully");
        alert.showAndWait();
    }

    public void systemExitBtnHandler() {
        System.exit(0);
    }

}