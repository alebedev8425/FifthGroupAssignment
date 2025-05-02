package edu.mu.adoptme.utilities;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.mu.adoptme.model.Pet;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import java.util.List;

public class JsonSave {

	private static final Gson GSON = new GsonBuilder()
	        .setPrettyPrinting()
	        .create();

	    public static void savePets(List<Pet> pets) {
	        // Build a path to the source resource file:
	        Path resourcePath = Paths.get(
	            System.getProperty("user.dir"),    // your project root
	            "src", "main", "java", "resources", "pets.json"
	        );

	        try {
	            // Convert to JSON
	            String json = GSON.toJson(pets);

	            // Overwrite the src/main/resources/pets.json file
	            Files.write(
	                resourcePath,
	                json.getBytes(StandardCharsets.UTF_8),
	                StandardOpenOption.CREATE,
	                StandardOpenOption.TRUNCATE_EXISTING
	            );

	            System.out.println("Overwrote resource: " + resourcePath);
	        } 
	        catch (IOException e) {
	            System.err.println("Failed to save pets.json in resources: " + e.getMessage());
	        }
	    }
}
