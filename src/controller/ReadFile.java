package controller;

import app.ShelterControl;
import data.Animal;
import data.Cat;
import data.Dog;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class ReadFile {

    public static TreeMap<Integer, Animal> readAnimalsFromFile(String filename) {
        TreeMap<Integer, Animal> animals = new TreeMap<>();
        try {
            Scanner fileReader = new Scanner(new File(filename));
            while (fileReader.hasNextLine()) {
                String[] data = fileReader.nextLine().split(";");
                if (data[1].equals("kot")) {
                    Cat cat = new Cat(data[0], data[1], Integer.parseInt(data[2]),
                            Double.parseDouble(data[3]), Boolean.parseBoolean(data[4]));
                    ShelterControl.addToAnimals(cat, animals);
                } else if (data[1].equals("pies")) {
                    Dog dog = new Dog(data[0], data[1], Integer.parseInt(data[2]),
                            Double.parseDouble(data[3]), Boolean.parseBoolean(data[4]));
                    ShelterControl.addToAnimals(dog, animals);
                }
            }
        } catch (FileNotFoundException e) {
            DataPrinter.printText("Plik nie istnieje.");
        }
        return animals;

    }
}
