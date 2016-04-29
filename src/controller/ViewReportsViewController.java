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
 Update by: Luis Lopez
 Updated: 15 March 2016
 Compiler: NetBeans IDE Java SE
 Description: Class Definitions for Provider class
 ********************************************************************************
 ********************************************************************************
 *******************************************************************************/


package controller;

import com.pdfjet.*;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import java.awt.Desktop;

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
        // Date updated: 15 March 16
        // By: Luis Lopez

        main.MemberReportLookupWindow();

        /*
        try {
            FileOutputStream fos = new FileOutputStream(SystemSettingViewController.workingDirectory + "\\" + "MemberReport.pdf");
            try {
                PDF pdf = new PDF(fos);
                Font f1 = new Font(pdf, CoreFont.COURIER);
                f1.setSize(10);
                Page page = new Page(pdf, A4.PORTRAIT);

                TextLine text = new TextLine(f1, "         1         2         3         4         5         6         7         8");
                text.setPosition(70,72);
                text.drawOn(page);

                text.setText("12345678901234567890123456789012345678901234567890123456789012345678901234567890");
                text.setPosition(70, 82);
                text.drawOn(page);

                text.setText("Chocoholics Anonymous");
                text.setPosition(238, 114);
                text.drawOn(page);

                text.setText("Member Benefits Summary");
                text.setPosition(232, 126);
                text.drawOn(page);

                text.setText("(Member Name)");
                text.setPosition(70, 162);
                text.drawOn(page);

                text.setText("Member Number: ");
                text.setPosition(365, 162);
                text.drawOn(page);

                text.setText("(Street Address)");
                text.setPosition(70,174);
                text.drawOn(page);

                text.setText("(City, State, ZIP code)");
                text.setPosition(70,186);
                text.drawOn(page);


                text.setText("Statement Date: " + SystemSettingViewController.currentDate);
                text.setPosition(365,186);
                text.drawOn(page);

                text.setText("Page: ##");
                text.setPosition(365,210);
                text.drawOn(page);

                text.setText("Date         Service                    Provider");
                text.setPosition(70,234);
                text.drawOn(page);

                text.setText("------------------------------------------------------------------------------");
                text.setPosition(70,250);
                text.drawOn(page);

                // dates needed from Database
                text.setText("mm/dd/yyyy   XXXXXXXXXXXXXXXXXX         XXXXXXXXXXXXXXXXX");
                text.setPosition(70,265);
                text.drawOn(page);
                text.setPosition(70,289);
                text.drawOn(page);
                text.setPosition(70,313);
                text.drawOn(page);

                pdf.flush();
                pdf.close();

                try {
                    Desktop.getDesktop().open(new File(SystemSettingViewController.workingDirectory + "\\" + "MemberReport.pdf"));
                }catch(Exception e){
                    e.printStackTrace();
                }
            }catch(Exception e) {
                e.printStackTrace();
            }

        }catch(IOException e) {
            e.printStackTrace();
        }
        */


    }

    @FXML
    public void providerReportBtnHandler(){
        // Date updated: 14 March 2016
        // By: Luis Lopez

        main.ProviderReportLookupWindow();

        /*
        try{
            FileOutputStream fos = new FileOutputStream(SystemSettingViewController.workingDirectory + "\\" + "ProviderReport.pdf");
            try {
                PDF pdf = new PDF(fos);
                Font f1 = new Font(pdf, CoreFont.COURIER);
                f1.setSize(10);
                Page page = new Page(pdf, A4.LANDSCAPE);

                TextLine text = new TextLine(f1, "         1         2         3         4         5         6         7         8         9    ");
                text.setPosition(70,72);
                text.drawOn(page);

                text.setText("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
                text.setPosition(70, 82);
                text.drawOn(page);

                text.setText("Chocoholics Anonymous");
                text.setPosition(276, 130);
                text.drawOn(page);

                text.setText("Provider Claims Summary");
                text.setPosition(270, 142);
                text.drawOn(page);

                text.setText("(Provider Name)");
                text.setPosition(70,178);
                text.drawOn(page);

                text.setText("Provider Number: ");
                text.setPosition(450,178);
                text.drawOn(page);

                text.setText("(Street Address)");
                text.setPosition(70,190);
                text.drawOn(page);

                text.setText("(City, State, ZIP Code)");
                text.setPosition(70,202);
                text.drawOn(page);

                text.setText("Statement Date: " + SystemSettingViewController.currentDate);
                text.setPosition(450,202);
                text.drawOn(page);

                text.setText("Page: ##");
                text.setPosition(500,262);
                text.drawOn(page);

                text.setText("Service      Service                                           Claim Submitted");
                text.setPosition(70, 295);
                text.drawOn(page);

                text.setText("Date         Code     Member Nbr & Name                       Date       Time      Fee Paid");
                text.setPosition(70, 307);
                text.drawOn(page);

                text.setText("----------------------------------------------------------------------------------------------");
                text.setPosition(70,320);
                text.drawOn(page);

                // dates needed from Database
                text.setText("mm/dd/yyyy   XXXXXX   XXXXXXXXX   XXXXXXXXXXXXXXXXXXXXXXXXX   mm/dd/yyyy hh:mm:ss  $XXX.XX");
                text.setPosition(70,334);
                text.drawOn(page);
                text.setPosition(70,358);
                text.drawOn(page);
                text.setPosition(70,382);
                text.drawOn(page);

                text.setText("XXX");
                text.setPosition(70, 440);
                text.drawOn(page);

                text.setText("Total consultation claims submitted");
                text.setPosition(150, 440);
                text.drawOn(page);

                text.setText("$XX,XXX.XX");
                text.setPosition(70,455);
                text.drawOn(page);

                text.setText("Total Fees Paid");
                text.setPosition(150, 455);
                text.drawOn(page);

                try {
                    Desktop.getDesktop().open(new File(SystemSettingViewController.workingDirectory + "\\" + "ProviderReport.pdf"));

                }catch(Exception e){
                    e.printStackTrace();
                }
                pdf.flush();
                pdf.close();
            }catch(Exception e) {
                e.printStackTrace();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        */

    }

    @FXML
    public void managersReportBtnHandler(){
        // Date Updated 13 March 16
        // By: Luis Lopez




        try{
            FileOutputStream fos = new FileOutputStream(SystemSettingViewController.workingDirectory + "\\" + "ManagerReport.pdf");
            try {
                PDF pdf = new PDF(fos);
                Font f1 = new Font(pdf, CoreFont.COURIER);
                f1.setSize(10);
                Page page = new Page(pdf, A4.PORTRAIT);
                TextLine text = new TextLine(f1, "         1         2         3         4         5         6         7         8");
                text.setPosition(70,72);
                text.drawOn(page);
                //                     1         2         3         4         5         6         7         8
                text.setText("12345678901234567890123456789012345678901234567890123456789012345678901234567890");


                text.setPosition(70, 84);
                text.drawOn(page);

                text.setText("Manager's Accounts Payable Summary Report");
                text.setPosition(125, 132);
                text.drawOn(page);

                text.setText("Date: " + SystemSettingViewController.currentDate);
                text.setPosition(365,156);
                text.drawOn(page);

                text.setText("Page: ##");
                text.setPosition(365, 180);
                text.drawOn(page);

                text.setText("Provider Nbr   Name                          Claims  Total Fees ");
                text.setPosition(70, 204);
                text.drawOn(page);

                text.setText("------------------------------------------------------------------------------");
                text.setPosition(70, 219);
                text.drawOn(page);

                text.setText("XXXXXXXXX      XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX  XXX  $XX,XXX.XX");
                text.setPosition(70, 246);
                text.drawOn(page);

                text.setPosition(70, 258);
                text.drawOn(page);
                text.setPosition(70, 270);
                text.drawOn(page);
                text.setPosition(70, 282);
                text.drawOn(page);

                text.setText("XXXX   Providers Paid");
                text.setPosition(70, 382);
                text.drawOn(page);

                String test;
                test = "XXXX   Claims Submitted";
                text.setText( test );
                text.setPosition(70, 394);
                text.drawOn(page);

                test = "$###,###.##  Total Payments Paid";
                text.setText(test);
                text.setPosition(70, 406);
                text.drawOn(page);

                // open pdf
                try {
                    Desktop.getDesktop().open(new File(SystemSettingViewController.workingDirectory + "\\" + "ManagerReport.pdf"));

                }catch(Exception e){
                    e.printStackTrace();
                }
                pdf.flush();
                pdf.close();
            }catch(Exception e) {
                e.printStackTrace();
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        //end of new insert of validation window


    }

    @FXML
    public void eftDataBtnHandler(){


        try{
            FileOutputStream fos = new FileOutputStream(SystemSettingViewController.workingDirectory + "\\" + "EFTDataReport.pdf");
            PDF pdf = new PDF(fos);
            Font f1 = new Font(pdf, CoreFont.COURIER);
            f1.setSize(10);
            Page page = new Page(pdf, A4.PORTRAIT);

            TextLine text = new TextLine(f1, "EFT Data Report");
            text.setPosition(70, 82);
            text.drawOn(page);

            text.setText("Provider Number      Amount to be Paid    Provider Name");
            text.setPosition(70, 106);
            text.drawOn(page);

            text.setText("------------------------------------------------------------------------------");
            text.setPosition(70, 121);
            text.drawOn(page);

            text.setText("XXXXXXXXX              XXXXXX.XX          XXXXXXXXXXXXXXXXXXXXXXXX");
            text.setPosition(70, 148);
            text.drawOn(page);
            text.setPosition(70, 160);
            text.drawOn(page);
            text.setPosition(70, 172);
            text.drawOn(page);

            try{
                Desktop.getDesktop().open( new File(SystemSettingViewController.workingDirectory + "\\" + "EFTDataReport.pdf"));
            }catch(IOException e){
                e.printStackTrace();
            }
            pdf.flush();
            pdf.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    public void acmeUpdateBtnHandler(){
        // Date updated 13 March 16
        // by: Luis Lopez
        try {
            FileOutputStream fos = new FileOutputStream(SystemSettingViewController.workingDirectory + "\\" + "AcmeReport.pdf");

            PDF pdf = new PDF(fos);
            Font f1 = new Font(pdf, CoreFont.COURIER);
            f1.setSize(10);
            Page page = new Page(pdf, A4.PORTRAIT);

            TextLine text = new TextLine(f1, "Acme Update Report:");
            text.setPosition(70, 82);
            text.drawOn(page);

            text.setText("Member Number        Member Status        Member Name");
            text.setPosition(70, 106);
            text.drawOn(page);

            text.setText("------------------------------------------------------------------------------");
            text.setPosition(70,121);
            text.drawOn(page);

            text.setText("XXXXXXXXX            XXXXXXXXXX          XXXXXXXXXXXXXXXXXXXXXXXXX");
            text.setPosition(70,148);
            text.drawOn(page);
            text.setPosition(70, 160);
            text.drawOn(page);
            text.setPosition(70, 172);
            text.drawOn(page);

            try{
                Desktop.getDesktop().open( new File(SystemSettingViewController.workingDirectory + "\\" + "AcmeReport.pdf"));
            }catch(IOException e){
                e.printStackTrace();
            }
            pdf.flush();
            pdf.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void errorLogBtnHandler() {
        // Date updated 13 March 16
        // By: Luis Lopez

        try {
            FileOutputStream fos = new FileOutputStream(SystemSettingViewController.workingDirectory + "\\" + "ErrorReport.pdf");
            try {


                PDF pdf = new PDF(fos);
                Font f1 = new Font(pdf, CoreFont.COURIER);
                f1.setSize(10);
                Page page = new Page(pdf, A4.PORTRAIT);

                TextLine text = new TextLine(f1, "Chocoholics Anonymous System Error Report");
                text.setPosition(70,82);
                text.drawOn(page);

                text.setText("Errors:");
                text.setPosition(70,106);
                text.drawOn(page);

                try {
                    Desktop.getDesktop().open(new File("ErrorReport.pdf"));

                }catch(Exception e){
                    e.printStackTrace();
                }
                pdf.flush();
                pdf.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void backToMainMenuBtnHandler(){
        dialog.close();
    }
}
