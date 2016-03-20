/*******************************************************************************
 *******************************************************************************
 *******************************************************************************
 File: Provider.java
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

public class Provider {

    private int number;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String status;                    //Changed from char to String on 10 March 2016
    private ProviderServiceItem[] serviceList;
    private int totalVisits;
    private double totalFees;
    
    
    //Constructor

    public Provider(){}

    public Provider(int provNum, String firstName, String lastName,
                  String street, String city, String state, String zipCode,
                  String provStatus){
        this.number = provNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.status = provStatus;
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

    public ProviderServiceItem[] getServiceList() {
        return serviceList;
    }

    public int getTotalVisits() {
        return totalVisits;
    }

    public double getTotalFees() {
        return totalFees;
    }
    
    //Setters

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setServiceList(ProviderServiceItem[] serviceList) {
        this.serviceList = serviceList;
    }

    public void setTotalVisits(int totalVisits) {
        this.totalVisits = totalVisits;
    }

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
