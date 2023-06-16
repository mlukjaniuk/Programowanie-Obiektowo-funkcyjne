import java.time.LocalDate;
public sealed abstract class Lokal permits Mieszkanie, Dom {

    protected String ulica;
    protected Integer numerDomu;
    protected String miejscowosc;
    protected String kodPocztowy;
    protected Float powierzchnia;
    protected Float cena;
    protected LocalDate dataObowiazywaniaOferty;

    public Lokal(String ulica, Integer numerDomu, String miejscowosc, String kodPocztowy,
                 Float powierzchnia, Float cena, LocalDate dataObowiazywaniaOferty) {
        this.ulica = ulica;
        this.numerDomu = numerDomu;
        this.miejscowosc = miejscowosc;
        this.kodPocztowy = kodPocztowy;
        this.powierzchnia = powierzchnia;
        this.cena = cena;
        this.dataObowiazywaniaOferty = dataObowiazywaniaOferty;
    }

    @Override
    public String toString() {
        return "Lokal{" +
                "numerDomu=" + numerDomu +
                ", miejscowosc=" + miejscowosc +
                ", kodPocztowy=" + kodPocztowy +
                ", powierzchnia=" + powierzchnia +
                ", cena=" + cena +
                ", dataObowiazywaniaOferty=" + dataObowiazywaniaOferty +
                '}';
    }


}
