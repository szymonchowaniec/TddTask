import java.util.HashMap;
import java.util.Map;

public class GradeBook {


    private Map<String, Subject> subjects = new HashMap<>();

    public void addSubject(String subject){
        if(subjects.containsKey(subject)){
            throw new IllegalStateException(String.format("Przednimiot %s juz istnieje!" , subject));
        }
        subjects.put(subject, new Subject(subject));
    }

    public Subject getSubject(String subject1) {
        if(!subjects.containsKey(subject1)){
            throw new IllegalArgumentException(String.format("Przedmiot %s nie jest zapisany w dzienniuczku!",subject1));
        }
        return subjects.get(subject1);
    }


    public void addMark(String subject1, double v) {
        Subject subject = getSubject(subject1);
        subject.addMark(v);
    }


    public int countSubject() {
    return subjects.size();
    }


    public double countAllAverage() {

        double marksSum = 0;
        for(Subject subject : subjects.values()) {
            marksSum += subject.getAverage();
        }
        return marksSum/ subjects.size();
    }



}
