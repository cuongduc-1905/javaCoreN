/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author minh
 */
//create a table model to display to display the  ima


public class Mymodel extends AbstractTableModel{
    
    private String[] columns;
    private Object[][] rows;
    
    public Mymodel(){}
    
    public Mymodel(Object[][] data, String [] colomnsName){
        this.columns = colomnsName;
        this.rows = data;
        
    }
    
    public Class getColumnCalass(int col){
        
        //the index of the image column is 
        
        if(col == 7){
            return Icon.class;
        }
        else{
            return getValueAt(0, col).getClass();
        }
    }
    
    
    @Override
    public int getRowCount() {
        return this.rows.length;
    }

    @Override
    public int getColumnCount() {
        return this.columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.rows[rowIndex][columnIndex];
    }
    
    public String getColumnName(int col){
        return this.columns[col];
    }
    
}
