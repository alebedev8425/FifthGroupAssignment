package edu.mu.adoptme.model;

public class Dog extends Pet {
	
	/**
	 * default constructor
	 */
	public Dog() {
		super();
	}
	
	/**
	 * constructs a dog 
	 * @param id
	 * @param name
	 * @param age
	 * @param type
	 * @param species
	 * @param adopted
	 */
	public Dog(int id, String name, int age, String type, String species, boolean adopted) {
		super(id, name, age, type, species);
		setAdopted(adopted);
	}


}
