package data;

import java.util.*;

public class Shelter {
    private TreeMap<Integer, Animal> animals = new TreeMap<>();

    public Map<Integer, Animal> getAnimals() {
        return animals;
    }

    public void addToAnimals(Animal animal) {
        if (animals.isEmpty()){
            animals.put(1, animal);
        }else {
            int key = animals.lastKey();
            animals.put((key+1), animal);
        }
    }
}
