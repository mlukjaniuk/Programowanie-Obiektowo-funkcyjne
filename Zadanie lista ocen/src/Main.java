import java.util.Scanner;

public class Main {

    private static void menu() {
        System.out.println("\nProgram umożliwia poniższe operacje na liście ocen studenta " +
                "(wpisz odpowiednią literę):\n" +
                "a: Dodanie nowej oceny,\n" +
                "b: Wyliczenie średniej ocen,\n" +
                "c: Wyświetlenie najniższej oceny cząstkowej,\n" +
                "d: Wyświetlenie najwyższej oceny cząstkowej.\n" +
                "Wyjść z programu można wpisując literę \"x\".");
        }

    private static void printGradesAverage(GradeList grades) {
        double avg = grades.gradesAverage();
        if (avg == 0) {
            System.out.println("Błąd: nie ma żadnej oceny na liście.");
        } else {
            System.out.println("Średnia ocen wynosi "+ avg);
        }
    }

    private static void addGradeToList(GradeList grades, double grd) {
        double add = grades.addGrade(grd);
        if (add == 0) {
            System.out.println("Błąd: podano nieprawidłową ocenę.");
        } else {
            System.out.println("Dodano ocenę. Obecna lista ocen: " + grades.returnGrades());
        }

    }

    private static void printMinGrade(GradeList grades) {
        double min = grades.minGrade();
        if (min == 0) {
            System.out.println("Błąd: nie ma żadnej oceny na liście.");
        } else {
            System.out.println("Najniższa ocena wynosi "+ min);
        }
    }

    private static void printMaxGrade(GradeList grades) {
        double max = grades.maxGrade();
        if (max == 0) {
            System.out.println("Błąd: nie ma żadnej oceny na liście.");
        } else {
            System.out.println("Najwyższa ocena wynosi "+ max);
        }
    }

    public static void main(String[] args) {
        GradeList grades = new GradeList();
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
                case "a" -> {
                    System.out.println("Podaj ocenę: ");
                    Scanner scanGrade = new Scanner(System.in);
                    double inputGrade = scanGrade.nextDouble();
                    addGradeToList(grades, inputGrade);
                }
                case "b" -> printGradesAverage(grades);
                case "c" -> printMinGrade(grades);
                case "d" -> printMaxGrade(grades);
                default -> System.out.println("Wybierz prawidłową opcję!");
            }
        }
    }
}