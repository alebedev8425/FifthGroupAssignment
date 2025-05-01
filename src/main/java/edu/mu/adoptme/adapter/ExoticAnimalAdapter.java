package edu.mu.adoptme.adapter;

import edu.mu.adoptme.codetobeadapted.ExoticAnimal;
import edu.mu.adoptme.model.Pet;
/**
 * Adapter class that makes ExoticAnimal compatible with the Pet system.
 * Allows exotic animals to be used like regular pets in the adoption app.
 */

public class ExoticAnimalAdapter extends Pet {
	
	private static int idCounter = 1000;
    private ExoticAnimal exoticAnimal;

    public ExoticAnimalAdapter(ExoticAnimal exoticAnimal) {
        super(
        	idCounter++,
            exoticAnimal.getUniqueId(),       // name 
            exoticAnimal.getYearsOld(),       // age
            exoticAnimal.getType()            // species
        );
        this.exoticAnimal = exoticAnimal;
        this.setType("Exotic");
    }
    
    @Override
    public String toString() {
    	return "ExoticAnimalAdapter{"+
    			"name=' " + getName() + '\''+
    			", age=" + getAge() +
    			", species='" + getSpecies() + '\'' +
    			", adopted= " + isAdopted() +
    			'}';
    }
}
