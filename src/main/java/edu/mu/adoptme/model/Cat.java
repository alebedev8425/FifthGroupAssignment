package edu.mu.adoptme.model;

public class Cat extends Pet{

	public Cat() {
		super();
	}
	
	public Cat(int id, String name, int age, String type, String species, boolean adopted) {
		super(id, name, age, type, species);
		setAdopted(adopted);
	}


	}


