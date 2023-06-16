import java.time.LocalTime;

public sealed abstract class Powinnosc permits Zadanie, Spotkanie {

    protected LocalTime czasPoczatku;
    protected LocalTime czasZakonczenia;
    protected String opis;

    public Powinnosc(LocalTime czasPoczatku, LocalTime czasZakonczenia, String opis) {
        this.czasPoczatku = czasPoczatku;
        this.czasZakonczenia = czasZakonczenia;
        this.opis = opis;
    }

    public Powinnosc(LocalTime czasPoczatku, LocalTime czasZakonczenia) {
        this.czasPoczatku = czasPoczatku;
        this.czasZakonczenia = czasZakonczenia;
    }
    public String zwrocOpis() {
        return opis;
    }

    public LocalTime zwrocCzasPoczatku() {
        return czasPoczatku;
    }

    public LocalTime zwrocCzasZakonczenia() {
        return czasZakonczenia;
    }

}
