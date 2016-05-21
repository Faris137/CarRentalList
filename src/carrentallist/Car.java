/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrentallist;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Fares
 */
public class Car implements Serializable{
    private String model,regNumber,regYear,numberPlate;
    private Date rdTaxExpDate;
    private double rentalRate;
    public String getModel(){
        return model;
    }
    public String getRegNumber(){
        return regNumber;
    }
    public String getRegYear(){
        return regYear;
    }
    public Date getRdTaxExpDate(){
        return rdTaxExpDate;
    }
    public double getRentalRate(){
        return rentalRate;
    }
    public String getNumberPlate(){
        return numberPlate;
    }
    public void setNumberPlate(String nPlate){
        numberPlate=nPlate;
    }
    public void setModel(String m){
        model=m;
    }
    public void setRegistrationNumber(String rn){
        regNumber=rn;
    }
    public void setRegYear(String ry){
        regYear=ry;
    }
    public void setRdTaxExpDate(Date rd){
        rdTaxExpDate=rd;
    }
    public void setRentalRate(double rate){
        rentalRate=rate;
    }
}
