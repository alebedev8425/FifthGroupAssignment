package edu.mu.adoptme.utilities;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.mu.adoptme.model.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

public class JsonLoad {
    private static final Gson GSON = new Gson();

	/**
     * Reads pets.json **directly** from src/main/resources so that
     * any edits you make to that file (via JsonSave) will be loaded.
     */
    public static List<Pet> loadPets() {
        // Build the path to the *source* resource file:
        Path resourcePath = Paths.get(
            System.getProperty("user.dir"),
            "src", "main", "java", "resources", "pets.json"
        );

        try {
            // Read the entire file
            String json = Files.readString(resourcePath, StandardCharsets.UTF_8);

            // Parse into PetDataHolder
            Type listType = TypeToken.getParameterized(List.class, PetDataHolder.class).getType();
            List<PetDataHolder> holders = GSON.fromJson(json, listType);

            // Convert to real Pet objects
            List<Pet> pets = new ArrayList<>();
            for (PetDataHolder d : holders) {
                Pet pet = null;
                switch (d.type) {
                    case "Dog":
                        pet = new Dog(d.id, d.name, d.age, d.type, d.species, d.adopted);
                        break;
                    case "Cat":
                        pet = new Cat(d.id, d.name, d.age, d.type, d.species, d.adopted);
                        break;
                    case "Rabbit":
                        pet = new Rabbit(d.id, d.name, d.age, d.type, d.species, d.adopted);
                        break;
                    default:
                        System.err.println("Unknown type: " + d.type);
                        continue;
                }
                pet.setType(d.type);
                pets.add(pet);
            }
            return pets;
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to read pets.json from resources", e);
        }
    }
}
