import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class PokemonManager {
    private Map<String, Pokemon> pokemonMap; // Todos los Pokémon leídos del archivo
    private Map<String, Pokemon> userCollection; // Pokémon del usuario

    public PokemonManager(MapFactory factory) {
        this.pokemonMap = new HashMap<>(); // Siempre usaremos HashMap para almacenar todos los Pokémon
        this.userCollection = factory.createMap();
    }

    // Leer el archivo CSV
    public void loadPokemonData(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Saltar encabezado
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0].trim();
                int pokedexNumber = Integer.parseInt(data[1].trim());
                String type1 = data[2].trim();
                String type2 = data[3].trim().isEmpty() ? null : data[3].trim();
                String classification = data[4].trim();
                double height = Double.parseDouble(data[5].trim());
                double weight = Double.parseDouble(data[6].trim());
                String abilities = data[7].trim();
                int generation = Integer.parseInt(data[8].trim());
                String legendaryStatus = data[9].trim();

                Pokemon pokemon = new Pokemon(name, pokedexNumber, type1, type2, classification, height, weight, abilities, generation, legendaryStatus);
                pokemonMap.put(name.toLowerCase(), pokemon);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Agregar Pokémon a la colección del usuario
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

    // Mostrar datos de un Pokémon
    public void showPokemonData(String name) {
        name = name.toLowerCase();
        if (pokemonMap.containsKey(name)) {
            System.out.println(pokemonMap.get(name));
        } else {
            System.out.println("Error: Pokémon no encontrado.");
        }
    }

    // Mostrar Pokémon en la colección del usuario ordenados por Type1
    public void showUserCollectionByType() {
        userCollection.values().stream()
            .sorted(Comparator.comparing(p -> p.type1))
            .forEach(p -> System.out.println(p.name + " - " + p.type1));
    }

    // Mostrar todos los Pokémon leídos ordenados por Type1
    public void showAllPokemonByType() {
        pokemonMap.values().stream()
            .sorted(Comparator.comparing(p -> p.type1))
            .forEach(p -> System.out.println(p.name + " - " + p.type1));
    }

    // Buscar Pokémon por habilidad
    public void findPokemonByAbility(String ability) {
        pokemonMap.values().stream()
            .filter(p -> Arrays.asList(p.abilities.split(", ")).contains(ability))
            .forEach(p -> System.out.println(p.name + " - " + p.abilities));
    }
}