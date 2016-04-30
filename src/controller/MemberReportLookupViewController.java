package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.*;

import com.pdfjet.*;

import java.io.*;
import java.awt.Desktop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Luis on 4/27/2016.
 */
public class MemberReportLookupViewController {

    private ChocAnSysApp main;
    private Stage dialog;
    private Connection db;
    @FXML private TextField textFieldMemberID;
    @FXML private TextField errorlabel;

    private Statement stmt;
    private Statement stmtVisit;
    private Statement stmtProvider;
    private Statement stmtService;
    private ResultSet rs;
    private ResultSet rs2;
    private ResultSet ProviderRS;
    private ResultSet ServiceRS;

    public void setMain(ChocAnSysApp main, Stage dialog){
        this.main = main;
        this.dialog = dialog;
        db = DBConnection.connect();

    }

    public void btnLookupHandler(){



        try{
            Member member = new Member();
            stmt = db.createStatement();
            rs = stmt.executeQuery("select * from members where id = " + textFieldMemberID.getText() + " ;");

            if ( rs.next() ){
                member.setNumber(rs.getInt("id"));
                member.setFirstName(rs.getString("fname"));
                member.setLastName(rs.getString("lname"));
                member.setStreet(rs.getString("street"));
                member.setCity(rs.getString("city"));
                member.setState(rs.getString("state"));
                member.setZipCode(rs.getString("zip"));
                member.setStatus(rs.getString("status"));

                String PDFname = member.getNumber() + "-MemberReport.pdf";

                try {
                    FileOutputStream fos = new FileOutputStream(SystemSettingViewController.workingDirectory + "\\" + PDFname);
                    try {
                        PDF pdf = new PDF(fos);
                        Font f1 = new Font(pdf, CoreFont.COURIER);
                        f1.setSize(10);
                        Page page = new Page(pdf, A4.PORTRAIT);

                        TextLine text = new TextLine(f1, "");


                        text.setText("Chocoholics Anonymous");
                        text.setPosition(238, 114);
                        text.drawOn(page);

                        text.setText("Member Benefits Summary");
                        text.setPosition(232, 126);
                        text.drawOn(page);

                        text.setText( member.getFirstName() + " " + member.getLastName());
                        text.setPosition(70, 162);
                        text.drawOn(page);

                        text.setText("Member Number: " + member.getNumber());
                        text.setPosition(365, 162);
                        text.drawOn(page);

                        text.setText( member.getStreet());
                        text.setPosition(70,174);
                        text.drawOn(page);

                        text.setText(member.getCity() + ", " + member.getState() + ", " + member.getZipCode());
                        text.setPosition(70,186);
                        text.drawOn(page);


                        text.setText("Statement Date: " + SystemSettingViewController.currentDate);
                        text.setPosition(365,186);
                        text.drawOn(page);

                        text.setText("Page: 01");
                        text.setPosition(365,210);
                        text.drawOn(page);

                        text.setText("Date         Service                    Provider");
                        text.setPosition(70,234);
                        text.drawOn(page);

                        text.setText("------------------------------------------------------------------------------");
                        text.setPosition(70,250);
                        text.drawOn(page);


                        Visit visit = new Visit();
                        stmtVisit = db.createStatement();
                        rs2 = stmt.executeQuery("select * from visits where mbrnumber = " + textFieldMemberID.getText() + " ;");

                        int amount = 1;

                        int apptright = 70;
                        int apptdown = 275;
                        while(rs2.next()){

                            amount++;

                            visit.setServiceDate(rs2.getString("svcdate"));
                            text.setText("" + visit.getServiceDate());
                            text.setPosition(apptright, apptdown);
                            text.drawOn(page);

                            visit.setServiceCode(rs2.getInt("svccode"));
                            Service service = new Service();
                            stmtService = db.createStatement();
                            ServiceRS = stmtService.executeQuery("select * from services where svccode = " + visit.getServiceCode() + " ;");
                            service.setName(ServiceRS.getString("svcdescription"));

                            visit.setProviderNumber(rs2.getInt("provnumber"));
                            Provider provider = new Provider();
                            stmtProvider = db.createStatement();
                            ProviderRS = stmtProvider.executeQuery("select * from providers where id = " + visit.getProviderNumber() + " ;");

                            provider.setFirstName(ProviderRS.getString("fname"));
                            provider.setLastName(ProviderRS.getString("lname"));

                            text.setText(provider.getFirstName() + " " + provider.getLastName());
                            text.setPosition(apptright+80, apptdown);
                            text.drawOn(page);

                            text.setText(service.getName());
                            text.setPosition(apptright+245, apptdown);
                            text.drawOn(page);

                            apptdown+=20;



                        }



                        pdf.flush();
                        pdf.close();

                        try {
                            Desktop.getDesktop().open(new File(SystemSettingViewController.workingDirectory + "\\" + PDFname));
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }catch(Exception e) {
                        e.printStackTrace();
                    }

                }catch(IOException e) {
                    e.printStackTrace();
                }



            }


            dialog.close();


        }catch(Exception e){

            e.printStackTrace();
        }




    }

    public void btnCancelHandler(){ dialog.close(); }



}
