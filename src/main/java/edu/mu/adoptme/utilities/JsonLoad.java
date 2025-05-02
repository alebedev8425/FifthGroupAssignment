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

	private static final String EXTERNAL_FILENAME = "pets.json";
    private static final String BUNDLED_PATH      = "/pets.json";
    private static final Gson GSON = new Gson();

    public static List<Pet> loadPets() {
        try {
            Path external = Paths.get(EXTERNAL_FILENAME);
            // 1) If no external file, copy the bundled resource out to cwd
            if (Files.notExists(external)) {
                try (InputStream in = JsonLoad.class.getResourceAsStream(BUNDLED_PATH)) {
                    if (in == null) {
                        throw new FileNotFoundException("Bundled pets.json not found in JAR!");
                    }
                    Files.copy(in, external);
                }
            }

            // 2) Read from the external file
            try (Reader reader = Files.newBufferedReader(external, StandardCharsets.UTF_8)) {
                Type listType = new TypeToken<List<PetDataHolder>>() {}.getType();
                List<PetDataHolder> holders = GSON.fromJson(reader, listType);
                List<Pet> pets = new ArrayList<>();
                for (PetDataHolder d : holders) {
                    switch (d.type) {
                        case "Dog":
                            pets.add(new Dog(d.id, d.name, d.age, d.type, d.species, d.adopted));
                            break;
                        case "Cat":
                            pets.add(new Cat(d.id, d.name, d.age, d.type, d.species, d.adopted));
                            break;
                        case "Rabbit":
                            pets.add(new Rabbit(d.id, d.name, d.age, d.type, d.species, d.adopted));
                            break;
                        default:
}
                }
                return pets;
            }
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to load pets.json", e);
        }
    }

}
