package edu.mu.adoptme.model.comparator;

import edu.mu.adoptme.model.Pet;
import java.util.Comparator;

public class AgeComparator implements Comparator<Pet> {

	/**
	 * Allows comparison between pets based on age 
	 * @return int 
	 */
	@Override
	public int compare(Pet o1, Pet o2) {
		// TODO Auto-generated method stub
		return Integer.compare(o1.getAge(),o2.getAge());
	}

}
