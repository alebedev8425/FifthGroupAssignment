package edu.mu.adoptme.model.comparator;

import edu.mu.adoptme.model.Pet;
import java.util.Comparator;

public class SpeciesComparator implements Comparator<Pet>{

	/**
	 * Allows for comparison between Pets based alphabetically on species
	 * @return int 
	 */
	@Override
	public int compare(Pet o1, Pet o2) {
		// TODO Auto-generated method stub
		return o1.getSpecies().compareToIgnoreCase(o2.getSpecies());
	}

}
