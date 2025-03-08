// @ Hoja de trabajo 6
// @ File Name : Pokemon.java
// @ Date : 08/03/2025
// @ Author : Alejandro Manuel Jerez Melgar 24678

package com.api;

/**
 * Represents a Pokémon with various attributes.
 */
class Pokemon {
    String name, type1, type2, classification, abilities, legendaryStatus;
    int pokedexNumber, generation;
    double height, weight;

    /**
     * Constructor to initialize a Pokémon object.
     * @param name the name of the Pokémon.
     * @param pokedexNumber the Pokédex number of the Pokémon.
     * @param type1 the primary type of the Pokémon.
     * @param type2 the secondary type of the Pokémon (can be null).
     * @param classification the classification of the Pokémon.
     * @param height the height of the Pokémon.
     * @param weight the weight of the Pokémon.
     * @param abilities the abilities of the Pokémon.
     * @param generation the generation of the Pokémon.
     * @param legendaryStatus the legendary status of the Pokémon.
     */
    public Pokemon(String name, int pokedexNumber, String type1, String type2, String classification, double height, double weight, String abilities, int generation, String legendaryStatus) {
        this.name = name;
        this.pokedexNumber = pokedexNumber;
        this.type1 = type1;
        this.type2 = type2;
        this.classification = classification;
        this.height = height;
        this.weight = weight;
        this.abilities = abilities;
        this.generation = generation;
        this.legendaryStatus = legendaryStatus;
    }

    /**
     * Returns a string representation of the Pokémon.
     * @return a string representation of the Pokémon.
     */
    @Override
    public String toString() {
        return String.format("Pokedex #%d - %s\nTipo: %s %s\nClasificación: %s\nAltura: %.2fm, Peso: %.2fkg\nHabilidades: %s\nGeneración: %d\nLegendario: %s\n", pokedexNumber, name, type1, (type2 == null ? "" : type2), classification, height, weight, abilities, generation, legendaryStatus);
    }
}