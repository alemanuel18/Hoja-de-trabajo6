// @ Hoja de trabajo 6
// @ File Name : PokemonManagerTest.java
// @ Date : 08/03/2025
// @ Author : Alejandro Manuel Jerez Melgar 24678

package com.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class PokemonManagerTest {
    private PokemonManager manager;

    @BeforeEach
    void setUp() {
        MapFactory factory = new HashMapFactory();
        manager = new PokemonManager(factory);
        manager.loadPokemonData("src/test/resources/pokemon_data_test.csv");
    }

    @Test
    void testAddPokemonToCollection() {
        manager.addPokemonToCollection("Pikachu");
        assertTrue(manager.getUserCollection().containsKey("pikachu"));
    }

    @Test
    void testShowPokemonData() {
        manager.showPokemonData("Pikachu");
        assertNotNull(manager.getPokemonMap().get("pikachu"));
    }
}
