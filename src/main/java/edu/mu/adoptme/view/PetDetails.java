package edu.mu.adoptme.view;

import javax.swing.*;
import edu.mu.adoptme.model.Pet;
import java.awt.*;


public class PetDetails extends JDialog {
	/**
	 * allows for a modal dialog to be constructed which displays information about a pet. 
	 * @param owner
	 * @param pet
	 */
  public PetDetails(JFrame owner, Pet pet) {
    super(owner, "Pet Details", true);
    setLayout(new GridLayout(5,2,5,5));
    add(new JLabel("ID:"));       add(new JLabel(String.valueOf(pet.getId())));
    add(new JLabel("Name:"));     add(new JLabel(pet.getName()));
    add(new JLabel("Type:"));     add(new JLabel(pet.getType()));
    add(new JLabel("Species:"));  add(new JLabel(pet.getSpecies()));
    add(new JLabel("Age:"));      add(new JLabel(String.valueOf(pet.getAge())));
    add(new JLabel("Adopted:"));  add(new JLabel(pet.isAdopted()?"Yes":"No"));
    JButton ok = new JButton("Close");
    ok.addActionListener(e -> dispose());
    add(new JLabel()); add(ok);
    pack();
    setLocationRelativeTo(owner);
  }
}