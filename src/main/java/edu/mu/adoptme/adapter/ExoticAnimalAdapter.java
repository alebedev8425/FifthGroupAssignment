package edu.mu.adoptme.adapter;

import edu.mu.adoptme.codetobeadapted.ExoticAnimal;
import edu.mu.adoptme.model.Pet;

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
