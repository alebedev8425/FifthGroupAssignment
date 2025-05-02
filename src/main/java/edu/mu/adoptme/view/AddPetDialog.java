package edu.mu.adoptme.view;

import javax.swing.*;
import java.awt.*;

public class AddPetDialog extends JDialog {
    private final JComboBox<String> typeCombo =
        new JComboBox<>(new String[]{"Dog","Cat","Rabbit"});
    private final JTextField nameField    = new JTextField(15);
    private final JTextField speciesField = new JTextField(15);
    private final JTextField ageField     = new JTextField(3);
    private boolean confirmed = false;

    public AddPetDialog(JFrame owner) {
        super(owner,"Add New Pet",true);
        setLayout(new GridLayout(5,2,5,5));
        add(new JLabel("Type:"));    add(typeCombo);
        add(new JLabel("Name:"));    add(nameField);
        add(new JLabel("Species:")); add(speciesField);
        add(new JLabel("Age:"));     add(ageField);

        JButton ok     = new JButton("OK");
        JButton cancel = new JButton("Cancel");
        ok.addActionListener(e -> { confirmed = true; dispose(); });
        cancel.addActionListener(e -> dispose());

        add(ok); add(cancel);
        pack(); setLocationRelativeTo(owner);
    }

    public boolean isConfirmed()    { return confirmed; }
    public String  getPetType()     { return (String)typeCombo.getSelectedItem(); }
    public String  getPetName()     { return nameField.getText().trim(); }
    public String  getPetSpecies()  { return speciesField.getText().trim(); }
    public int     getPetAge()      { return Integer.parseInt(ageField.getText().trim()); }
}