package edu.mu.adoptme.model;

public class Dog extends Pet {
	
	public Dog() {
		super();
	}

	public Dog(int id, String name, int age, String species, boolean adopted) {
		super(id, name, age, species);
		setAdopted(adopted);
	}
	@Override
	public int compareTo(Pet o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
