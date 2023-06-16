import java.util.Arrays;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Kalendarz {

    private ArrayList<ArrayList<Powinnosc>> kalendarz;

    private String[] dniTygodnia = new String[] {"Poniedziałek", "Wtorek", "Środa",
            "Czwartek", "Piątek", "Sobota", "Niedziela"};

    public Kalendarz(int rozmiar) {
        kalendarz = new ArrayList<>(rozmiar);

        for(int i = 0; i < rozmiar; i++) {
            kalendarz.add(new ArrayList<>());
        }
    }

    private int sprawdzDzien(String dzien) {
        return Arrays.asList(dniTygodnia).indexOf(dzien);
    }

    public void dodajPowinnosc(String dzien, Powinnosc powinnosc) {
        pobierzPowinnosci(dzien).add(powinnosc);
        System.out.println(kalendarz);
    }

    public void usunSpotkanie(String dzien, Spotkanie spotkanie) {
        ArrayList<Powinnosc> spotkania = pobierzPowinnosci(dzien);
        spotkania.removeIf(s -> s instanceof Zadanie);
        spotkania.removeIf(s -> s.zwrocCzasPoczatku().equals(spotkanie.czasPoczatku) &&
                s.zwrocCzasZakonczenia().equals(spotkanie.czasZakonczenia));
        System.out.println(kalendarz);
    }

    public void usunZadanie(String dzien, Zadanie zadanie) {
        ArrayList<Powinnosc> zadania = pobierzPowinnosci(dzien);
        zadania.removeIf(s -> s instanceof Spotkanie);
        zadania.removeIf(s -> s.zwrocCzasPoczatku().equals(zadanie.czasPoczatku) &&
                s.zwrocCzasZakonczenia().equals(zadanie.czasZakonczenia));
        System.out.println(kalendarz);
    }

    public ArrayList<Powinnosc> pobierzPowinnosci(String dzien) {
        int intDzien = sprawdzDzien(dzien);
        return kalendarz.get(intDzien);
    }

    public ArrayList<Powinnosc> pobierzPowinnosci(String dzienTygodnia, Predicate<Powinnosc> predicate) {
        ArrayList<Powinnosc> powinnosci = pobierzPowinnosci(dzienTygodnia);
        ArrayList<Powinnosc> powinnosciOdfiltrowane = new ArrayList<>();
        for (Powinnosc powinnosc : powinnosci) {
            if (predicate.test(powinnosc)) {
                powinnosciOdfiltrowane.add(powinnosc);
            }
        }
        return powinnosciOdfiltrowane;
    }
}




