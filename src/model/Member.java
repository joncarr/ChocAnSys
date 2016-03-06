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

    private String name;
    private int number;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private char status;
    private MemberServiceItem[] serviceList;
    
    //Constructor
    
    //TODO: Create Constructors

    //Getters
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @return the zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @return the status
     */
    public char getStatus() {
        return status;
    }

    /**
     * @return the serviceList
     */
    public MemberServiceItem[] getServiceList() {
        return serviceList;
    }
    
    //Setters

    /**
     * @param mbrName the name to set
     */
    public void setName(String mbrName) {
        this.name = mbrName;
    }

    /**
     * @param mbrNbr the number to set
     */
    public void setNumber(int mbrNbr) {
        this.number = mbrNbr;
    }

    /**
     * @param mbrStreet the street to set
     */
    public void setStreet(String mbrStreet) {
        this.street = mbrStreet;
    }

    /**
     * @param mbrCity the city to set
     */
    public void setCity(String mbrCity) {
        this.city = mbrCity;
    }

    /**
     * @param mbrState the state to set
     */
    public void setState(String mbrState) {
        this.state = mbrState;
    }

    /**
     * @param mbrZipCode the zipCode to set
     */
    public void setZipCode(String mbrZipCode) {
        this.zipCode = mbrZipCode;
    }

    /**
     * @param mbrStatus the status to set
     */
    public void setStatus(char mbrStatus) {
        this.status = mbrStatus;
    }

    /**
     * @param serviceList the serviceList to set
     */
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
