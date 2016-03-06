/*******************************************************************************
 *******************************************************************************
 *******************************************************************************
File: Provider.java
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
Description: Class Definitions for Provider class
********************************************************************************
********************************************************************************
*******************************************************************************/
package model;

public class Provider {
    
    private String name;
    private int number;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private char status;
    private ProviderServiceItem[] serviceList;
    private int totalVisits;
    private double totalFees;
    
    
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
    public ProviderServiceItem[] getServiceList() {
        return serviceList;
    }

    /**
     * @return the totalVisits
     */
    public int getTotalVisits() {
        return totalVisits;
    }

    /**
     * @return the totalFees
     */
    public double getTotalFees() {
        return totalFees;
    }
    
    //Setters

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(char status) {
        this.status = status;
    }

    /**
     * @param serviceList the serviceList to set
     */
    public void setServiceList(ProviderServiceItem[] serviceList) {
        this.serviceList = serviceList;
    }

    /**
     * @param totalVisits the totalVisits to set
     */
    public void setTotalVisits(int totalVisits) {
        this.totalVisits = totalVisits;
    }

    /**
     * @param totalFees the totalFees to set
     */
    public void setTotalFees(double totalFees) {
        this.totalFees = totalFees;
    }
    
    //Methods
    
    public ProviderServiceItem getNextServiceItem(){
        //TODO: Define method
        
        //Temporary Null return statement
        return null;
    }
    
     public void addServiceItem(ProviderServiceItem provServiceItem){
        //TODO: Define method
    }
   
    
    
}
