import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Kalendarz {

    private ArrayList<ArrayList<Spotkanie>> kalendarz;

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

    public void dodajSpotkanie(String dzien, Spotkanie spotkanie) {
        int intDzien = sprawdzDzien(dzien);
        kalendarz.get(intDzien).add(spotkanie);
        System.out.println(kalendarz);
    }

    public void usunSpotkanie(String dzien, LocalTime czasPoczatku, LocalTime czasZakonczenia) {
        int intDzien = sprawdzDzien(dzien);
        List<Spotkanie> spotkania = kalendarz.get(intDzien);
        spotkania.removeIf(s -> s.zwrocCzasPoczatku().equals(czasPoczatku) && s.zwrocCzasZakonczenia().equals(czasZakonczenia));
        System.out.println(kalendarz);
    }

    public ArrayList<Spotkanie> pobierzSpotkania(String dzien) {
        int intDzien = sprawdzDzien(dzien);
        return kalendarz.get(intDzien);
    }

    public ArrayList<Spotkanie> pobierzSpotkania(String dzien, String priorytet) {
        int intDzien = sprawdzDzien(dzien);
        ArrayList<Spotkanie> spotkania = kalendarz.get(intDzien);
        ArrayList<Spotkanie> spotkaniaZPriorytetem = new ArrayList<>();
        for (Spotkanie s : spotkania) {
            if (s.zwrocPriorytet().equals(priorytet)) {
                spotkaniaZPriorytetem.add(s);
            }
        }
        return spotkaniaZPriorytetem;
    }

    public ArrayList<Spotkanie> pobierzSpotkania(String dzienTygodnia, Predicate<Spotkanie> predicate) {
        ArrayList<Spotkanie> spotkania = pobierzSpotkania(dzienTygodnia);
        ArrayList<Spotkanie> spotkania_odfiltrowane = new ArrayList<>();
        for (Spotkanie spotkanie : spotkania) {
            if (predicate.test(spotkanie)) {
                spotkania_odfiltrowane.add(spotkanie);
            }
        }
        return spotkania_odfiltrowane;
    }
}






