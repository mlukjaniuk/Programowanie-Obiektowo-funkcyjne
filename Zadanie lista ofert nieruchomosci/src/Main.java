import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static void menu() {
        System.out.println("""
                \nProgram umożliwia poniższe operacje na liście ofert sprzedaży mieszkań i domów (wpisz odpowiednią liczbę):
                1: Dodanie nowej oferty sprzedaży domu,
                2: Dodanie nowej oferty sprzedaży mieszkania,
                3: Wyświetlenie aktualnych ofert sprzedaży domów,
                4: Wyświetlenie aktualnych ofert sprzedaży mieszkań,
                5: Wyświetlenie aktualnych ofert sprzedaży domów w wybranej miejscowości o powierzchni nie mniejszej niż podana,
                6: Wyświetlenie aktualnych ofert sprzedaży mieszkań w wybranej miejscowości nie droższych niż podana cena od podanego
                piętra wzwyż.
                Wyjść z programu można wpisując literę "x".""");
    }

    private static void dodanieDomu(Scanner scanner, ListaOfert listaOfert) {
        System.out.print("Podaj ulicę: ");
        String ulica = scanner.nextLine();

        System.out.print("Podaj numer domu: ");
        int numerDomu = Integer.parseInt(scanner.nextLine());

        System.out.print("Podaj miejscowość: ");
        String miejscowosc = scanner.nextLine();

        System.out.print("Podaj kod pocztowy: ");
        String kodPocztowy = scanner.nextLine();

        System.out.print("Podaj powierzchnię: ");
        float powierzchnia = Float.parseFloat(scanner.nextLine());

        System.out.print("Podaj cenę: ");
        float cena  = Float.parseFloat(scanner.nextLine());

        System.out.print("Podaj datę obowiązywania oferty: ");
        LocalDate dataObowiazywaniaOfety = LocalDate.parse(scanner.nextLine());

        System.out.print("Podaj powierzchnię działki: ");
        float powierzchniaDzialki = Float.parseFloat(scanner.nextLine());

        listaOfert.dodajLokal(new Dom(ulica, numerDomu, miejscowosc, kodPocztowy, powierzchnia, cena,
                dataObowiazywaniaOfety, powierzchniaDzialki));
    }

    private static void dodanieMieszkania(Scanner scanner, ListaOfert listaOfert) {
        System.out.print("Podaj ulicę: ");
        String ulica = scanner.nextLine();

        System.out.print("Podaj numer domu: ");
        int numerDomu = Integer.parseInt(scanner.nextLine());

        System.out.print("Podaj miejscowość: ");
        String miejscowosc = scanner.nextLine();

        System.out.print("Podaj kod pocztowy: ");
        String kodPocztowy = scanner.nextLine();

        System.out.print("Podaj powierzchnię: ");
        float powierzchnia = Float.parseFloat(scanner.nextLine());

        System.out.print("Podaj cenę: ");
        float cena  = Float.parseFloat(scanner.nextLine());

        System.out.print("Podaj datę obowiązywania oferty: ");
        LocalDate dataObowiazywaniaOfety = LocalDate.parse(scanner.nextLine());

        System.out.print("Podaj numer piętra: ");
        int numerPietra = Integer.parseInt(scanner.nextLine());

        System.out.print("Podaj numer mieszkania: ");
        int numerMieszkania = Integer.parseInt(scanner.nextLine());

        listaOfert.dodajLokal(new Mieszkanie(ulica, numerDomu, miejscowosc, kodPocztowy, powierzchnia, cena,
                dataObowiazywaniaOfety, numerPietra, numerMieszkania));
        }

    private static void wyswietlenieAktualnychOfertDomow(ListaOfert listaOfert) {
        LocalDate data = LocalDate.now();
        ArrayList<Lokal> domy = listaOfert.pobierzOferty(x -> x instanceof Dom &&
                (x.dataObowiazywaniaOferty.equals(data) || x.dataObowiazywaniaOferty.isAfter(data)));
        System.out.println("Aktualne oferty domów na dzień " + data + ":");
        for (Lokal dom : domy) {
            System.out.println(dom.toString());
        }
    }

    private static void wyswietlenieAktualnychOfertMieszkan(ListaOfert listaOfert) {
        LocalDate data = LocalDate.now();
        ArrayList<Lokal> mieszkania = listaOfert.pobierzOferty(x -> x instanceof Mieszkanie &&
                (x.dataObowiazywaniaOferty.equals(data) || x.dataObowiazywaniaOferty.isAfter(data)));
        System.out.println("Aktualne oferty mieszkań na dzień " + data + ":");
        for (Lokal mieszkanie : mieszkania) {
            System.out.println(mieszkanie.toString());
        }
    }

    private static void wyswietlenieAktualnychOfertDomowZMiejscowosciaIPowierzchnia(Scanner scanner, ListaOfert listaOfert) {
        System.out.print("Podaj miejscowość: ");
        String miejscowosc = scanner.nextLine();

        System.out.print("Podaj powierzchnię: ");
        float powierzchnia = Float.parseFloat(scanner.nextLine());

        LocalDate data = LocalDate.now();
        ArrayList<Lokal> domy = listaOfert.pobierzOferty(x -> x instanceof Dom &&
                (x.dataObowiazywaniaOferty.equals(data) || x.dataObowiazywaniaOferty.isAfter(data)) &&
                powierzchnia<=x.powierzchnia &&
                miejscowosc.equals(x.miejscowosc));
        System.out.println("Aktualne oferty domów na dzień " + data + ":");
        for (Lokal dom : domy) {
            System.out.println(dom.toString());
        }
    }


    private static void wyswietlenieAktualnychOfertMieszkanZMiejscowosciaCenaIPietrem(Scanner scanner, ListaOfert listaOfert) {
        System.out.print("Podaj miejscowość: ");
        String miejscowosc = scanner.nextLine();

        System.out.print("Podaj cenę: ");
        float cena = Float.parseFloat(scanner.nextLine());

        System.out.print("Podaj numer piętra: ");
        int numerPietra = Integer.parseInt(scanner.nextLine());

        LocalDate data = LocalDate.now();
        ArrayList<Lokal> mieszkania = listaOfert.pobierzOferty(x -> x instanceof Mieszkanie &&
                (x.dataObowiazywaniaOferty.equals(data) || x.dataObowiazywaniaOferty.isAfter(data)) &&
                numerPietra<=x.powierzchnia &&
                miejscowosc.equals(x.miejscowosc) &&
                cena>=x.cena);
        System.out.println("Aktualne oferty mieszkań na dzień " + data + ":");
        for (Lokal mieszkanie : mieszkania) {
            System.out.println(mieszkanie.toString());
        }
    }

    private static void dodaniePrzykladowychOfert(ListaOfert listaOfert) {
        Dom dom1 = new Dom("Fabryczna", 59, "Poznan", "60-924", 120.0f, 1_184_000.0f, LocalDate.of(2023, 10, 12), 600.0f);
        Dom dom2 = new Dom("Spokojna", 149, "Lublin", "20-074", 150.0f, 1_340_000.0f, LocalDate.of(2023, 12, 4), 800.0f);
        Dom dom3 = new Dom("Lotnicza", 2, "Poznan", "60-934", 200.0f, 2_356_000.0f, LocalDate.of(2023, 5, 20), 1500.0f);
        Mieszkanie mieszkanie1 = new Mieszkanie("Ogrodowa", 13, "Warszawa", "04-568", 27.34f, 140_000.0f, LocalDate.of(2023, 5, 19), 2, 3);
        Mieszkanie mieszkanie2 = new Mieszkanie("Botaniczna", 123, "Warszawa", "05-234", 56.09f, 278_000.0f, LocalDate.of(2023, 7, 19), 5, 12);
        Mieszkanie mieszkanie3 = new Mieszkanie("Azaliowa", 9, "Gdansk", "80-546", 23.09f, 213_000.0f, LocalDate.of(2023, 6, 30), 3, 8);
        listaOfert.dodajLokal(dom1);
        listaOfert.dodajLokal(dom2);
        listaOfert.dodajLokal(dom3);
        listaOfert.dodajLokal(mieszkanie1);
        listaOfert.dodajLokal(mieszkanie2);
        listaOfert.dodajLokal(mieszkanie3);
    }

    public static void main(String[] args) {
        ListaOfert listaOfert = new ListaOfert();
        dodaniePrzykladowychOfert(listaOfert);
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
                case "1" -> dodanieDomu(new Scanner(System.in), listaOfert);
                case "2" -> dodanieMieszkania(new Scanner(System.in), listaOfert);
                case "3" -> wyswietlenieAktualnychOfertDomow(listaOfert);
                case "4" -> wyswietlenieAktualnychOfertMieszkan(listaOfert);
                case "5" -> wyswietlenieAktualnychOfertDomowZMiejscowosciaIPowierzchnia(new Scanner(System.in), listaOfert);
                case "6" -> wyswietlenieAktualnychOfertMieszkanZMiejscowosciaCenaIPietrem(new Scanner(System.in), listaOfert);
                default -> System.out.println("Wybierz prawidłową opcję!");
            }
        }
    }
}