package data;

public class Cat extends Animal {
    private final String DESCRIPTION = "kot";

    public Cat(String name, int animalId, int age, double weight, boolean castrated) {
        super(name, animalId, age, weight, castrated);
    }

    @Override
    public String toString() {
        if (isCastrated())
            return String.format("ID zwierzęcia %d. To zwierzę gatunku: %s, o imieniu: %s. Waży %.1fkg. " +
                    "Wykastrowany? Tak.\n", getAnimalId(), DESCRIPTION, getName(), getWeight());
        else
            return String.format("ID zwierzęcia %d. To zwierzę gatunku: %s, o imieniu: %s. Waży %.1fkg. " +
                    "Wykastrowany? Nie.\n", getAnimalId(), DESCRIPTION, getName(), getWeight());
    }
}
