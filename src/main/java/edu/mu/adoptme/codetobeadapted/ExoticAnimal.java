package edu.mu.adoptme.codetobeadapted;
/**
 * Represents an exotic animal provided by a third-party system.
 * This class is not part of the main Pet hierarchy and needs adaptation.
 */
public class ExoticAnimal {
	
	private String type;
	private int yearsOld;
	private String uniqueId;
	
	public ExoticAnimal(String type, int yearsOld, String uniqueId) {
		this.type = type;
		this.yearsOld = yearsOld;
		this.uniqueId = uniqueId;	
	}

	public String getType () {
		return type;
	}
	
	public int getYearsOld() {
		return yearsOld;
	}
	
	public String getUniqueId() {
		return uniqueId;
	}
	
	@Override
	public String toString() {
		return "ExoticAnimal{" +
				"type='" + type + '\'' +
				", yearsOld=" + yearsOld +
				", uniqueId'" + uniqueId + '\'' +
				'}';
	}
}