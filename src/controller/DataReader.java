package controller;

import data.Cat;
import data.Dog;
import exception.NegativeNumberException;

import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DataReader {
    private final Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    private DataPrinter printer = new DataPrinter();

    public Dog readAndCreateDog(){
        clearBuffer();
        printer.printText("Podaj imię psa:");
        String name = getString();
        printer.printText("Podaj ID psa:");
        int id = getIntNoNegative();
        printer.printText("Podaj wiek psa:");
        int age = getIntNoNegative();
        printer.printText("Podaj wagę psa:");
        double weight = getDoubleNoNegative();
        clearBuffer();
        printer.printText("Czy pies jest wykastrowany? tak/nie");
        String castrated = getString();
        boolean isCastrated = stringToBoolean(castrated);

        return new Dog(name, id, age, weight, isCastrated);
    }

    public Cat readAndCreateCat(){
        clearBuffer();
        printer.printText("Podaj imię kota:");
        String name = getString();
        printer.printText("Podaj ID kota:");
        int id = getIntNoNegative();
        printer.printText("Podaj wiek kota:");
        int age = getIntNoNegative();
        printer.printText("Podaj wagę kota:");
        double weight = getDoubleNoNegative();
        clearBuffer();
        printer.printText("Czy kot jest wykastrowany? tak/nie");
        String castrated = getString();
        boolean isCastrated = stringToBoolean(castrated);

        return new Cat(name, id, age, weight, isCastrated);
    }

    public void close(){
        scanner.close();
    }

    private boolean stringToBoolean(String text){
        text.toLowerCase();
        if (text.equals("tak")){
            return true;
        }else if (text.equals("nie")){
            return false;
        }else {
            throw new NoSuchElementException();
        }
    }

    public String getString(){
       return scanner.nextLine();
    }

    public double getDouble(){
        return scanner.nextDouble();
    }

    public int getInt(){
       return scanner.nextInt();
    }

    public int getIntNoNegative(){
        int number = scanner.nextInt();
        if (number>0)
            return number;
        else {
            throw new NegativeNumberException();
        }
    }

    public double getDoubleNoNegative(){
        double number = scanner.nextDouble();
        if (number>0)
            return number;
        else
            throw new NegativeNumberException();
    }

    public void clearBuffer(){
        scanner.nextLine();
    }

}
