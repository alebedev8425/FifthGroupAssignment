package edu.mu.adoptme.adapter;

import edu.mu.adoptme.codetobeadapted.ExoticAnimal;
import edu.mu.adoptme.model.Pet;
/**
 * Adapter class that makes ExoticAnimal compatible with the Pet system.
 * Allows exotic animals to be used like regular pets in the adoption app.
 */

public class ExoticAnimalAdapter extends Pet {
	
	 private static int idCounter = 1_000; // start high to avoid colliding with normal IDs
	    private final ExoticAnimal exotic;

	    public ExoticAnimalAdapter(ExoticAnimal exotic) {
	        // super(id, name, age, species)
	        super(idCounter++,
	              exotic.getAnimalName(),   // name
	              exotic.getYearsOld(), 
	              exotic.getCategory(),// age
	              exotic.getSubSpecies()    // species/breed
	        );
	        this.exotic = exotic;
	        // use category (“Dog”, “Cat”, “Rabbit”, or your exotic category) as the Pet type
	        setType(exotic.getCategory());
	    }
}