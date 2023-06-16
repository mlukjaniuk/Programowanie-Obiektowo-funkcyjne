import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Podaj liczbę całkowitą n, a program policzy wartość n! lub wpisz \"x\" aby zakończyć:");
        boolean onGoing = true;
        while (onGoing) {
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            if (input.equals("x") || input.equals("X")) {
                System.out.println("Program zakończył działanie.");
                onGoing = false;
            } else if (isParsePossible(input)){
                System.out.println("Wartość n! wynosi: " + factorial(Integer.parseInt(input)));
            } else {
                System.out.println("Podaj prawidłową liczbę!");
            }
        }
    }
    public static long factorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
    public static boolean isParsePossible(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
