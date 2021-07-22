package data;

public class Dog extends Animal {
    private final String DESCRIPTION = "pies";

    public Dog(String name, int age, double weight, boolean castrated) {
        super(name, age, weight, castrated);
    }

    @Override
    public String toString() {
        if (isCastrated())
            return String.format("Gatunek: %s, o imieniu: %s. Waży %.1fkg. " +
                    "Wykastrowany? Tak.\n", DESCRIPTION, getName(), getWeight());
        else
            return String.format("Gatunek: %s, o imieniu: %s. Waży %.1fkg. " +
                    "Wykastrowany? Nie.\n", DESCRIPTION, getName(), getWeight());
    }
}
