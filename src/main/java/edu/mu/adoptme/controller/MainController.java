package edu.mu.adoptme.controller;

import com.google.gson.Gson;
import edu.mu.adoptme.adapter.ExoticAnimalAdapter;
import edu.mu.adoptme.codetobeadapted.ExoticAnimal;
import edu.mu.adoptme.model.Pet;
import edu.mu.adoptme.model.Shelter;
import edu.mu.adoptme.model.comparator.AgeComparator;
import edu.mu.adoptme.model.comparator.SpeciesComparator;
import edu.mu.adoptme.utilities.JsonLoad;
import edu.mu.adoptme.utilities.JsonSave;
import edu.mu.adoptme.view.AddPetDialog;
import edu.mu.adoptme.view.MainFrame;
import edu.mu.adoptme.view.PetDetails;
import edu.mu.adoptme.view.PetTableModel;

import javax.swing.*;
import java.io.InputStreamReader;


/**
 * Controller for the Adopt Me! app.
 * Loads data, wires up button actions, updates the table, and handles JSON save.
 */
public class MainController {
    private final Shelter<Pet> shelter;
    private final MainFrame view;
    private final Gson gson = new Gson();

    public MainController(Shelter<Pet> shelter, MainFrame view) {
        this.shelter = shelter;
        this.view = view;
    }

    /** Call this once at startup to load data and wire up the UI. */
    public void init() {
        loadPets();
        populateTable();
        registerListeners();
    }

    /** Loads regular pets via JsonLoad and wraps & loads exotic pets via Gson+Adapter. */
    private void loadPets() {
        // for regular pets
        shelter.getAllPets().addAll(JsonLoad.loadPets());

       //for exotic pets 
        try (InputStreamReader reader = new InputStreamReader(
                getClass().getResourceAsStream("/exotic_animals.json"))) {
            ExoticAnimal[] raw = gson.fromJson(reader, ExoticAnimal[].class);
            for (ExoticAnimal ea : raw) {
                shelter.addPet(new ExoticAnimalAdapter(ea));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                view,
                "Failed to load exotic pets:\n" + e.getMessage(),
                "Load Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    /** Populates the JTable in the view with the current pet list. */
    private void populateTable() {
        PetTableModel model = new PetTableModel(shelter.getAllPets());
        view.getPetTable().setModel(model);
    }

    /** Attaches action listeners to all buttons and the sort combobox. */
    private void registerListeners() {
        view.getAddBtn().addActionListener(e -> onAdd());
        view.getAdoptBtn().addActionListener(e -> onAdopt());
        view.getRemoveBtn().addActionListener(e -> onRemove());
        view.getDetailsBtn().addActionListener(e -> onViewDetails());
        view.getSaveBtn().addActionListener(e -> onSave());
        view.getSortCombo().addActionListener(e -> onSort());
    }

    private void onAdd() {
        AddPetDialog dlg = new AddPetDialog(view);
        dlg.setVisible(true);
        if (!dlg.isConfirmed()) return;
        
        String type = dlg.getPetType();
        String species = dlg.getPetSpecies();


        /** Create the right subtype*/
        Pet pet;
        switch (type) {
            case "Dog":
                pet = new edu.mu.adoptme.model.Dog(
                    nextId(), dlg.getPetName(), dlg.getPetAge(), type, species, false
                );
                break;
            case "Cat":
                pet = new edu.mu.adoptme.model.Cat(
                    nextId(), dlg.getPetName(), dlg.getPetAge(), type, species, false
                );
                break;
            default:
                pet = new edu.mu.adoptme.model.Rabbit(
                    nextId(), dlg.getPetName(), dlg.getPetAge(), type, species, false
                );
        }
        pet.setType(type);
        shelter.addPet(pet);
        populateTable();
    }

    /**
     * This runs when you try to adopt a pet.
     * It checks if one is selected and tries to adopt it.
     */
    private void onAdopt() {
        int row = view.getPetTable().getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(view, "Please select a pet first.");
            return;
        }
        int id = (int) view.getPetTable().getValueAt(row, 0);
        boolean ok = shelter.adoptPet(id);
        if (!ok) {
            JOptionPane.showMessageDialog(
                view,
                "That pet cannot be adopted.",
                "Adopt Error",
                JOptionPane.WARNING_MESSAGE
            );
        }
        populateTable();
    }

    /**
     * Happens when you want to remove a pet from the list.
     * Makes sure one is selected and removes it using its ID.
     */
    private void onRemove() {
        int row = view.getPetTable().getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(view, "Please select a pet to remove.");
            return;
        }
        int id = (int) view.getPetTable().getValueAt(row, 0);
        boolean removed = shelter.removeById(id);
        if (!removed) {
            JOptionPane.showMessageDialog(
                view,
                "Could not remove pet (ID not found).",
                "Remove Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
        populateTable();
    }

    /**
     * This shows more info about the pet you clicked.
     * Opens a new window with the pet’s details.
     */
    private void onViewDetails() {
        int row = view.getPetTable().getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(view, "Please select a pet first.");
            return;
        }
        Pet pet = shelter.getAllPets().get(row);
        new PetDetails(view, pet).setVisible(true);
    }

    /**
     * This saves the pet list to a file.
     * It uses some JSON format and tells you when it's done.
     */
    private void onSave() {
        JsonSave.savePets(shelter.getAllPets());
        JOptionPane.showMessageDialog(
            view,
            "A new file in project with timesate pets.json format has been created to save.",
            "Save Complete",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    /**
     * This handles sorting pets.
     * Picks what to sort by based on the dropdown choice.
     */
    private void onSort() {
        String key = (String) view.getSortCombo().getSelectedItem();
        switch (key) {
            case "Age":
                shelter.sort(new AgeComparator());
                break;
            case "Species":
                shelter.sort(new SpeciesComparator());
                break;
            default: // Name
                shelter.sort(null); // uses Pet.compareTo()
        }
        populateTable();
    }

    

    /** 
     * Simple ID generator for newly added pets. 
     * 
     */
    private int nextId() {
        return shelter.getAllPets().stream()
            .mapToInt(Pet::getId)
            .max()
            .orElse(0) + 1;
    }
}