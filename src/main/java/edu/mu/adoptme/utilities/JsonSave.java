package edu.mu.adoptme.utilities;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.mu.adoptme.model.Pet;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class JsonSave {

	/**
	 * Allows for a list of pets to be saved into a new json file.
	 * Creates a name based on the day and time and uses GsonBuilder() and PrettyPrinting() 
	 * to create a json file. 
	 * @param list of pets
	 */
	 public static void savePets(List<Pet> pets) {
		 
		 //Getting name for new json file
		 String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		 String filename = timestamp +"_pets.json"; 
		 
		 //Using prettyprint to format the new JSON output 
		 Gson gson = new GsonBuilder().setPrettyPrinting().create(); 
		 String jsoncontent = gson.toJson(pets);
		 
		 
		 try (FileWriter writer = new FileWriter(filename)) {
	            writer.write(jsoncontent);
	            System.out.println(" Pets saved to: " + filename);
	        } catch (IOException e) {
	            System.err.println(" Failed to save pets: " + e.getMessage());
	        }
	 }
}
