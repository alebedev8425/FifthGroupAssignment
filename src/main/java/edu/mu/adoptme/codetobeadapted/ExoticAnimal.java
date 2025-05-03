package edu.mu.adoptme.codetobeadapted;

/**
 * This class is for exotic animals from another system.
 * It's not part of the normal Pet stuff, so we need to adapt it if we want to use it.
 */
public class ExoticAnimal {
	
	private int yearsOld;
	private String uniqueId;
	private String animalName;
	private String category;
	private String subSpecies;
	
	/**
	 * Basic constructor for making an ExoticAnimal.
	 * Just fills in all the info when you make one.
	 */
	public ExoticAnimal(String uniqueId, String animalName, String category, String subSpecies, int yearsOld) {
		this.uniqueId = uniqueId;
		this.animalName = animalName;
		this.category = category;
		this.subSpecies = subSpecies;
		this.yearsOld = yearsOld;	
	}

	/**
	 * Gets how old the animal is.
	 */
	public int getYearsOld() {
		return yearsOld;
	}

	/**
	 * Changes how old the animal is.
	 */
	public void setYearsOld(int yearsOld) {
		this.yearsOld = yearsOld;
	}

	/**
	 * Gets the ID for the animal.
	 */
	public String getUniqueId() {
		return uniqueId;
	}

	/**
	 * Sets a new ID.
	 */
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	/**
	 * Gets the name of the animal.
	 */
	public String getAnimalName() {
		return animalName;
	}

	/**
	 * Changes the animal's name.
	 */
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	/**
	 * Gets the general type of animal.
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Changes the animal's category.
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Gets the more specific type of animal.
	 */
	public String getSubSpecies() {
		return subSpecies;
	}

	/**
	 * Changes the sub-species.
	 */
	public void setSubSpecies(String subSpecies) {
		this.subSpecies = subSpecies;
	}

	/**
	 * Gives back all the animal's info as a string.
	 */
	@Override
	public String toString() {
		return "ExoticAnimal [yearsOld=" + yearsOld + ", uniqueId=" + uniqueId + ", animalName=" + animalName
				+ ", category=" + category + ", subSpecies=" + subSpecies + "]";
	}
}
