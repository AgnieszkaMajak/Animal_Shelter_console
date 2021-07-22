package app;

import controller.DataPrinter;
import controller.DataReader;
import data.Animal;
import data.Cat;
import data.Dog;
import data.Shelter;
import exception.NegativeNumberException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Map;


public class ShelterControl {
    private final Shelter shelter = new Shelter();
    private final DataReader reader = new DataReader();
    private final DataPrinter printer = new DataPrinter();

    void startApp() {

        Option option = null;
        do {
            try {
                printOptions();
                option = getOption();
                switch (option) {
                    case ADD_CAT:
                        addCat();
                        break;
                    case ADD_DOG:
                        addDog();
                        break;
                    case PRINT_ANIMALS:
                        printAnimals();
                        break;
                    case EXIT:
                        exit();
                        break;
                    default:
                        printer.printText("Brak takiej opcji, spróbuj ponownie.");

                }
            } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                printer.printText("Błędny wybór. Spróbuj ponownie.");
                reader.clearBuffer();
            }catch (NegativeNumberException e){
                printer.printText("Liczba nie może być ujemna ani nie może być zerem. Spróbuj ponownie.");
                reader.clearBuffer();
            }
        }
        while (option != Option.EXIT);
    }


    private void addDog() {
        Dog dog = reader.readAndCreateDog();
        shelter.addToAnimals(dog);
    }

    private void addCat() {
        Cat cat = reader.readAndCreateCat();
        shelter.addToAnimals(cat);
    }

    private void printAnimals() {
        Map<Integer, Animal> animals = shelter.getAnimals();
        System.out.println(animals);
    }

    private void exit() {
        reader.close();
        printer.printText("Koniec programu.");
    }

    private Option getOption() {
        return Option.createOption(reader.getInt());
    }

    private void printOptions() {
        printer.printText("Wybierz jedną z opcji:");
        for (Option option : Option.values()) {
            printer.printText(option.toString());
        }
    }

}
