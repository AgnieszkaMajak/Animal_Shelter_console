package app;

import controller.DataPrinter;
import controller.DataReader;
import controller.ReadFile;
import data.Animal;
import data.Cat;
import data.Dog;
import exception.NegativeNumberException;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.TreeMap;


public class ShelterControl {
    private final DataReader reader = new DataReader();
    private TreeMap<Integer, Animal> animals = new TreeMap<>();

    public static void addToAnimals(Animal animal, TreeMap<Integer, Animal> newAnimals) {
        if (newAnimals.isEmpty()) {
            newAnimals.put(1, animal);
        } else {
            int key = newAnimals.lastKey();
            newAnimals.put((key + 1), animal);
        }
    }

    void startApp() {
        String fileName = "animals.csv";
        animals = ReadFile.readAnimalsFromFile(fileName);
        Option option = null;
        do {
            try {
                printOptions();
                option = getOption();
                switch (option) {
                    case ADD_ANIMAL:
                        getDescriptionAndAddAnimal();
                        break;
                    case PRINT_ANIMALS:
                        printAnimals();
                        break;
                    case EXIT:
                        exit();
                        break;
                    default:
                        DataPrinter.printText("Brak takiej opcji, spróbuj ponownie.");

                }
            } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                DataPrinter.printText("Błędny wybór. Spróbuj ponownie.");
                reader.clearBuffer();
            } catch (NegativeNumberException e) {
                DataPrinter.printText("Liczba nie może być ujemna ani nie może być zerem. Spróbuj ponownie.");
                reader.clearBuffer();
            }
        }
        while (option != Option.EXIT);
    }

    private void addDog(Dog dog) {
        addToAnimals(dog);
    }

    private void addCat(Cat cat) {
        addToAnimals(cat);
    }

    private void printAnimals() {
        Map<Integer, Animal> animals = getAnimals();
        System.out.println(animals);
    }

    private void exit() {
        reader.close();
        DataPrinter.printText("Koniec programu.");
    }

    private Option getOption() {
        return Option.createOption(reader.getInt());
    }

    private void printOptions() {
        DataPrinter.printText("Wybierz jedną z opcji:");
        for (Option option : Option.values()) {
            DataPrinter.printText(option.toString());
        }
    }

    private void getDescriptionAndAddAnimal() {
        reader.clearBuffer();
        DataPrinter.printText("Podaj jakiego gatunku jest zwierzę: kot/pies");
        String description = reader.getString();
        description.toLowerCase();
        if (description.equals("kot")) {
            description = "kot";
            Cat cat = readAndCreateCat(description);
            addCat(cat);
        } else if (description.equals("pies")) {
            description = "pies";
            Dog dog = readAndCreateDog(description);
            addDog(dog);
        } else throw new InputMismatchException();
    }

    private Dog readAndCreateDog(String description) {
        DataPrinter.printText("Podaj imię psa:");
        String name = reader.getString();
        DataPrinter.printText("Podaj wiek psa:");
        int age = reader.getIntNoNegative();
        DataPrinter.printText("Podaj wagę psa:");
        double weight = reader.getDoubleNoNegative();
        reader.clearBuffer();
        DataPrinter.printText("Czy pies jest wykastrowany? tak/nie");
        String castrated = reader.getString();
        boolean isCastrated = reader.stringToBoolean(castrated);

        return new Dog(name, description, age, weight, isCastrated);
    }

    private Cat readAndCreateCat(String description) {
        DataPrinter.printText("Podaj imię kota:");
        String name = reader.getString();
        DataPrinter.printText("Podaj wiek kota:");
        int age = reader.getIntNoNegative();
        DataPrinter.printText("Podaj wagę kota:");
        double weight = reader.getDoubleNoNegative();
        reader.clearBuffer();
        DataPrinter.printText("Czy kot jest wykastrowany? tak/nie");
        String castrated = reader.getString();
        boolean isCastrated = reader.stringToBoolean(castrated);

        return new Cat(name, description, age, weight, isCastrated);
    }

    public Map<Integer, Animal> getAnimals() {
        return animals;
    }

    public void addToAnimals(Animal animal) {
        if (animals.isEmpty()) {
            animals.put(1, animal);
        } else {
            int key = animals.lastKey();
            animals.put((key + 1), animal);
        }
    }

}
