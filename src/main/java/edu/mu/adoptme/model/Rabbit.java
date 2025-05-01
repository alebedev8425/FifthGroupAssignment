package edu.mu.adoptme.model;

public class Rabbit extends Pet  {
	
	
	public Rabbit() {
		super();
	}
	
	public Rabbit(int id, String name, int age, String species, boolean adopted) {
		super(id, name, age, species);
		setAdopted(adopted);
	}


}
