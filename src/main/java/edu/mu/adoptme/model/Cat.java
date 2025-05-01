package edu.mu.adoptme.model;

public class Cat extends Pet{

	public Cat() {
		super();
	}
	
	public Cat(int id, String name, int age, String species, boolean adopted) {
		super(id, name, age, species);
		setAdopted(adopted);
	}


	}


