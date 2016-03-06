/*******************************************************************************
 *******************************************************************************
 *******************************************************************************
File: MemberServiceItem.java
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
Description: Class Definitions for MemberServiceItem class
********************************************************************************
********************************************************************************
*******************************************************************************/
package model;

import java.util.Date;

public class MemberServiceItem {
    
    private Date date;
    private String providerName;
    private String serviceName;
    
    //Constructor
    
    public MemberServiceItem(Date date, String provName, String servName){
        this.date = date;
        this.providerName = provName;
        this.serviceName = servName;
    }
    
    //Getters
    
    public Date getDate(){
        return date;
    }
    
    public String getProviderName(){
        return providerName;
    }
    
    public String getServiceName(){
        return serviceName;
    }
    
}
