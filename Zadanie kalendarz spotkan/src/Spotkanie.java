import java.time.LocalTime;

public class Spotkanie {
    private String opis;
    private LocalTime czasPoczatku;
    private LocalTime czasZakonczenia;
    private String priorytet;

    public Spotkanie(String opis, LocalTime czasPoczatku, LocalTime czasZakonczenia, String priorytet) {
        this.opis = opis;
        this.czasPoczatku = czasPoczatku;
        this.czasZakonczenia = czasZakonczenia;
        this.priorytet = priorytet;
    }
    public static final LocalTime MIN_GODZINA_SPOTKANIA = LocalTime.of(9, 0);

    public String zwrocOpis() {
        return opis;
    }

    public LocalTime zwrocCzasPoczatku() {
        return czasPoczatku;
    }

    public LocalTime zwrocCzasZakonczenia() {
        return czasZakonczenia;
    }

    public String zwrocPriorytet() {
        return priorytet;
    }

    @Override
    public String toString() {
        return "Spotkanie{" +
                "nazwa='" + opis + '\'' +
                ", czasPoczatku=" + czasPoczatku +
                ", czasZakonczenia=" + czasZakonczenia +
                ", priorytet=" + priorytet +
                '}';
    }
}
