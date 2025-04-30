package edu.mu.adoptme.utilities;

import java.util.List;

import edu.mu.adoptme.model.Pet;

public class JsonTest {

	public static void main(String[] args) {
		  List<Pet> pets = JsonLoad.loadPets();

	        for (Pet pet : pets) {
	            System.out.println(pet);  
	        }
	        
	        JsonSave.savePets(pets);
	    }

	}


