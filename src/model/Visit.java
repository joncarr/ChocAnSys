/*******************************************************************************
 *******************************************************************************
 *******************************************************************************
 File: Visit.java
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
 Description: Class Definitions for EFTReport class
 ********************************************************************************
 ********************************************************************************
 *******************************************************************************/

package model;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import javafx.scene.control.DatePicker;




public class Visit {
    
    private Date transactionDate;
    private Time transactionTime;
    private String serviceDate;
    private int providerNumber;
    private int memberNumber;
    private int serviceCode;
    private String comment;
    
    //Constructors
    
    public Visit(Date transDate, Time transTime, String servDate,
            int provNum, int memNum, int servCode, String comment){
        
        this.transactionDate = transDate;
        this.transactionTime = transTime;
        this.serviceDate = servDate;
        this.providerNumber = provNum;
        this.memberNumber = memNum;
        this.serviceCode = servCode;
        this.comment = comment;
    }

    public Visit(){

    }
    
    //Getters
    
    public Date getTransactionDate(){
        return transactionDate;        
    }
    
    public Time getTransactionTime(){
        return transactionTime;
    }

    public String getServiceDate(){
        return serviceDate;
    }
    
    public int getProviderNumber(){
        return providerNumber;
    }
    
    public int getMemberNumber(){
        return memberNumber;
    }
    
    public int getServiceCode(){
        return serviceCode;
    }
    
    public String getComment(){
        return comment;
    }

    //Setters

    public void setProviderNumber(int provNumber){ this.providerNumber = provNumber; }

    public void setMemberNumber (int mbrNumber){ this.memberNumber = mbrNumber; }

    public void setServiceCode (int svcCode ){ this.serviceCode = svcCode; }

    public void setServiceDate( String svcDate ){ this.serviceDate = svcDate; }




    public DatePicker datePicker;
    public static LocalDate currentDate;

    public void setPickerDate(){

        datePicker.setOnAction(event-> {
            Date modDate = new Date(datePicker.getValue().toEpochDay());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String date = df.format(modDate);



            this.serviceDate = date;
            System.out.println(serviceDate);
        });




    }



}
