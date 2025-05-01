package edu.mu.adoptme.model;
import edu.mu.adoptme.model.*;
import java.util.Collections;
import java.util.List;

public class PetTestMain {

	public static void main(String[] args) {
		// Create a Shelter to hold Pet objects
        Shelter<Pet> shelter = new Shelter<>();

        // Add some test pets
        shelter.addPet(new Dog(1, "Zoe", 3, "Beagle", false));
        shelter.addPet(new Cat(2, "Mittens", 2, "Tabby", false));
        shelter.addPet(new Rabbit(3, "Archie", 1, "Dwarf", false));
        shelter.addPet(new Dog(4, "Buddy", 5, "Labrador", false));

        // Get the full list
        List<Pet> pets = shelter.getAllPets();

        // Print unsorted list
        System.out.println("Before sorting:");
        for (Pet pet : pets) {
            System.out.println(pet);
        }

        // Sort by name (uses Comparable)
        Collections.sort(pets);

        // Print sorted list
        System.out.println("\nAfter sorting by name:");
        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }

	}


