// @ Hoja de trabajo 6
// @ File Name : Main.java
// @ Date : 08/03/2025
// @ Author : Alejandro Manuel Jerez Melgar 24678

package com.api;
import java.util.Scanner;

/**
 * Main class to run the Pokémon management application.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MapFactory factory = null;
        boolean valid = true;

        System.out.println("Selecciona el tipo de Map a usar:");
        System.out.println("1) HashMap");
        System.out.println("2) TreeMap");
        System.out.println("3) LinkedHashMap");

        int choice = getValidInt(scanner, "Ingresa una opción (1-3): ");

        switch (choice) {
            case 1 -> factory = new HashMapFactory();
            case 2 -> factory = new TreeMapFactory();
            case 3 -> factory = new LinkedHashMapFactory();
            default -> {
                System.out.println("Opción inválida, usando HashMap por defecto.");
                factory = new HashMapFactory();
            }
        }

        PokemonManager manager = new PokemonManager(factory);
        manager.loadPokemonData("pokemon_data_pokeapi.csv");

        while (valid) {
            System.out.println("\n Menú:");
            System.out.println("1) Agregar Pokémon");
            System.out.println("2) Mostrar datos de un Pokémon");
            System.out.println("3) Mostrar colección ordenada por tipo");
            System.out.println("4) Mostrar todos los Pokémon ordenados por tipo");
            System.out.println("5) Buscar Pokémon por habilidad");
            System.out.println("6) Salir");
            System.out.print("Elige una opción: ");
            int option = getValidInt(scanner, "Ingresa una opción (1-6): ");

            if (option == 6) valid = false;

            switch (option) {
                case 1 -> {
                    System.out.print("Nombre del Pokémon: ");
                    manager.addPokemonToCollection(scanner.nextLine());
                }
                case 2 -> {
                    System.out.print("Nombre del Pokémon: ");
                    manager.showPokemonData(scanner.nextLine());
                }
                case 3 -> manager.showUserCollectionByType();
                case 4 -> manager.showAllPokemonByType();
                case 5 -> {
                    System.out.print("Habilidad: ");
                    manager.findPokemonByAbility(scanner.nextLine());
                }
                default -> System.out.println("Opción inválida.");
            }
        }

        scanner.close();
    }

    /**
     * Gets a valid integer input from the user.
     * @param scanner the Scanner object to read input.
     * @param message the message to prompt the user.
     * @return a valid integer input.
     */
    public static int getValidInt(Scanner scanner, String message) {
        int number;
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            try {
                number = Integer.parseInt(input);
                return number;
            } catch (NumberFormatException e) {
                System.out.println(" Ingrese un número entero válido.");
            }
        }
    }
}