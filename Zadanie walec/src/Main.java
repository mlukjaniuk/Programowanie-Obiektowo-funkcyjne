import java.util.Scanner;
import java.io.*;
public class Main {
    private static void printParams(Walec walec) {
        System.out.println("Promień: " + walec.zwrocPromienPodstawy());
        System.out.println("Wysokość: " + walec.zwrocWysokosc());
    }
    private static void setParams(Walec walec) throws IOException {
        System.out.println("Wpisz wartości promienia i wysokości w jednej linii oddzielone spacją:");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] varInput;
        varInput = in.readLine().split(" ");
        int r;
        int h;
        r = Integer.parseInt(varInput[0]);
        h = Integer.parseInt(varInput[1]);
        walec.ustawPromienPodstawy(r);
        walec.ustawWysokosc(h);
        System.out.println("Wartości zmiennych zostały zmienione.");
    }
    private static void calculateSurfaceAreasAndVolume(Walec walec) {
        System.out.println("Pole podstawy: " + walec.obliczPolePowierzchniPodstawy());
        System.out.println("Pole powierzchni bocznej: " + walec.obliczPolePowierzchniBocznej());
        System.out.println("Pole całkowite: " + walec.obliczPolePowierzchniCalkowitej());
        System.out.println("Objętość: " + walec.obliczObjetosc());
    }
    private static void menu() {
        System.out.println("\nProgram umożliwia poniższe operacje na obiekcie klasy Walec " +
                "(wpisz odpowiednią literę):\n" +
                "a: Wyświetlenie wartości promienia podstawy i wysokości,\n" +
                "b: Zmiana wartości powyższych zmiennych,\n" +
                "c: Obliczenie pól powierzchni i objętości.\n" +
                "Wyjść z programu można wpisując literę \"x\".");
    }
    public static void main(String[] args) throws IOException {
        Walec walec = new Walec();
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
                case "a" -> printParams(walec);
                case "b" -> setParams(walec);
                case "c" -> calculateSurfaceAreasAndVolume(walec);
                default -> System.out.println("Wybierz prawidłową opcję!");
            }
        }
    }
}