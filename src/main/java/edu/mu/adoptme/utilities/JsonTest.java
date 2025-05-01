package edu.mu.adoptme.utilities;

import java.util.List;

import edu.mu.adoptme.model.Pet;

public class JsonTest {
/**
 * A simple test for JsonLoad and JsonSave.
 * JsonLoad.LoadPets() should correctly read the from the file ( file path in loadPets()) 
 * correctly display each pet using a for loop. 
 * savePets should put all the data into a new json once project is refreshed. 
 * @param args
 */
	public static void main(String[] args) {
		  List<Pet> pets = JsonLoad.loadPets();

	        for (Pet pet : pets) {
	            System.out.println(pet);  
	        }
	        
	        JsonSave.savePets(pets);
	    }

	}


