package app;

public enum Option {
    PRINT_ANIMALS("Pokaż wszystkie zwierzęta"), ADD_ANIMAL("Dodaj psa lub kota."), EXIT("Wyjście z programu");

    String name;

    Option(String name) {
        this.name = name;
    }

    static Option createOption(int option) {
        return Option.values()[option];
    }

    @Override
    public String toString() {
        return "Opcja " + ordinal() + " - " + name;
    }
}
