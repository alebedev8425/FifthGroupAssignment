package edu.mu.adoptme.view;

import edu.mu.adoptme.model.Pet;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PetTableModel extends AbstractTableModel {
    private final List<Pet> pets;
    private final String[] cols = {"ID","Name","Species","Age","Adopted"};

    public PetTableModel(List<Pet> pets) { this.pets = pets; }

    @Override public int getRowCount()    { return pets.size(); }
    @Override public int getColumnCount() { return cols.length; }
    @Override public String getColumnName(int c) { return cols[c]; }

    @Override
    public Object getValueAt(int row, int col) {
      Pet p = pets.get(row);
      switch(col) {
        case 0: return p.getId();
        case 1: return p.getName();
        case 2: return p.getSpecies();
        case 3: return p.getAge();
        case 4: return p.isAdopted();
        default: return "";
      }
    }
}