/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrentallist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
    public void setNumberPlate(String np){
        numberPlate=np;
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
    public void addCar(Car c){
        List<Car> Cars = new ArrayList<Car>();
        FileOutputStream fout;
        try {
            fout = new FileOutputStream("Cars.txt");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            Cars.add(c);
            out.writeObject(Cars);
            out.close();
        } catch (FileNotFoundException ex) {
           // Logger.getLogger(CarRentalList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
           // Logger.getLogger(CarRentalList.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public boolean validateRate(Car c){
        try{
            if(c.getRentalRate()>0){
                return true;
            }
        }
        catch(Exception e){
            
        }
        JOptionPane.showMessageDialog(null,"Invalid rental rate found !");
        return false;
    }
    public ArrayList<Car> getExistingCars(){
        ArrayList<Car> savedCars = new ArrayList<>();
        try{
            FileInputStream fin = new FileInputStream("Cars.txt");
            ObjectInputStream in = new ObjectInputStream(fin);
                savedCars=(ArrayList<Car>)in.readObject();
            in.close();
            fin.close();
        } catch (IOException  ex) {
           Logger.getLogger(CarRentalList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
           Logger.getLogger(CarRentalList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return savedCars;
    }
    public void readSavedCars(){
        ArrayList<Car> savedCars = getExistingCars();
        for (int i = 0; i < savedCars.size(); i++) {
            while(!savedCars.isEmpty()){
            savedCars.get(i);
            System.out.println(savedCars.get(i).getModel());
            System.out.println(savedCars.get(i).getNumberPlate());
            System.out.println(savedCars.get(i).getRdTaxExpDate());
            //System.out.println(savedCars.get(i).getRegNumber());
            System.out.println(savedCars.get(i).getRegNumber());
            System.out.println(savedCars.get(i).getRegYear());
            System.out.println(savedCars.get(i).getRentalRate());
        }
        }
        
    }
    public Car searchCar(String np){
        ArrayList<Car> Cars = getExistingCars();
        //Car c = new Car();
        for(int i=0;i<Cars.size();i++){
            if(Cars.get(i).getNumberPlate().equals(np)){
                return Cars.get(i);
            }
        }
        return null;
    }
}
