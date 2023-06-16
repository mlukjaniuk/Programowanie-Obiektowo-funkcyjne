import java.time.LocalDate;

public final class Dom extends Lokal {

    private Float powierzchniaDzialki;

    public Dom(String ulica, Integer numerDomu, String miejscowosc, String kodPocztowy,
               Float powierzchnia, Float cena, LocalDate dataObowiazywaniaOferty, Float powierzchniaDzialki) {
        super(ulica, numerDomu, miejscowosc, kodPocztowy, powierzchnia, cena, dataObowiazywaniaOferty);
        this.powierzchniaDzialki = powierzchniaDzialki;
    }

    @Override
    public String toString() {
        return ("DOM | numer domu: %s, miejscowość: %s, kod pocztowy: %s, powierzchnia: %sm2, cena: %szł, " +
                "data obowiązywania oferty: %s, powierzchnia działki: %sm2")
                .formatted(numerDomu, miejscowosc, kodPocztowy, powierzchnia, cena, dataObowiazywaniaOferty, powierzchniaDzialki);
    }
}
