import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Subject {



    private final String name;

    private List<Double> marks = new ArrayList<>();


    public Subject(String name) {
        this.name = name;
    }

    public void addMark(double i) {
        marks.add(i);
    }

    public String getName() {
        return name;
    }

    public double getAverage() {
        double marksSum = 0;
        for (double note : marks) {
            marksSum += note;
        }
        return marksSum / marks.size();

    }
}
