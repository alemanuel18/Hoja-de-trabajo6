

class Pokemon {
    String name, type1, type2, classification, abilities, legendaryStatus;
    int pokedexNumber, generation;
    double height, weight;

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

    @Override
    public String toString() {
        return String.format("Pokedex #%d - %s\nTipo: %s %s\nClasificación: %s\nAltura: %.2fm, Peso: %.2fkg\nHabilidades: %s\nGeneración: %d\nLegendario: %s\n", pokedexNumber, name, type1, (type2 == null ? "" : type2), classification, height, weight, abilities, generation, legendaryStatus);
    }
}