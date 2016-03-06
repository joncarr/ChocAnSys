/*******************************************************************************
 *******************************************************************************
 *******************************************************************************
File: Visit.java
Project: Netbeans IDE 8.1 Beta
Assignment: Chocoholics Anonymous System
University: McMurry University
Course: COSC–4360 Spring 2016 
Instructor: Mr. Brozovic
Programmer: Initial coder’s name
Date: January 13, 2016
Update by: Additional coder’s name
Updated: Date code was updated
Compiler: NetBeans IDE Java SE
Description: Class Definitions for Visit class
********************************************************************************
********************************************************************************
*******************************************************************************/
package model;

import java.sql.Time;
import java.util.Date;

public class Visit {
    
    private Date transactionDate;
    private Time transactionTime;
    private Date serviceDate;
    private int providerNumber;
    private int memberNumber;
    private int serviceCode;
    private String comment;
    
    //Constructors
    
    public Visit(Date transDate, Time transTime, Date servDate,
            int provNum, int memNum, int servCode, String comment){
        
        this.transactionDate = transDate;
        this.transactionTime = transTime;
        this.serviceDate = servDate;
        this.providerNumber = provNum;
        this.memberNumber = memNum;
        this.serviceCode = servCode;
        this.comment = comment;
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
    
}