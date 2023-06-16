import java.util.Collections;
import java.util.ArrayList;
public class GradeList {
    private ArrayList<Double> grades = new ArrayList<Double>();

    public GradeList() {

    }
    public GradeList(ArrayList<Double> grds) {
        grades = grds;
    }

    public double addGrade(double grd) {
        if (grd == 2 || grd == 2.5 || grd == 3 || grd == 3.5 || grd == 4 || grd == 4.5 || grd == 5) {
            grades.add(grd);
            return grd;
        } else {
            return 0;
        }
    }

    public double minGrade() {
        if (grades.size() == 0) {
            return 0;
        } else {
            Collections.sort(grades);
            return grades.get(0);
        }
    }

    public double maxGrade() {
        if (grades.size() == 0) {
            return 0;
        } else {
            grades.sort(Collections.reverseOrder());
            return grades.get(0);
        }
    }

    public double gradesAverage() {
        if (grades.size() == 0) {
            return 0;
        } else {
            double sum = 0;
            for (Double grd : grades) {
                sum += grd;
            }
            return sum / grades.size();
        }
    }

    public ArrayList<Double> returnGrades() {
        return grades;
    }
}
