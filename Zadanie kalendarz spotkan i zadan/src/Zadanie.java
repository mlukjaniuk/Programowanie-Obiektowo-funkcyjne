import java.time.LocalTime;

public final class Zadanie extends Powinnosc {
    private String status;

    public static final LocalTime MIN_GODZINA_ZADANIA = LocalTime.of(8, 0);

    public Zadanie(LocalTime czasPoczatku, LocalTime czasZakonczenia, String opis, String status) {
        super(czasPoczatku, czasZakonczenia, opis);
        this.status = status;
    }

    public Zadanie(LocalTime czasPoczatku, LocalTime czasZakonczenia) {
        super(czasPoczatku, czasZakonczenia);
    }

    public String zwrocStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Zadanie{" +
                "opis='" + opis + '\'' +
                ", czasPoczatku=" + czasPoczatku +
                ", czasZakonczenia=" + czasZakonczenia +
                ", status=" + status +
                '}';
    }
}
