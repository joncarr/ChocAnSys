/*******************************************************************************
 * ******************************************************************************
 * ******************************************************************************
 * File: ViewReportsViewController.java
 * Project: IntelliJ IDEA 15.0
 * Assignment: Chocoholics Anonymous System
 * University: McMurry University
 * Course: COSC–4360 Spring 2016
 * Instructor: Mr. Brozovic
 * Programmer: Jon Carr
 * Date: January 13, 2016
 * Update by: Luis Lopez
 * Updated: 15 March 2016
 * Compiler: NetBeans IDE Java SE
 * Description: Class Definitions for Provider class
 * *******************************************************************************
 * *******************************************************************************
 *******************************************************************************/


package controller;

import com.pdfjet.*;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.DBConnection;
import model.Provider;
import model.Service;
import model.Visit;

import java.awt.Desktop;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class ViewReportsViewController {

    ChocAnSysApp main;
    Stage dialog;
    String eol = System.getProperty("line.separator");
    private Connection db;

    public void setMain(ChocAnSysApp main, Stage dialog) {
        this.main = main;
        this.dialog = dialog;
        db = DBConnection.connect();

    }

    private Statement stmtVisit;
    private Statement stmtProvider;
    private Statement stmtService;
    private Statement Rowstmt;

    private ResultSet VisitRS;
    private ResultSet ProviderRS;
    private ResultSet ServiceRS;
    private ResultSet RowRS;

    public static int moveVar;


    @FXML
    public void membersReportBtnHandler() {
        main.MemberReportLookupWindow();
    }

    @FXML
    public void providerReportBtnHandler() {
        // Date updated: 14 March 2016
        // By: Luis Lopez

        main.ProviderReportLookupWindow();

    }

    @FXML
    public void managersReportBtnHandler() {
        // Date Updated 13 March 16
        // By: Luis Lopez

        moveVar = 10;


        try {
            FileOutputStream fos = new FileOutputStream(SystemSettingViewController.workingDirectory + "\\" + "ManagerReport.pdf");
            try {
                PDF pdf = new PDF(fos);
                Font f1 = new Font(pdf, CoreFont.COURIER);
                f1.setSize(10);
                Page page = new Page(pdf, A4.PORTRAIT);
                TextLine text = new TextLine(f1, "");


                text.setPosition(70, 84);
                text.drawOn(page);

                text.setText("Manager's Accounts Payable Summary Report");
                text.setPosition(125, 132);
                text.drawOn(page);

                text.setText("Date: " + SystemSettingViewController.currentDate);
                text.setPosition(365, 156);
                text.drawOn(page);

                text.setText("Page: 01");
                text.setPosition(365, 180);
                text.drawOn(page);

                text.setText("Provider Nbr   Name                          Claims  Total Fees ");
                text.setPosition(70, 204);
                text.drawOn(page);

                text.setText("------------------------------------------------------------------------------");
                text.setPosition(70, 219);
                text.drawOn(page);

                // start data output at 70, 246

                // Get size of table for providers
                Statement Rowstmt = db.createStatement();
                ResultSet RowRS = Rowstmt.executeQuery("SELECT COUNT(*) AS rowcount FROM providers");
                RowRS.next();
                int count = RowRS.getInt("rowcount");
                RowRS.close();


                Provider provider = new Provider();
                stmtProvider = db.createStatement();

                Visit visit = new Visit();
                stmtVisit = db.createStatement();


                Service service = new Service();
                stmtService = db.createStatement();
                int movedown = 215;
                int flag = 0;
                int hitCount = 0;
                int totalFees = 0;
                int fee = 0;
                int sumOfClaims = 0;
                int numberProviders = 0;
                int numberOfClaims = 0;
                ProviderRS = stmtProvider.executeQuery("SELECT * FROM PROVIDERS");
                while (ProviderRS.next()) {
                    //stmtProvider = db.createStatement();
                    provider.setNumber(ProviderRS.getInt("id"));

                    VisitRS = stmtVisit.executeQuery("select * from visits where provnumber = "
                            + provider.getNumber() + " ;");
                    while (VisitRS.next()) {

                        System.out.println(provider.getNumber());
                        visit.setServiceCode(VisitRS.getInt("svccode"));
                        provider.setNumber(ProviderRS.getInt("id"));
                        provider.setFirstName(ProviderRS.getString("fname"));
                        provider.setLastName(ProviderRS.getString("lname"));
                        ServiceRS = stmtService.executeQuery("select * from services where svccode ="
                                + visit.getServiceCode() + " ;");
                        service.setFee(ServiceRS.getInt("fee"));
                        totalFees += service.getFee();


                        flag = 1;
                        hitCount++;

                    }
                    if (flag == 1) {
                        numberOfClaims += hitCount;
                        sumOfClaims += totalFees;
                        text.setText("" + provider.getNumber());
                        text.setPosition(70, movedown += 20);
                        text.drawOn(page);


                        text.setText(provider.getFirstName() + " " + provider.getLastName());
                        text.setPosition(160, movedown);
                        text.drawOn(page);

                        text.setText("" + hitCount);
                        text.setPosition(360, movedown);
                        text.drawOn(page);

                        text.setText("$" + totalFees);
                        text.setPosition(400, movedown);
                        text.drawOn(page);
                        numberProviders++;
                        sumOfClaims += sumOfClaims;
                        flag = 0;
                        hitCount = 0;
                        totalFees = 0;
                    }


                }


                text.setText("" + numberProviders);
                text.setPosition(70, 430);
                text.drawOn(page);


                text.setText("Providers Paid");
                text.setPosition(130, 430);
                text.drawOn(page);

                text.setText("" + numberOfClaims);
                text.setPosition(70, 445);
                text.drawOn(page);

                text.setText("Claims Submitted");
                text.setPosition(130, 445);
                text.drawOn(page);

                text.setText("$" + sumOfClaims);
                text.setPosition(70, 460);
                text.drawOn(page);

                text.setText("Total Payment Paid");
                text.setPosition(130, 460);
                text.drawOn(page);


                // open pdf
                try {
                    Desktop.getDesktop().open(new File(SystemSettingViewController.workingDirectory + "\\" + "ManagerReport.pdf"));

                } catch (Exception e) {
                    e.printStackTrace();
                }
                pdf.flush();
                pdf.close();
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
        //end of new insert of validation window


    }

    @FXML
    public void eftDataBtnHandler() {


        try {
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

            //start data input from db
            Statement Rowstmt = db.createStatement();
            RowRS = Rowstmt.executeQuery("SELECT COUNT(*) AS rowcount FROM visits");
            RowRS.next();
            int count = RowRS.getInt("rowcount");
            int holder = 0;
            int j;


            Provider provider = new Provider();
            stmtProvider = db.createStatement();

            Visit visit = new Visit();
            stmtVisit = db.createStatement();


            Service service = new Service();
            stmtService = db.createStatement();
            int movedown = 125;
            int flag = 0;

            ProviderRS = stmtProvider.executeQuery("SELECT * FROM PROVIDERS");
            while (ProviderRS.next()) {
                //stmtProvider = db.createStatement();
                provider.setNumber(ProviderRS.getInt("id"));

                VisitRS = stmtVisit.executeQuery("select * from visits where provnumber = "
                        + provider.getNumber() + " ;");
                while (VisitRS.next()) {

                    System.out.println(provider.getNumber());
                    visit.setServiceCode(VisitRS.getInt("svccode"));
                    provider.setNumber(ProviderRS.getInt("id"));
                    provider.setFirstName(ProviderRS.getString("fname"));
                    provider.setLastName(ProviderRS.getString("lname"));
                    ServiceRS = stmtService.executeQuery("select * from services where svccode ="
                            + visit.getServiceCode() + " ;");
                    service.setFee(ServiceRS.getInt("fee"));


                    flag = 1;
                }
                if (flag == 1) {

                    text.setText("" + provider.getNumber());
                    text.setPosition(70, movedown += 20);
                    text.drawOn(page);

                    text.setText("$" + service.getFee());
                    text.setPosition(230, movedown);
                    text.drawOn(page);

                    text.setText(provider.getFirstName() + " " + provider.getLastName());
                    text.setPosition(324, movedown);
                    text.drawOn(page);


                    flag = 0;

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
            pdf.flush();
            pdf.close();

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

    @FXML
    public void acmeUpdateBtnHandler() {
        // Date updated 13 March 16
        // by: Luis Lopez


        try (FileWriter fw = new FileWriter("AcmeUpdate.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {


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


    }

    @FXML
    public void errorLogBtnHandler() {
        // Date updated 13 March 16
        // By: Luis Lopez

        try {
            Desktop.getDesktop().open(new File("ErrorLog.txt"));

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

    @FXML
    public void backToMainMenuBtnHandler() {
        dialog.close();
    }
}
