import java.util.Scanner;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {

    private static void menu() {
        System.out.println("\nProgram umożliwia poniższe operacje na kalendarzu spotkań " +
                "(wpisz odpowiednią literę):\n" +
                "a: Dodanie nowego spotkania,\n" +
                "b: Usunięcie wybranego spotkania,\n" +
                "c: Wyświetlenie wszystkich spotkań w wybranym dniu,\n" +
                "d: Wyświetlenie wszystkich spotkań w wybranym dniu o wybranym priorytecie,\n" +
                "e: Wyświetlenie wszystkich spotkań w wybranym dniu od podanego czasu,\n" +
                "f: Wyświetlenie wszystkich spotkań w wybranym dniu pomiędzy podanymi czasami,\n" +
                "g: Wyświetlenie wszystkich spotkań w wybranym dniu o wybranym priorytecie " +
                        "od podanego czasu.\n" +
                "Wyjść z programu można wpisując literę \"x\".");
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

        if (czasPoczatku.isAfter(Spotkanie.MIN_GODZINA_SPOTKANIA)) {
            kalendarz.dodajSpotkanie(dzien, new Spotkanie(opis, czasPoczatku, czasZakonczenia, priorytet));
        } else {
            System.out.print("Zbyt wczesna godzina spotkania!");
        }
    }

    private static void usuniecieSpotkania(Scanner scanner, Kalendarz kalendarz) {
        System.out.print("Podaj dzień tygodnia (np. Poniedziałek): ");
        String dzien = scanner.nextLine();

        System.out.print("Podaj godzinę rozpoczęcia spotkania (HH:MM): ");
        LocalTime czasPoczatku = LocalTime.parse(scanner.nextLine());

        System.out.print("Podaj godzinę zakończenia spotkania (HH:MM): ");
        LocalTime czasZakonczenia = LocalTime.parse(scanner.nextLine());

        kalendarz.usunSpotkanie(dzien, czasPoczatku, czasZakonczenia);
    }

    private static void wyswietlSpotkaniaDanegoDnia(Scanner scanner, Kalendarz kalendarz) {
        System.out.print("Podaj dzień tygodnia (np. Poniedziałek): ");
        String dzien = scanner.nextLine();

        for (Spotkanie spotkanie : kalendarz.pobierzSpotkania(dzien)) {
            System.out.println(spotkanie.zwrocCzasPoczatku() + " - " + spotkanie.zwrocCzasZakonczenia() + " : " +
                    spotkanie.zwrocOpis() + " PRIORYTET: " + spotkanie.zwrocPriorytet());
        }
    }

    private static void wyswietlSpotkaniaDanegoDniaZPriorytetem(Scanner scanner, Kalendarz kalendarz) {
        System.out.print("Podaj dzień tygodnia (np. Poniedziałek): ");
        String dzien = scanner.nextLine();

        System.out.print("Podaj priorytet (niski, średni, wysoki): ");
        String priorytet = scanner.nextLine();

        for (Spotkanie spotkanie : kalendarz.pobierzSpotkaniaZPriorytetem(dzien, priorytet)) {
            System.out.println(spotkanie.zwrocCzasPoczatku() + " - " + spotkanie.zwrocCzasZakonczenia() + " | " +
                    spotkanie.zwrocOpis() + " | PRIORYTET: " + spotkanie.zwrocPriorytet());

        }
    }

    private static void wyswietlSpotkaniaDanegoDniaOdCzasu(Scanner scanner, Kalendarz kalendarz) {
        System.out.print("Podaj dzień tygodnia (np. Poniedziałek): ");
        String dzien = scanner.nextLine();

        System.out.print("Podaj godzinę rozpoczęcia spotkania (HH:MM): ");
        LocalTime czasPoczatku = LocalTime.parse(scanner.nextLine());

        ArrayList<Spotkanie> spotkania = kalendarz.sprawdzSpotkania(dzien, x -> x.zwrocCzasPoczatku().isAfter(czasPoczatku));
        for (Spotkanie spotkanie : spotkania) {
            System.out.println(spotkanie.zwrocCzasPoczatku() + " - " + spotkanie.zwrocCzasZakonczenia() + " | " +
                    spotkanie.zwrocOpis() + " | PRIORYTET: " + spotkanie.zwrocPriorytet());
        }
    }

    private static void wyswietlSpotkaniaDanegoDniaPomiedzyCzasami(Scanner scanner, Kalendarz kalendarz) {
        System.out.print("Podaj dzień tygodnia (np. Poniedziałek): ");
        String dzien = scanner.nextLine();

        System.out.print("Podaj godzinę rozpoczęcia spotkania (HH:MM): ");
        LocalTime czasPoczatku = LocalTime.parse(scanner.nextLine());

        System.out.print("Podaj godzinę zakończenia spotkania (HH:MM): ");
        LocalTime czasZakonczenia = LocalTime.parse(scanner.nextLine());

        ArrayList<Spotkanie> spotkania = kalendarz.sprawdzSpotkania(dzien, x ->
                (x.zwrocCzasPoczatku().isAfter(czasPoczatku)) && (x.zwrocCzasZakonczenia().isBefore(czasZakonczenia)));
        for (Spotkanie spotkanie : spotkania) {
            System.out.println(spotkanie.zwrocCzasPoczatku() + " - " + spotkanie.zwrocCzasZakonczenia() + " | " +
                    spotkanie.zwrocOpis() + " | PRIORYTET: " + spotkanie.zwrocPriorytet());
        }
    }

    private static void wyswietlSpotkaniaDanegoDniaOWybranymPriorytecieOdDanegoCzasu(Scanner scanner, Kalendarz kalendarz) {
        System.out.print("Podaj dzień tygodnia (np. Poniedziałek): ");
        String dzien = scanner.nextLine();

        System.out.print("Podaj godzinę rozpoczęcia spotkania (HH:MM): ");
        LocalTime czasPoczatku = LocalTime.parse(scanner.nextLine());

        System.out.print("Podaj priorytet (niski, średni, wysoki): ");
        String priorytet = scanner.nextLine();

        ArrayList<Spotkanie> spotkania = kalendarz.sprawdzSpotkania(dzien, x ->
                (x.zwrocCzasPoczatku().isAfter(czasPoczatku)) && (x.zwrocPriorytet().equals(priorytet)));
        for (Spotkanie spotkanie : spotkania) {
            System.out.println(spotkanie.zwrocCzasPoczatku() + " - " + spotkanie.zwrocCzasZakonczenia() + " | " +
                    spotkanie.zwrocOpis() + " | PRIORYTET: " + spotkanie.zwrocPriorytet());
        }
    }

    public static void main(String[] args) {
        Kalendarz kalendarz = new Kalendarz(7);
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
                case "a" -> dodanieSpotkania(new Scanner(System.in), kalendarz);
                case "b" -> usuniecieSpotkania(new Scanner(System.in), kalendarz);
                case "c" -> wyswietlSpotkaniaDanegoDnia(new Scanner(System.in), kalendarz);
                case "d" -> wyswietlSpotkaniaDanegoDniaZPriorytetem(new Scanner(System.in), kalendarz);
                case "e" -> wyswietlSpotkaniaDanegoDniaOdCzasu(new Scanner(System.in), kalendarz);
                case "f" -> wyswietlSpotkaniaDanegoDniaPomiedzyCzasami(new Scanner(System.in), kalendarz);
                case "g" -> wyswietlSpotkaniaDanegoDniaOWybranymPriorytecieOdDanegoCzasu(new Scanner(System.in), kalendarz);
                default -> System.out.println("Wybierz prawidłową opcję!");
            }
        }
    }
}