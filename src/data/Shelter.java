package data;

import java.util.ArrayList;

public class Shelter {
    private ArrayList<Animal> animals = new ArrayList<>();

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void addToAnimals(Animal animal) {
        animals.add(animal);
    }
}
