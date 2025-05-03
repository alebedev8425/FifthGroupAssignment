package edu.mu.adoptme.model;

public class Rabbit extends Pet  {
	
	/**
	 * default constructor 
	 */
	public Rabbit() {
		super();
	}
	
	/**
	 * constructs a rabbit 
	 * @param id
	 * @param name
	 * @param age
	 * @param type
	 * @param species
	 * @param adopted
	 */
	public Rabbit(int id, String name, int age, String type, String species, boolean adopted) {
		super(id, name, age, type, species);
		setAdopted(adopted);
	}


}
