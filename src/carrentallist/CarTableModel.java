/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrentallist;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CarTableModel extends AbstractTableModel {
  private List<Car> cars ;
  private String[] columns ; 

  public CarTableModel(List<Car> carList){
    super();
    cars = carList;
    columns = new String[]{"Model","Number plate","RD Tax Expiry", "Registered number", "Registred year", "Rental rate"};
  }

  // Number of column of your table
  public int getColumnCount() {
    return columns.length ;
  }

  // Number of row of your table
  public int getRowsCount() {
    return cars.size();
  }

  // The object to render in a cell
  public Object getValueAt(int row, int col) {
    Car car = cars.get(row);
    switch(col) {
      case 0: return car.getModel();
      case 1 : return car.getNumberPlate();
      case 3 : return car.getRdTaxExpDate();
      case 4 : return car.getRegNumber();
      case 5 : return car.getRegYear();
      case 6 : return car.getRentalRate();
      // to complete here...
      default: return null;
    }
  }

  // Optional, the name of your column
  public String getColumnName(int col) {
    return columns[col] ;
  }

    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}