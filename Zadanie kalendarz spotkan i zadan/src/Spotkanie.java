import java.time.LocalTime;

public final class Spotkanie extends Powinnosc {
    private String priorytet;

    public static final LocalTime MIN_GODZINA_SPOTKANIA = LocalTime.of(9, 0);

    public Spotkanie(LocalTime czasPoczatku, LocalTime czasZakonczenia, String opis, String priorytet) {
        super(czasPoczatku, czasZakonczenia, opis);
        this.priorytet = priorytet;
    }

    public Spotkanie(LocalTime czasPoczatku, LocalTime czasZakonczenia) {
        super(czasPoczatku, czasZakonczenia);
    }

    public String zwrocPriorytet() {
        return priorytet;
    }

    @Override
    public String toString() {
        return "Spotkanie{" +
                "opis='" + opis + '\'' +
                ", czasPoczatku=" + czasPoczatku +
                ", czasZakonczenia=" + czasZakonczenia +
                ", priorytet=" + priorytet +
                '}';
    }
}
