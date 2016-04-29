/*******************************************************************************
 *******************************************************************************
 *******************************************************************************
 File: ProcessVisitViewController.java
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

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javafx.scene.paint.Color;
import model.DBConnection;
import model.Member;
import model.Visit;
import java.time.LocalDate;


public class ProcessVisitViewController {

    ChocAnSysApp main;
    Stage dialog;
    private Connection db;
    @FXML private TextField textFieldMemberNumber;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private SimpleDateFormat tf = new SimpleDateFormat("yyyy-MM-dd");


    @FXML private DatePicker datePickerServiceDate;
    @FXML private Label lblServiceFee;
    @FXML private Label lblServiceName;
    @FXML private Label lblCurrentMemberStatus;
    @FXML private TextField textFieldProviderSeenID;
    @FXML private TextField textFieldServiceCodeID;
    @FXML private GridPane gridPaneEnterVisit;
    @FXML private GridPane gridPaneCommentSection;
    @FXML private TextArea textAreaComment;
    public static LocalDate serviceDate;

    public void setMain(ChocAnSysApp main, Stage dialog){
        this.main = main;                                   //makes a connection main class
        this.dialog = dialog;                               // makes connection to dialog box displayed
        gridPaneEnterVisit.setDisable(true);                //disables user input for input pane
        gridPaneCommentSection.setDisable(true);            //disables user input for comment pane
        db = DBConnection.connect();                        //makes connection to the database
        datePickerServiceDate.setValue(LocalDate.now());    //sets date picker to current date
        datePickerServiceDate.setOnAction(event -> {        //
            serviceDate = datePickerServiceDate.getValue(); //service date listener for changing date
            //tf.format(serviceDate);
            //System.out.println(serviceDate);              //
        });

    }


    public void validateMemberBtnHandler(){
        Member member = new Member();
        try{
            stmt = db.createStatement();
            rs = stmt.executeQuery("select * from members where id = " + textFieldMemberNumber.getText() + " ;");
            member.setStatus(rs.getString("status"));
            lblCurrentMemberStatus.setTextFill(Color.web("#000000"));
            lblCurrentMemberStatus.setText(member.getStatus());
            if (lblCurrentMemberStatus.getText().equals("Active")){
                gridPaneEnterVisit.setDisable(false);
                gridPaneCommentSection.setDisable(false);
            }

            //textFieldMemberNumber.clear();

        }catch( Exception e){
            lblCurrentMemberStatus.setTextFill(Color.web("#FF0000"));

            lblCurrentMemberStatus.setText("Number Not Found");
            e.printStackTrace();
        }
    }



    @FXML
    public void submitClaimBtnHandler(){



        String servDate = datePickerServiceDate.getValue().toString();
        String dateEntered = datePickerServiceDate.getValue().toString();
        System.out.println("time 1: " + servDate);
        System.out.println("time 2: " + dateEntered);


        Visit visit = new Visit(
                servDate,
                dateEntered,
                Integer.parseInt(textFieldProviderSeenID.getText()),
                Integer.parseInt(textFieldMemberNumber.getText()),
                Integer.parseInt(textFieldServiceCodeID.getText()),
                textAreaComment.getText());

        try {
            pstmt = db.prepareStatement("insert into visits VALUES (?,?,?,?,?,?);");
            pstmt.setString(1, servDate);
            pstmt.setString(2, dateEntered);
            pstmt.setInt(3, visit.getProviderNumber());
            pstmt.setInt(4, visit.getMemberNumber());
            pstmt.setInt(5, visit.getServiceCode());
            pstmt.setString(6, visit.getComment());
            pstmt.execute();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Process Visit");
            alert.setContentText("Visit successfully processed.");
            alert.showAndWait();
            db.close();
            dialog.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


//            if ( lblCurrentMemberStatus.getText().equals("Number Not Found") ) {
//                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//                alert.setHeaderText("Process Visit");
//                alert.setContentText("Enter in valid, active member!");
//                alert.showAndWait();
//            }




    }

    @FXML
    public void cancelBtnHandler(){
        dialog.close();
    }

    @FXML
    public void onEnter(){
        try {
            rs = stmt.executeQuery("select * from services where svccode = " + textFieldServiceCodeID.getText() + " ;");
            lblServiceName.setText(rs.getString("svcdescription"));
            lblServiceFee.setText("$" + rs.getString("fee") + "0");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
