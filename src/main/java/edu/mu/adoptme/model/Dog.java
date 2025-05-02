package edu.mu.adoptme.model;

public class Dog extends Pet {
	
	public Dog() {
		super();
	}

	public Dog(int id, String name, int age, String type, String species, boolean adopted) {
		super(id, name, age, type, species);
		setAdopted(adopted);
	}


}
