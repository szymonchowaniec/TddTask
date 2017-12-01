import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class GradeBookTest {

    private static final String subject1 = "Wychowanie Fizyczne";
    private static final String subject2 = "Przysposobienie Obronne";
    private GradeBook gradeBook;

    @Before
    public void setUp(){
         gradeBook = new GradeBook();
         gradeBook.addSubject(subject1);
    }


    @Test
    public void shouldCreateGradeBok() {
        GradeBook book = new GradeBook();
        assertNotNull(book);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotAllowAddSubjectThatAlreadyExists(){
        gradeBook.addSubject(subject1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shoulNotAllowGetSubjectThatNotExist(){
        gradeBook.getSubject(subject2);
    }

    @Test
    public void shouldGetValidSubject(){
        Subject subject = gradeBook.getSubject(subject1);
        assertEquals(subject1,subject.getName());
    }

    @Test
    public void shouldBeAbleToAddMark(){
        gradeBook.addMark(subject1, 3.5);
    }



    @Test
    public void howManySubject(){

        //given
        gradeBook.addSubject("Podstawy Przedsiębiorczości");

        //when
        int countSubject = gradeBook.countSubject();

        //then

        assertThat(countSubject,is(2));

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldntAllowToAddANoteToNonExistingSubject() {
        GradeBook gradeBook = new GradeBook();
        gradeBook.addMark(subject1, 4.5);
    }

    @Test
    public void shouldComputeGlobalAverageNote()  {
        gradeBook.addSubject(subject2);
        gradeBook.addMark(subject1, 3);
        gradeBook.addMark(subject1, 5);
        gradeBook.addMark(subject2, 2);
        gradeBook.addMark(subject2, 4);

        assertEquals(3.5, gradeBook.countAllAverage(), 0.001);
    }

}