/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrentallist;
import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fares
 */
public class CarRentalList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Car c = new Car();
        c.setModel("Audi");
        c.setNumberPlate("WNR - 5408");
        Date d= new Date();
        d.setYear(2017);
        d.setMonth(1);
        d.setDate(8);
        d.setHours(0);
        d.setMinutes(0);
        d.setSeconds(0);
        c.setRdTaxExpDate(d);
        c.setRegYear("2009");
        c.setRegistrationNumber("32");
        c.setRentalRate(60);
        addCar(c);
        */
        CarRentalList cr = new CarRentalList();
        cr.readSavedCars();
    }
    public static void addCar(Car c){
        List<Car> Cars = new LinkedList<Car>();
        FileOutputStream fout;
        try {
            fout = new FileOutputStream("Cars.txt");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            Cars.add(c);
            out.writeObject(Cars);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CarRentalList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CarRentalList.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public LinkedList<Car> getExistingCars(){
        try{
            FileInputStream fin = new FileInputStream("Cars.txt");
            ObjectInputStream in = new ObjectInputStream(fin);
            LinkedList<Car> savedCars = (LinkedList<Car>)in.readObject();
            return savedCars;
        } catch (IOException  ex) {
           Logger.getLogger(CarRentalList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
           Logger.getLogger(CarRentalList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    public void readSavedCars(){
        LinkedList<Car> savedCars = getExistingCars();
        for (int i = 0; i < savedCars.size(); i++) {
            while(!savedCars.isEmpty()){
            savedCars.get(i);
            System.out.println(savedCars.get(i).getModel());
            System.out.println(savedCars.get(i).getNumberPlate());
            System.out.println(savedCars.get(i).getRdTaxExpDate());
            System.out.println(savedCars.get(i).getRegNumber());
            System.out.println(savedCars.get(i).getRegNumber());
            System.out.println(savedCars.get(i).getRegYear());
            System.out.println(savedCars.get(i).getRentalRate());
        }
        }
        
    }
    //public void 
}
