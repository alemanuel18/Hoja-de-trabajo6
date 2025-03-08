// @ Hoja de trabajo 6
// @ File Name : PokemonManager.java
// @ Date : 08/03/2025
// @ Author : Alejandro Manuel Jerez Melgar 24678

package com.api;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Manages the Pokémon data and user collection.
 */
class PokemonManager {
    private Map<String, Pokemon> pokemonMap;
    private Map<String, Pokemon> userCollection;

    /**
     * Constructor to initialize the PokemonManager with a specific MapFactory.
     * @param factory the MapFactory to create the user collection map.
     */
    public PokemonManager(MapFactory factory) {
        this.pokemonMap = new HashMap<>();
        this.userCollection = factory.createMap();
    }

    /**
     * Loads Pokémon data from a CSV file.
     * @param filePath the path to the CSV file.
     */
    public void loadPokemonData(String filePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("ERROR: No se encontró el archivo " + filePath);
            System.exit(1);
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Ignorar encabezado
            while ((line = br.readLine()) != null) {
                // 🔹 Manejo de comas dentro de comillas
                String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                if (data.length < 10) continue;

                String name = data[0].trim();
                int pokedexNumber = Integer.parseInt(data[1].trim());
                String type1 = data[2].trim();
                String type2 = data[3].trim().isEmpty() ? null : data[3].trim();
                String classification = data[4].trim();
                double height = Double.parseDouble(data[5].trim());
                double weight = Double.parseDouble(data[6].trim());
                String abilities = data[7].trim().replace("\"", ""); // 🔹 Elimina comillas dobles
                int generation = Integer.parseInt(data[8].trim());
                String legendaryStatus = data[9].trim();

                Pokemon pokemon = new Pokemon(name, pokedexNumber, type1, type2, classification, height, weight, abilities, generation, legendaryStatus);
                pokemonMap.put(name.toLowerCase(), pokemon);
            }

            System.out.println("Datos de Pokémon cargados correctamente.");

        } catch (IOException | NumberFormatException e) {
            System.out.println("ERROR al leer el archivo: " + e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Adds a Pokémon to the user's collection.
     * @param name the name of the Pokémon to add.
     */
    public void addPokemonToCollection(String name) {
        name = name.toLowerCase();
        if (!pokemonMap.containsKey(name)) {
            System.out.println("Error: El Pokémon no existe en la base de datos.");
        } else if (userCollection.containsKey(name)) {
            System.out.println("El Pokémon ya está en tu colección.");
        } else {
            userCollection.put(name, pokemonMap.get(name));
            System.out.println("Pokémon agregado exitosamente.");
        }
    }

    /**
     * Shows the data of a specific Pokémon.
     * @param name the name of the Pokémon to show.
     */
    public void showPokemonData(String name) {
        name = name.toLowerCase();
        if (pokemonMap.containsKey(name)) {
            System.out.println(pokemonMap.get(name));
        } else {
            System.out.println("Error: Pokémon no encontrado.");
        }
    }

    /**
     * Shows the user's Pokémon collection ordered by Type1.
     */
    public void showUserCollectionByType() {
        userCollection.values().stream()
            .sorted(Comparator.comparing(p -> p.type1))
            .forEach(p -> System.out.println(p.name + " - " + p.type1));
    }

    /**
     * Shows all the loaded Pokémon ordered by Type1.
     */
    public void showAllPokemonByType() {
        pokemonMap.values().stream()
            .sorted(Comparator.comparing(p -> p.type1))
            .forEach(p -> System.out.println(p.name + " - " + p.type1));
    }

    /**
     * Finds Pokémon by a specific ability.
     * @param ability the ability to search for.
     */
    public void findPokemonByAbility(String ability) {
        pokemonMap.values().stream()
            .filter(p -> Arrays.asList(p.abilities.split(", ")).contains(ability))
            .forEach(p -> System.out.println(p.name + " - " + p.abilities));
    }
}