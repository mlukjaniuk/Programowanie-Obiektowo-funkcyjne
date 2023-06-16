import java.util.ArrayList;
import java.util.function.Predicate;

public class ListaOfert {

    private ArrayList<Lokal> listaOfert;

    public ListaOfert() {
        this.listaOfert = new ArrayList<>();
    }

    public ArrayList<Lokal> pobierzOferty(Predicate<Lokal> predicate) {
        ArrayList<Lokal> lokaleOdfiltrowane = new ArrayList<>();
        for (Lokal lokal : listaOfert) {
            if (predicate.test(lokal)) {
                lokaleOdfiltrowane.add(lokal);
            }
        }
        return lokaleOdfiltrowane;
    }

    public void dodajLokal(Lokal lokal) {
        listaOfert.add(lokal);
        System.out.println(listaOfert);
    }



}
