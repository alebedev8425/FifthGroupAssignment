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
	 * Constructor for pet
	 * @param id
	 * @param name
	 * @param age
	 * @param species
	 */
	public Pet(int id, String name, int age, String type, String species) {
	    this.id = id;
	    this.name = name;
	    this.age = age;
	    this.type = type;
	    this.species = species;
	    this.adopted = false; 
	}
	
	
	/**
	 * allows for sorting
	 * @param Pet
	 */
	public int compareTo(Pet other) {
	    return this.name.compareToIgnoreCase(other.name);
	}
	
	/**
	 * default constructor 
	 */
	public Pet() {
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * Getter and Setter for id field 
	 * @return int id 
	 */
	public int getId() {
		return id; 
	}
	
	public void setId(int id) { 
		this.id = id; 
	}
	
	
	/**
	 * Getter and Setter for name field
	 * @return String name 
	 */
	public String getName() {
		return name; 
	}
	
	public void setName(String name) {
		this.name = name; 
	}
	
	
	/**
	 * Getter and Setter for type field
	 * @return String type 
	 */
	public String getType() {
		return type;
	}
	
	public void setType(String type) { 
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
	
	/**
	 * to string method 
	 */
	@Override
	public String toString() {
	    return "ID: " + id +
	           ", Name: " + name +
	           ", Species: " + species +
	           ", Age: " + age +
	           ", Status: " + (adopted ? "Adopted" : "Available");
	}
	
	
	
	
}
