package edu.mu.adoptme.model;

public abstract class Pet implements Comparable<Pet> {

	//Fields
	private int id; 
	private String name; 
	private String type; 
	private String species; 
	private int age; 
	private boolean adopted; 
	
	/**
	 * Getter and Setter for id field 
	 * @return int id 
	 */
	public int GetID() {
		return id; 
	}
	
	public void SetId(int id) { 
		this.id = id; 
	}
	
	
	/**
	 * Getter and Setter for name field
	 * @return String name 
	 */
	public String getName() {
		return name; 
	}
	
	public void SetName(String name) {
		this.name = name; 
	}
	
	
	/**
	 * Getter and Setter for type field
	 * @return String type 
	 */
	public String getType() {
		return type;
	}
	
	public void SetType(String type) { 
		this.type = type; 
	}
	

	/**
	 * Getter and Setter for species field 
	 * @return String species 
	 */
	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	/**
	 * Getter and Setter for age field 
	 * @return int age
	 */
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Getter and Setter for adopted field 
	 * @return boolean adopted 
	 */
	public boolean isAdopted() {
		return adopted;
	}

	public void setAdopted(boolean adopted) {
		this.adopted = adopted;
	}
	
	@Override
	public String toString() {
	    return "ID: " + id +
	           " Name: " + name +
	           " Species: " + species +
	           " Age: " + age +
	           " Status: " + (adopted ? "Adopted" : "Available");
	}
	
	
	
	
}
