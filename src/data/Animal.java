package data;

import java.util.Objects;

public abstract class Animal {
    private String name;
    private String description;
    private int age;
    private double weight;
    private boolean castrated;

    public Animal(String name, String description, int age, double weight, boolean castrated) {
        this.name = name;
        this.description = description;
        this.age = age;
        this.weight = weight;
        this.castrated = castrated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isCastrated() {
        return castrated;
    }

    public void setCastrated(boolean castrated) {
        this.castrated = castrated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age && Double.compare(animal.weight, weight) == 0 && castrated == animal.castrated && Objects.equals(name, animal.name) && Objects.equals(description, animal.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, age, weight, castrated);
    }

    public String toString() {
        if (isCastrated())
            return String.format("Gatunek: %s, o imieniu: %s. Waży %.1fkg. " +
                    "Wykastrowany? Tak.\n", description, name, weight);
        else
            return String.format("Gatunek: %s, o imieniu: %s. Waży %.1fkg. " +
                    "Wykastrowany? Nie.\n", description, name, weight);
    }

}
