package edu.mu.adoptme.utilities;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.mu.adoptme.model.*;

import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.ArrayList;

public class JsonLoad {
/**
 * 
 * @return
 */
	public static List<Pet> loadPets() {
		Gson gsonloader = new Gson();
		
		InputStreamReader reader = new InputStreamReader(JsonLoad.class.getResourceAsStream("/pets.json"));
		
		Type listType = new TypeToken<List<PetDataHolder>>(){}.getType();
		List<PetDataHolder> list = gsonloader.fromJson(reader, listType);
	
		List<Pet> pets = new ArrayList<>(); 
		
		for (PetDataHolder petData : list ) {
			Pet pet = null; 
			String type = petData.type;
			
			if(type.equals("Dog")) { 
				pet = new Dog(petData.id, petData.name, petData.age, petData.species,petData.adopted);
			}
			
			else if (type.equals("Cat")) {
		        pet = new Cat(petData.id, petData.name, petData.age, petData.species,petData.adopted);
		    } 
			
			else if (type.equals("Rabbit")) {
		        pet = new Rabbit(petData.id, petData.name, petData.age, petData.species, petData.adopted);
		    }

		if(pet != null) { 
			pets.add(pet); 
			}
		}
		return pets; 
	}

}
