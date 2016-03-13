/*******************************************************************************
 *******************************************************************************
 *******************************************************************************
 File: ProviderServiceItem.java
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
import java.util.Date;

public class ProviderServiceItem {
    
    private Date transactionDate;
    private Time transactionTime;
    private Date serviceDate;
    private int memberNumber;
    private String memberName;
    private int serviceCode;
    private float fee;
    
    //Constructor
    
    public ProviderServiceItem(Date transDate, Time transTime, Date servDate,
            int mbrNumber, String mbrName, int servCode, float fee){
        
        this.transactionDate = transDate;
        this.transactionTime = transTime;
        this.serviceDate = servDate;
        this.memberNumber = mbrNumber;
        this.memberName = mbrName;
        this.serviceCode = servCode;
        this.fee = fee;
        
    }
    
    //Getters
    
    public Date getTransactionDate(){
        return transactionDate;
    }
    
    public Time getTransactionTime(){
        return transactionTime;
    }
    
    public Date getServiceDate(){
        return serviceDate;
    }
    
    public int getMemberNumber(){
        return memberNumber;
    }
    
    public String getMemberName(){
        return memberName;
    }
    
    public int getServiceCode(){
        return serviceCode;
    }
    
    public float getFee(){
        return fee;
    }
}
