package edu.mu.adoptme.view;

import edu.mu.adoptme.model.Pet;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PetTableModel extends AbstractTableModel {
    private final List<Pet> pets;
    private final String[] cols = {"ID","Name","Type","Species","Age","Adopted"};

    /**
     * constructs a table using the given list of pets 
     * @param pets
     */
    public PetTableModel(List<Pet> pets) { this.pets = pets; }

    /**
     * returns the count of rows
     */
    @Override public int getRowCount()    { return pets.size(); }
    
    /**
     * returns the count of columns 
     */
    @Override public int getColumnCount() { return cols.length; }
    
    /**
     * returns the name of the column 
     */
    @Override public String getColumnName(int c) { return cols[c]; }

    
    /**
     * 
     *returns the value to be displayed
     * @param int row 
     * @param int col
     * @return corresponding field 
     */
    @Override
    public Object getValueAt(int row, int col) {
        Pet p = pets.get(row);
        switch (col) {
            case 0: return p.getId();
            case 1: return p.getName();
            case 2: return p.getType();    
            case 3: return p.getSpecies();  
            case 4: return p.getAge();
            case 5: return p.isAdopted();
            default: return "";
        }
    }
}