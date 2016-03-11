/*******************************************************************************
 *******************************************************************************
 *******************************************************************************
 * File: Member.java
 * Project: Netbeans IDE 8.1 Beta
 * Assignment: Chocoholics Anonymous System
 * University: McMurry University
 * Course: COSC–4360 Spring 2016
 * Instructor: Mr. Brozovic
 * Programmer: Initial coder’s name
 * Date: January 13, 2016
 * Update by: Additional coder’s name
 * Updated: Date code was updated
 * Compiler: NetBeans IDE Java SE
 * Description: Class Definitions for Member class
 *******************************************************************************
 *******************************************************************************
 ******************************************************************************/
package model;

public class Member {

    private String firstName;
    private String lastName;
    private int number;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String status;  //Changed from char to String 7 March 2016
    private MemberServiceItem[] serviceList;
    
    //Constructor
    
    public Member(int mbrNum, String firstName, String lastName,
                  String street, String city, String state, String zipCode,
                  String mbrStatus){
        this.number = mbrNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.status = mbrStatus;
    }

    //Getters

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getNumber() {
        return number;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getStatus() {
        return status;
    }

    public MemberServiceItem[] getServiceList() {
        return serviceList;
    }
    
    //Setters


    public void setFirstName(String mbrFirstName) {
        this.firstName = mbrFirstName;
    }

    public void setLastName(String mbrLastName) {
        this.firstName = mbrLastName;
    }

    public void setNumber(int mbrNbr) {
        this.number = mbrNbr;
    }

    public void setStreet(String mbrStreet) {
        this.street = mbrStreet;
    }

    public void setCity(String mbrCity) {
        this.city = mbrCity;
    }

    public void setState(String mbrState) {
        this.state = mbrState;
    }

    public void setZipCode(String mbrZipCode) {
        this.zipCode = mbrZipCode;
    }

    public void setStatus(String mbrStatus) {
        this.status = mbrStatus;
    }

    public void setServiceList(MemberServiceItem[] serviceList) {
        this.serviceList = serviceList;
    }
    
    //Methods
    
    
    public MemberServiceItem getNextServiceItem(){
        //TODO: Define method
        
        //Temporary Null return statement
        return null;
    }
    
    
    public void addServiceItem(MemberServiceItem mbrServiceItem){
        //TODO: Define method
    }
   

}
