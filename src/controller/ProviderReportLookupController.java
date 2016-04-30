package controller;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.*;
import com.pdfjet.*;

import java.io.*;
import java.awt.Desktop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * Created by Luis on 4/27/2016.
 */
public class ProviderReportLookupController {

    private ChocAnSysApp main;
    private Stage dialog;
    private Connection db;
    @FXML private TextField TextFieldProviderNumber;
    private Statement stmt;
    private Statement Visitstmt;
    private Statement Servicestmt;
    private Statement Memberstmt;

    private ResultSet rs2;
    private ResultSet VisitRS;
    private ResultSet ServiceRS;
    private ResultSet MemberRS;

    public void setMain(ChocAnSysApp main, Stage dialog) {
        this.main = main;
        this.dialog = dialog;
        db = DBConnection.connect();

    }

    public void btnCancelHandler(){
        dialog.close();
    }

    public void btnProviderNumberHandler(){
        try{
            Provider provider = new Provider();
            stmt = db.createStatement();
            rs2 = stmt.executeQuery("select * from providers where id = " + TextFieldProviderNumber.getText() + " ;");

            if (rs2.next()){
                provider.setNumber(rs2.getInt("id"));
                provider.setFirstName(rs2.getString("fname"));
                provider.setLastName(rs2.getString("lname"));
                provider.setStreet(rs2.getString("street"));
                provider.setCity(rs2.getString("city"));
                provider.setState(rs2.getString("state"));
                provider.setZipCode(rs2.getString("zip"));
                provider.setStatus(rs2.getString("status"));

                String filename = provider.getNumber() + "-" + "ProviderReport.pdf";

                try{
                    FileOutputStream fos = new FileOutputStream(SystemSettingViewController.workingDirectory + "\\" + filename);
                    try {
                        PDF pdf = new PDF(fos);
                        Font f1 = new Font(pdf, CoreFont.COURIER);
                        f1.setSize(10);
                        Page page = new Page(pdf, A4.LANDSCAPE);

                        TextLine text = new TextLine(f1, "");


                        text.setText("Chocoholics Anonymous");
                        text.setPosition(276, 130);
                        text.drawOn(page);

                        text.setText("Provider Claims Summary");
                        text.setPosition(270, 142);
                        text.drawOn(page);

                        text.setText(provider.getFirstName() + " " + provider.getLastName());
                        text.setPosition(70,178);
                        text.drawOn(page);

                        text.setText("Provider Number: " + provider.getNumber());
                        text.setPosition(450,178);
                        text.drawOn(page);

                        text.setText(provider.getStreet());
                        text.setPosition(70,190);
                        text.drawOn(page);

                        text.setText(provider.getCity() + " " + provider.getState() + " " + provider.getZipCode());
                        text.setPosition(70,202);
                        text.drawOn(page);

                        text.setText("Statement Date: " + SystemSettingViewController.currentDate);
                        text.setPosition(450,202);
                        text.drawOn(page);

                        text.setText("Page: 01");
                        text.setPosition(500,262);
                        text.drawOn(page);

                        text.setText("Service      Service                                           Claim Submitted");
                        text.setPosition(70, 295);
                        text.drawOn(page);

                        text.setText("Date         Code     Member Nbr & Name                           Date            Fee Paid");
                        text.setPosition(70, 307);
                        text.drawOn(page);

                        text.setText("----------------------------------------------------------------------------------------------");
                        text.setPosition(70,320);
                        text.drawOn(page);


                        Visit visit = new Visit();
                        Visitstmt = db.createStatement();
                        VisitRS = Visitstmt.executeQuery("select * from visits where provnumber = "
                                + TextFieldProviderNumber.getText() + " ;");

                        int moveright = 70;
                        int movedown = 340;
                        int claimscount = 0;
                        int totaldollaramount = 0;
                        while( VisitRS.next()){


                            visit.setServiceDate(VisitRS.getString("svcdate"));
                            visit.setMemberNumber(VisitRS.getInt("mbrnumber"));
                            visit.setServiceCode(VisitRS.getInt("svccode"));
                            visit.setTransactionDate(VisitRS.getString("svcentered"));
                            claimscount++;


                            Service service = new Service();
                            Servicestmt = db.createStatement();
                            ServiceRS = Servicestmt.executeQuery("select * from services where svccode = "
                                    + visit.getServiceCode() + " ;");
                            service.setFee(ServiceRS.getInt("fee"));
                            totaldollaramount+=service.getFee();


                            Member member = new Member();
                            Memberstmt = db.createStatement();
                            MemberRS = Memberstmt.executeQuery("select * from members where id = "
                                    + visit.getMemberNumber() + " ;");
                            member.setLastName(MemberRS.getString("lname"));
                            member.setFirstName(MemberRS.getString("fname"));

                            text.setText(visit.getServiceDate());
                            text.setPosition(moveright, movedown);
                            text.drawOn(page);

                            text.setText("" + visit.getServiceCode());
                            text.setPosition(moveright+78, movedown);
                            text.drawOn(page);

                            text.setText("" + visit.getMemberNumber());
                            text.setPosition(moveright+131, movedown);
                            text.drawOn(page);

                            text.setText("" + member.getFirstName() + " " + member.getLastName() + ".");
                            text.setPosition(moveright+200, movedown);
                            text.drawOn(page);

                            text.setText("" + visit.getTransactionDate());
                            text.setPosition(moveright+380, movedown);
                            text.drawOn(page);

                            text.setText("" + service.getFee());
                            text.setPosition(moveright+500, movedown);
                            text.drawOn(page);





                            movedown += 20;


                        }




                        text.setText("" + claimscount);
                        text.setPosition(70, 520);
                        text.drawOn(page);

                        text.setText("Total consultation claims submitted");
                        text.setPosition(150, 520);
                        text.drawOn(page);

                        text.setText("" + totaldollaramount);
                        text.setPosition(70,535);
                        text.drawOn(page);

                        text.setText("Total Fees Paid");
                        text.setPosition(150, 535);
                        text.drawOn(page);

                        try {
                            Desktop.getDesktop().open(new File(SystemSettingViewController.workingDirectory + "\\" + filename));

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




            }




            dialog.close();
        }catch(Exception e ){
            e.printStackTrace();
        }














    }



}
