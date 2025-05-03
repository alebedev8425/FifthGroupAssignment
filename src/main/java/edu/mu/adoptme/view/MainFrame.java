package edu.mu.adoptme.view;

import javax.swing.*;

import edu.mu.adoptme.controller.MainController;
import edu.mu.adoptme.model.Pet;
import edu.mu.adoptme.model.Shelter;

import java.awt.*;
/**
 * creates the main window for the application 
 * Displays all pets as well as the necessary buttons 
 */
public class MainFrame extends JFrame {
  private final JTable petTable = new JTable();
  private final JButton addBtn     = new JButton("Add");
  private final JButton adoptBtn   = new JButton("Adopt");
  private final JButton removeBtn  = new JButton("Remove");
  private final JButton detailsBtn = new JButton("View Details");
  private final JButton saveBtn    = new JButton("Save");
  private final JComboBox<String> sortCombo =
    new JComboBox<>(new String[]{"Name","Age", "Species"});

  public MainFrame() {
    super("Adopt Me!");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout(5,5));

    // Pet table
    add(new JScrollPane(petTable), BorderLayout.CENTER);

    // Controls panel
    JPanel bottom = new JPanel();
    bottom.add(addBtn);
    bottom.add(adoptBtn);
    bottom.add(removeBtn);
    bottom.add(detailsBtn);
    bottom.add(new JLabel("Sort by:"));
    bottom.add(sortCombo);
    bottom.add(saveBtn);
    add(bottom, BorderLayout.SOUTH);

    setSize(800,400);
    setLocationRelativeTo(null);
  }

  /**
   * Getters for the controllers 
   * @return respective button components 
   */
  public JTable getPetTable()     { return petTable; }
  public JButton getAddBtn()      { return addBtn; }
  public JButton getAdoptBtn()    { return adoptBtn; }
  public JButton getRemoveBtn()   { return removeBtn; }
  public JButton getDetailsBtn()  { return detailsBtn; }
  public JButton getSaveBtn()     { return saveBtn; }
  public JComboBox<String> getSortCombo() { return sortCombo; }
  
  
  /**
   * Main starts here
   * @param args
   */
  public static void main(String[] args) {
	    SwingUtilities.invokeLater(() -> {
	        MainFrame frame = new MainFrame();
	        Shelter<Pet> shelter = new Shelter<>();
	        MainController controller = new MainController(shelter, frame);
	        controller.init(); 
	        frame.setVisible(true);
	    });
	}
}