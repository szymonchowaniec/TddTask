import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SubjectTest {



    @Test
    public void shouldCreateSubject(){
        Subject sub = new Subject("Język Polski");
        assertNotNull(sub);
    }

    @Test
    public void averageOfOneSubject(){

        //given
        Subject subject = new Subject("Język Angielski");
        subject.addMark(5);
        subject.addMark(3);
        subject.addMark(5);
        subject.addMark(7);


        //when

        double avarge = subject.getAverage();

        //then

        assertThat(avarge, is(5.0));
    }

}