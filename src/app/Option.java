package app;

public enum Option {
    PRINT_ANIMALS("Pokaż wszystkie zwierzęta"),ADD_CAT("Dodaj kota."), ADD_DOG("Dodaj psa."),EXIT("Wyjście z programu");

    String name;

    Option(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Opcja " + ordinal() + " - " + name;
    }

    static Option createOption (int option){
        return Option.values()[option];
    }
}
