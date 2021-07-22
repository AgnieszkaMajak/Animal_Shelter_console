package controller;

import exception.NegativeNumberException;

import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DataReader {
    private final Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    public void close() {
        scanner.close();
    }

    public boolean stringToBoolean(String text) {
        text.toLowerCase();
        if (text.equals("tak")) {
            return true;
        } else if (text.equals("nie")) {
            return false;
        } else {
            throw new NoSuchElementException();
        }
    }

    public String getString() {
        return scanner.nextLine();
    }

    public double getDouble() {
        return scanner.nextDouble();
    }

    public int getInt() {
        return scanner.nextInt();
    }

    public int getIntNoNegative() {
        int number = scanner.nextInt();
        if (number > 0)
            return number;
        else {
            throw new NegativeNumberException();
        }
    }

    public double getDoubleNoNegative() {
        double number = scanner.nextDouble();
        if (number > 0)
            return number;
        else
            throw new NegativeNumberException();
    }

    public void clearBuffer() {
        scanner.nextLine();
    }

}
