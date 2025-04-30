package edu.mu.adoptme.utilities;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.mu.adoptme.model.*;

import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.ArrayList;

public class JsonLoad {

	public static List<Pet> loadPets() {
		Gson gsonloader = new Gson();
		
		InputStreamReader reader = new InputStreamReader(JsonLoad.class.getResourceAsStream("/pets.json"));
		
		return null;
	
	}
}
