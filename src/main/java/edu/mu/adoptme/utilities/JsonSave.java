package edu.mu.adoptme.utilities;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.mu.adoptme.model.Pet;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

public class JsonSave {

	private static final Gson GSON = new GsonBuilder()
	        .setPrettyPrinting()
	        .create();
	    // Millisecond‐precision pattern
	    private static final DateTimeFormatter format =
	        DateTimeFormatter.ofPattern("yyyyMMdd HHmmssSSS");

	    /**
	     * Creates a new timestamped JSON file 
	     * If a rare name collision occurs, appends a UUID.
	     */
	    public static void savePets(List<Pet> pets) {
	        //Build base filename with millis
	        String base = LocalDateTime.now().format(format);
	        String filename = base + " pets.json";
	        Path out = Paths.get(filename);

	        String json = GSON.toJson(pets);
	        try {
	            //attempts to create a new file 
	            Files.write(
	                out,
	                json.getBytes(StandardCharsets.UTF_8),
	                StandardOpenOption.CREATE_NEW
	            );
	            System.out.println("Created: " + out.toAbsolutePath());
	        } catch (FileAlreadyExistsException fae) {
	            // Extremely unlikely, but just in case:
	            String alt = base + "_" + UUID.randomUUID() + " pets.json";
	            Path altPath = Paths.get(alt);
	            try {
	                Files.write(
	                    altPath,
	                    json.getBytes(StandardCharsets.UTF_8),
	                    StandardOpenOption.CREATE_NEW
	                );
	                System.out.println("Filename collision—created: " + altPath.toAbsolutePath());
	            } catch (IOException e) {
	                System.err.println("Failed to save after collision: " + e.getMessage());
	            }
	        } catch (IOException e) {
	            System.err.println("Failed to save pets: " + e.getMessage());
	        }
	    }
}
