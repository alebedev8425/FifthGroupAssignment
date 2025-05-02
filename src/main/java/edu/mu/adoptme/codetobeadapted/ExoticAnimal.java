package edu.mu.adoptme.codetobeadapted;
/**
 * Represents an exotic animal provided by a third-party system.
 * This class is not part of the main Pet hierarchy and needs adaptation.
 */
public class ExoticAnimal {
	
	private int yearsOld;
	private String uniqueId;
	private String animalName;
	private String category;
	private String subSpecies;
	
	
	public ExoticAnimal(String uniqueId, String animalName, String category, String subSpecies, int yearsOld) {
		this.uniqueId = uniqueId;
		this.animalName = animalName;
		this.category = category;
		this.subSpecies = subSpecies;
		this.yearsOld = yearsOld;	
	}


	public int getYearsOld() {
		return yearsOld;
	}


	public void setYearsOld(int yearsOld) {
		this.yearsOld = yearsOld;
	}


	public String getUniqueId() {
		return uniqueId;
	}


	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}


	public String getAnimalName() {
		return animalName;
	}


	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getSubSpecies() {
		return subSpecies;
	}


	public void setSubSpecies(String subSpecies) {
		this.subSpecies = subSpecies;
	}


	@Override
	public String toString() {
		return "ExoticAnimal [yearsOld=" + yearsOld + ", uniqueId=" + uniqueId + ", animalName=" + animalName
				+ ", category=" + category + ", subSpecies=" + subSpecies + "]";
	}


}