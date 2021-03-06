/*******************************************************************************
 * ******************************************************************************
 * ******************************************************************************
 * File: Service.java
 * Project: IntelliJ IDEA 15.0
 * Assignment: Chocoholics Anonymous System
 * University: McMurry University
 * Course: COSC–4360 Spring 2016
 * Instructor: Mr. Brozovic
 * Programmer: Jon Carr
 * Date: January 13, 2016
 * Update by: Additional coder’s name
 * Updated: Date code was updated
 * Compiler: NetBeans IDE Java SE
 * Description: Class Definitions for EFTReport class
 * *******************************************************************************
 * *******************************************************************************
 *******************************************************************************/

package model;

public class Service {

    private String name;
    private int code;
    private float fee;
    private String status;       //Changed from Char to String 10 March 2016

    //Constructor

    public Service() {
    }

    public Service(int code, String description, float fee, String status) {
        this.code = code;
        this.name = description;
        this.fee = fee;
        this.status = status;
    }

    //Getters

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public float getFee() {
        return fee;
    }

    public String getStatus() {
        return status;
    }

    //Setters

    public void setName(String svcName) {
        this.name = svcName;
    }

    public void setCode(int svcCode) {
        this.code = svcCode;
    }

    public void setFee(float svcFee) {
        this.fee = svcFee;
    }

    public void setStatus(String svcStatus) {
        this.status = svcStatus;
    }


}
