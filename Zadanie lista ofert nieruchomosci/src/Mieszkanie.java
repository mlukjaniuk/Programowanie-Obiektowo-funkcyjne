import java.time.LocalDate;

public final class Mieszkanie extends Lokal {

    private Integer numerPietra;
    private Integer numerMieszkania;

    public Mieszkanie(String ulica, Integer numerDomu, String miejscowosc, String kodPocztowy,
                      Float powierzchnia, Float cena, LocalDate dataObowiazywaniaOferty, Integer numerPietra,
                      Integer numerMieszkania) {
        super(ulica, numerDomu, miejscowosc, kodPocztowy, powierzchnia, cena, dataObowiazywaniaOferty);
        this.numerPietra = numerPietra;
        this.numerMieszkania = numerMieszkania;
    }

    @Override
    public String toString() {
        return ("MIESZKANIE | numer domu: %s, miejscowość: %s, kod pocztowy: %s, powierzchnia: %sm2, cena: %szł, " +
                "data obowiązywania oferty: %s, numer piętra: %s, numer mieszkania: %s")
                .formatted(numerDomu, miejscowosc, kodPocztowy, powierzchnia, cena, dataObowiazywaniaOferty, numerPietra, numerMieszkania);
    }
}
