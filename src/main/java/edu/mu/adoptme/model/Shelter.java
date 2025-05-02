package edu.mu.adoptme.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Shelter<T extends Pet> {
	
	private List<T> pets;
	
	public Shelter() {
	    pets = new ArrayList<>();
	}
	
	/**
	 * adds a new pet to pets list 
	 * @param pet
	 */
	public void addPet(T pet) {
		pets.add(pet); 
	}
	
	
	
	/**
	 * Removes a pet from pets based on ID 
	 * @param id
	 * @return boolean 
	 */
	public boolean removeById(int id) {
		for (T pet : pets) { 
			if (pet.getId() ==(id)) {
				pets.remove(pet); 
				return true;
			}
		}
		return false;
	}
	
	

	/**
	 * Gets pet based on ID 
	 * @param id
	 * @return pet
	 */
	public T getPetById(int id) {	
		for (T pet : pets) { 
			if (pet.getId() ==(id)) {
				return pet;
			}
		}
		return null;
	}
	
	
	
	/**
	 *changes pet.adopted to true if pet isn't already adopted 
	 * @param id
	 * @return boolean
	 */
	public boolean adoptPet(int id) {
		T pet = getPetById(id);
		if (pet != null && !pet.isAdopted()) {
			pet.setAdopted(true);
			return true; }
		return false;
		}
	
	
	
	/**
	 * returns a list of all pets 
	 * @return
	 */
	public List<T> getAllPets() {
        return pets;
    }
	
	
	
	/**
	 * returns a list of available pets to adopt
	 * @return List of pets
	 */
	public List<T> getAvailablePets() {
		List<T> availablePets  = new ArrayList<>();
		for(T pet : pets) { 
			if(!pet.isAdopted()) {
				availablePets.add(pet);
			}
		}
		return availablePets; 
	}
	
	
	public void sort(Comparator<Pet> comparator) {
	    if (comparator == null) {
	        Collections.sort(pets); // default: by name
	    } else {
	        pets.sort(comparator);
	    }
	}
	
	
	}
