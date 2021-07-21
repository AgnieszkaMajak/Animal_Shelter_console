package data;

import java.util.Objects;

public abstract class Animal {
    private String name;
    private int animalId;
    private int age;
    private double weight;
    private boolean castrated;

    public Animal(String name, int animalId, int age, double weight, boolean castrated) {
        this.name = name;
        this.animalId = animalId;
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

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
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
        return age == animal.age && Double.compare(animal.weight, weight) == 0 && Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, weight);
    }

}
