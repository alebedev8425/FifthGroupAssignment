package edu.mu.adoptme.model;

public class Cat extends Pet{
	/**
	 * default constructor 
	 */
	public Cat() {
		super();
	}
	
	/**
	 * constructs a new cat
	 * @param id
	 * @param name
	 * @param age
	 * @param type
	 * @param species
	 * @param adopted
	 */
	public Cat(int id, String name, int age, String type, String species, boolean adopted) {
		super(id, name, age, type, species);
		setAdopted(adopted);
	}


	}


