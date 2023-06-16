import java.util.Scanner;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {

    private static void menu() {
        System.out.println("""
                \nProgram umożliwia poniższe operacje na kalendarzu spotkań (wpisz odpowiednią literę):
                1: Dodanie nowego spotkania,
                2: Dodanie nowego zadania,
                3: Usunięcie spotkania z wybranego dnia,
                4: Usunięcie zadania z wybranego dnia,
                5: Wyświetlenie wszystkich spotkań w wybranym dniu,
                6: Wyświetlenie wszystkich zadań w wybranym dniu,
                7: Wyświetlenie spotkań w wybranym dniu o wybranym priorytecie,
                8: Wyświetlenie zadań w wybranym dniu o wybranym statusie,
                9: Wyświetlenie spotkań w wybranym dniu o wybranym priorytecie zaczynających się nie wcześniej od podanego czasu,
                10: Wyświetlenie zadań w wybranym dniu o wybranym statusie kończących się nie później od podanego czasu.
                Wyjść z programu można wpisując literę "x".""");
    }

    private static void iterowaniePowinnosci(ArrayList<Powinnosc> powinnosci) {
        for (Powinnosc powinnosc : powinnosci) {
            if (powinnosc instanceof Spotkanie) {
                System.out.println(powinnosc.zwrocCzasPoczatku() + " - " + powinnosc.zwrocCzasZakonczenia() + " | " +
                        powinnosc.zwrocOpis() + " | PRIORYTET: " + ((Spotkanie) powinnosc).zwrocPriorytet());
            }
            else if (powinnosc instanceof Zadanie) {
                System.out.println(powinnosc.zwrocCzasPoczatku() + " - " + powinnosc.zwrocCzasZakonczenia() + " | " +
                        powinnosc.zwrocOpis() + " | STATUS: " + ((Zadanie) powinnosc).zwrocStatus());
            }
        }
    }

    private static void dodanieSpotkania(Scanner scanner, Kalendarz kalendarz) {
        System.out.print("Podaj dzień tygodnia (np. Poniedziałek): ");
        String dzien = scanner.nextLine();

        System.out.print("Podaj opis spotkania: ");
        String opis = scanner.nextLine();

        System.out.print("Podaj godzinę rozpoczęcia spotkania (HH:MM): ");
        LocalTime czasPoczatku = LocalTime.parse(scanner.nextLine());

        System.out.print("Podaj godzinę zakończenia spotkania (HH:MM): ");
        LocalTime czasZakonczenia = LocalTime.parse(scanner.nextLine());

        System.out.print("Podaj priorytet (niski, średni, wysoki): ");
        String priorytet = scanner.nextLine();

        if (czasPoczatku.isAfter(Spotkanie.MIN_GODZINA_SPOTKANIA) || czasPoczatku.equals(Spotkanie.MIN_GODZINA_SPOTKANIA)) {
            kalendarz.dodajPowinnosc(dzien, new Spotkanie(czasPoczatku, czasZakonczenia, opis, priorytet));
        } else {
            System.out.print("Zbyt wczesna godzina spotkania!");
        }
    }

    private static void dodanieZadania(Scanner scanner, Kalendarz kalendarz) {
        System.out.print("Podaj dzień tygodnia (np. Poniedziałek): ");
        String dzien = scanner.nextLine();

        System.out.print("Podaj opis zadania: ");
        String opis = scanner.nextLine();

        System.out.print("Podaj godzinę rozpoczęcia zadania (HH:MM): ");
        LocalTime czasPoczatku = LocalTime.parse(scanner.nextLine());

        System.out.print("Podaj godzinę zakończenia zadania (HH:MM): ");
        LocalTime czasZakonczenia = LocalTime.parse(scanner.nextLine());

        System.out.print("Podaj status (planowane, potwierdzone, realizowane, wykonane): ");
        String status = scanner.nextLine();

        if (czasPoczatku.isAfter(Zadanie.MIN_GODZINA_ZADANIA) || czasPoczatku.equals(Zadanie.MIN_GODZINA_ZADANIA)) {
            kalendarz.dodajPowinnosc(dzien, new Zadanie(czasPoczatku, czasZakonczenia, opis, status));
        } else {
            System.out.print("Zbyt wczesna godzina zadania!");
        }
    }

    private static void usuniecieSpotkania(Scanner scanner, Kalendarz kalendarz) {
        System.out.print("Podaj dzień tygodnia (np. Poniedziałek): ");
        String dzien = scanner.nextLine();

        System.out.print("Podaj godzinę rozpoczęcia spotkania (HH:MM): ");
        LocalTime czasPoczatku = LocalTime.parse(scanner.nextLine());

        System.out.print("Podaj godzinę zakończenia spotkania (HH:MM): ");
        LocalTime czasZakonczenia = LocalTime.parse(scanner.nextLine());

        kalendarz.usunSpotkanie(dzien, new Spotkanie(czasPoczatku, czasZakonczenia));
    }

    private static void usuniecieZadania(Scanner scanner, Kalendarz kalendarz) {
        System.out.print("Podaj dzień tygodnia (np. Poniedziałek): ");
        String dzien = scanner.nextLine();

        System.out.print("Podaj godzinę rozpoczęcia zadania (HH:MM): ");
        LocalTime czasPoczatku = LocalTime.parse(scanner.nextLine());

        System.out.print("Podaj godzinę zakończenia zadania (HH:MM): ");
        LocalTime czasZakonczenia = LocalTime.parse(scanner.nextLine());

        kalendarz.usunZadanie(dzien, new Zadanie(czasPoczatku, czasZakonczenia));
    }

    private static void wyswietlenieSpotkanDanegoDnia(Scanner scanner, Kalendarz kalendarz) {
        System.out.print("Podaj dzień tygodnia (np. Poniedziałek): ");
        String dzien = scanner.nextLine();

        ArrayList<Powinnosc> spotkania = kalendarz.pobierzPowinnosci(dzien, x -> x instanceof Spotkanie);
        iterowaniePowinnosci(spotkania);
    }

    private static void wyswietlenieZadanDanegoDnia(Scanner scanner, Kalendarz kalendarz) {
        System.out.print("Podaj dzień tygodnia (np. Poniedziałek): ");
        String dzien = scanner.nextLine();

        ArrayList<Powinnosc> zadania = kalendarz.pobierzPowinnosci(dzien, x -> x instanceof Zadanie);
        iterowaniePowinnosci(zadania);
    }

    private static void wyswietlenieSpotkanDanegoDniaZPriorytetem(Scanner scanner, Kalendarz kalendarz) {
        System.out.print("Podaj dzień tygodnia (np. Poniedziałek): ");
        String dzien = scanner.nextLine();

        System.out.print("Podaj priorytet (niski, średni, wysoki): ");
        String priorytet = scanner.nextLine();

        ArrayList<Powinnosc> spotkania = kalendarz.pobierzPowinnosci(dzien, x -> x instanceof Spotkanie &&
                priorytet.equals(((Spotkanie) x).zwrocPriorytet()));
        iterowaniePowinnosci(spotkania);
    }

    private static void wyswietlenieZadanDanegoDniaZeStatusem(Scanner scanner, Kalendarz kalendarz) {
        System.out.print("Podaj dzień tygodnia (np. Poniedziałek): ");
        String dzien = scanner.nextLine();

        System.out.print("Podaj status (planowane, potwierdzone, realizowane, wykonane): ");
        String status = scanner.nextLine();

        ArrayList<Powinnosc> zadania = kalendarz.pobierzPowinnosci(dzien, x -> x instanceof Zadanie &&
                status.equals(((Zadanie) x).zwrocStatus()));
        iterowaniePowinnosci(zadania);
    }

    private static void wyswietlenieSpotkanDanegoDniaZPriorytetemNieWczesniejOdDanegoCzasu(Scanner scanner, Kalendarz kalendarz) {
        System.out.print("Podaj dzień tygodnia (np. Poniedziałek): ");
        String dzien = scanner.nextLine();

        System.out.print("Podaj godzinę rozpoczęcia spotkania (HH:MM): ");
        LocalTime czasPoczatku = LocalTime.parse(scanner.nextLine());

        System.out.print("Podaj priorytet (niski, średni, wysoki): ");
        String priorytet = scanner.nextLine();

        ArrayList<Powinnosc> spotkania = kalendarz.pobierzPowinnosci(dzien, x -> x instanceof Spotkanie &&
                (x.zwrocCzasPoczatku().isAfter(czasPoczatku) || x.zwrocCzasPoczatku().equals(czasPoczatku)) &&
                priorytet.equals(((Spotkanie) x).zwrocPriorytet()));
        iterowaniePowinnosci(spotkania);
    }

    private static void wyswietlenieZadanDanegoDniaZeStatusemNiePozniejOdDanegoCzasu(Scanner scanner, Kalendarz kalendarz) {
        System.out.print("Podaj dzień tygodnia (np. Poniedziałek): ");
        String dzien = scanner.nextLine();

        System.out.print("Podaj godzinę zakończenia zadania (HH:MM): ");
        LocalTime czasZakonczenia = LocalTime.parse(scanner.nextLine());

        System.out.print("Podaj status (planowane, potwierdzone, realizowane, wykonane): ");
        String status = scanner.nextLine();

        ArrayList<Powinnosc> zadania = kalendarz.pobierzPowinnosci(dzien, x -> x instanceof Zadanie &&
                (x.zwrocCzasZakonczenia().isBefore(czasZakonczenia) || x.zwrocCzasZakonczenia().equals(czasZakonczenia)) &&
                status.equals(((Zadanie) x).zwrocStatus()));
        iterowaniePowinnosci(zadania);
    }

    private static void dodaniePrzykladowychSpotkanIZadan(Kalendarz kalendarz) {
        Spotkanie spotkanie1 = new Spotkanie(LocalTime.of(10, 0), LocalTime.of(11, 0), "s1", "niski");
        Spotkanie spotkanie2 = new Spotkanie(LocalTime.of(10, 0), LocalTime.of(15, 0), "s2", "średni");
        Spotkanie spotkanie3 = new Spotkanie(LocalTime.of(10, 0), LocalTime.of(16, 0), "s3", "wysoki");
        Spotkanie spotkanie4 = new Spotkanie(LocalTime.of(12, 0), LocalTime.of(14, 0), "s4", "niski");
        Zadanie zadanie1 = new Zadanie(LocalTime.of(10, 0), LocalTime.of(13, 0), "z1", "planowane");
        Zadanie zadanie2 = new Zadanie(LocalTime.of(11, 0), LocalTime.of(12, 0), "z2", "realizowane");
        Zadanie zadanie3 = new Zadanie(LocalTime.of(15, 0), LocalTime.of(17, 0), "z3", "realizowane");
        kalendarz.dodajPowinnosc("Wtorek", spotkanie1);
        kalendarz.dodajPowinnosc("Wtorek", spotkanie2);
        kalendarz.dodajPowinnosc("Wtorek", spotkanie3);
        kalendarz.dodajPowinnosc("Wtorek", spotkanie4);
        kalendarz.dodajPowinnosc("Wtorek", zadanie1);
        kalendarz.dodajPowinnosc("Wtorek", zadanie2);
        kalendarz.dodajPowinnosc("Wtorek", zadanie3);
    }

    public static void main(String[] args) {
        Kalendarz kalendarz = new Kalendarz(7);
        dodaniePrzykladowychSpotkanIZadan(kalendarz);
        boolean onGoing = true;
        while (onGoing) {
            menu();
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            switch (input) {
                case "x" -> {
                    System.out.println("Program zakończył działanie.");
                    onGoing = false;
                }
                case "1" -> dodanieSpotkania(new Scanner(System.in), kalendarz);
                case "2" -> dodanieZadania(new Scanner(System.in), kalendarz);
                case "3" -> usuniecieSpotkania(new Scanner(System.in), kalendarz);
                case "4" -> usuniecieZadania(new Scanner(System.in), kalendarz);
                case "5" -> wyswietlenieSpotkanDanegoDnia(new Scanner(System.in), kalendarz);
                case "6" -> wyswietlenieZadanDanegoDnia(new Scanner(System.in), kalendarz);
                case "7" -> wyswietlenieSpotkanDanegoDniaZPriorytetem(new Scanner(System.in), kalendarz);
                case "8" -> wyswietlenieZadanDanegoDniaZeStatusem(new Scanner(System.in), kalendarz);
                case "9" -> wyswietlenieSpotkanDanegoDniaZPriorytetemNieWczesniejOdDanegoCzasu(new Scanner(System.in), kalendarz);
                case "10" -> wyswietlenieZadanDanegoDniaZeStatusemNiePozniejOdDanegoCzasu(new Scanner(System.in), kalendarz);
                default -> System.out.println("Wybierz prawidłową opcję!");
            }
        }
    }
}